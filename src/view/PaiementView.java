package view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Command;
import model.Customer;
import model.Paiement;
import utils.CommandUtil;
import utils.CustomerUtil;
import utils.DataStore;
import utils.PaiementUtil;
import utils.ScannerUtil;

public class PaiementView {
  private List<Customer> customers = DataStore.getCustomers();
  private List<Command> commands = DataStore.getCommands();
  private List<Paiement> paiements = DataStore.getPaiements();
  private Scanner scanner = ScannerUtil.getScanner();

  public PaiementView() {}

  public void showMenu() {
    boolean exit = false;
    while (!exit) {
      System.out.println("Paiement Menu:");
      System.out.println("1. Add Paiement");
      System.out.println("2. View Paiements");
      System.out.println("3. Delete Paiement");
      System.out.println("0. Back to Main Menu");
      System.out.print("Choose an option: ");
      int option = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (option) {
        case 1:
          addPaiement();
          break;
        case 2:
          viewPaiements();
          break;
        case 3:
          deletePaiement();
          break;
        case 0:
          exit = true;
          break;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private void addPaiement() {
    System.out.println("########################### - Add Paiement - ###########################");
    Customer selectedCustomer = CustomerUtil.selectCustomer(customers);
    List<Command> filtredCommands =
        commands.stream().filter(command -> command.getCustomer().getId() == selectedCustomer.getId())
            .collect(Collectors.toList());
    scanner.nextLine(); // Consume newline
    if (filtredCommands.isEmpty()) {
      System.out.println("No commands found.");
    } else {
      Command selectedCommand = CommandUtil.selectCommand(filtredCommands);
      scanner.nextLine(); // Consume newline

      System.out.print("Enter montant: ");
      double montant = scanner.nextDouble();
      scanner.nextLine(); // Consume newline
      System.out.print("Enter date (yyyy-MM-dd): ");
      String dateString = scanner.nextLine();
      Date date = parseDate(dateString);

      Paiement paiement = new Paiement(selectedCommand.getId(), montant, date);
      paiements.add(paiement);
      System.out.println("Paiement added.");
    }
    System.out.println("#######################################################################");
  }

  private void viewPaiements() {
    System.out.println("########################### - View Paiements - #########################");
    Customer selectedCustomer = CustomerUtil.selectCustomer(customers);
    List<Command> filtredCommands =
        commands.stream().filter(command -> command.getCustomer().getId() == selectedCustomer.getId())
            .collect(Collectors.toList());
    scanner.nextLine(); // Consume newline
    if (filtredCommands.isEmpty()) {
      System.out.println("No commands found.");
    } else {
      Command selectedCommand = CommandUtil.selectCommand(filtredCommands);
      List<Paiement> filtredPaiements =
          paiements.stream().filter(paiement -> paiement.getCommandId() == selectedCommand.getId())
              .collect(Collectors.toList());
      scanner.nextLine(); // Consume newline
      if (filtredPaiements.isEmpty()) {
        System.out.println("No paiements found.");
      } else {
        for (Paiement paiement : filtredPaiements) {
          System.out.println(paiement);
        }
      }
    }
    System.out.println("#######################################################################");
  }

  private void deletePaiement() {
    System.out.println("########################### - Delete Paiement - ########################");
    Customer selectedCustomer = CustomerUtil.selectCustomer(customers);
    List<Command> filtredCommands =
        commands.stream().filter(command -> command.getCustomer().getId() == selectedCustomer.getId())
            .collect(Collectors.toList());
    scanner.nextLine(); // Consume newline
    if (filtredCommands.isEmpty()) {
      System.out.println("No commands found.");
    } else {
      Command selectedCommand = CommandUtil.selectCommand(filtredCommands);
      List<Paiement> filtredPaiements =
          paiements.stream().filter(paiement -> paiement.getCommandId() == selectedCommand.getId())
              .collect(Collectors.toList());
      scanner.nextLine(); // Consume newline
      if (filtredPaiements.isEmpty()) {
        System.out.println("No paiements found.");
      } else {
        Paiement selectedPaiement = PaiementUtil.selectPaiement(filtredPaiements);
        boolean removed = paiements.removeIf(paiement -> paiement.getId() == selectedPaiement.getId());
        if (removed) {
          System.out.println("Paiement deleted.");
        } else {
          System.out.println("Paiement not found with this ID.");
        }
      }
    }
    System.out.println("#######################################################################");
  }

  private Date parseDate(String dateString) {
    try {
      return new Date(dateString);
    } catch (Exception e) {
      System.out.println("Invalid date format. Using current date.");
      return new Date(); // Use current date if parsing fails
    }
  }

}
