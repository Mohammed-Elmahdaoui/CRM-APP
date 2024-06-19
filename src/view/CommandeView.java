package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Commande;

public class CommandeView {
    private List<Commande> commandes;
    private Scanner scanner;

    public CommandeView(List<Commande> commandes, Scanner scanner) {
        this.commandes = commandes;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Commande Menu:");
            System.out.println("1. Create Commande");
            System.out.println("2. View Commandes");
            System.out.println("3. Update Commande");
            System.out.println("4. Delete Commande");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    createCommande();
                    break;
                case 2:
                    viewCommandes();
                    break;
                case 3:
                    updateCommande();
                    break;
                case 4:
                    deleteCommande();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createCommande() {
        System.out.print("Enter commande ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter total: ");
        double total = scanner.nextDouble();
        System.out.print("Enter number of items: ");
        int nbItems = scanner.nextInt();
        List<Integer> commandItemIds = new ArrayList<>();

        for (int i = 0; i < nbItems; i++) {
            System.out.print("Enter item ID: ");
            commandItemIds.add(scanner.nextInt());
        }

        Commande commande = new Commande(id, commandItemIds, total, new Date());
        commandes.add(commande);
        System.out.println("Commande created.");
    }

    private void viewCommandes() {
        System.out.println("Commandes:");
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }

    private void updateCommande() {
        System.out.print("Enter commande ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Commande commande : commandes) {
            if (commande.getId() == id) {
                System.out.print("Enter new total: ");
                commande.setTotal(scanner.nextDouble());
                System.out.print("Enter new number of items: ");
                int nbItems = scanner.nextInt();
                List<Integer> commandItemIds = new ArrayList<>();

                for (int i = 0; i < nbItems; i++) {
                    System.out.print("Enter new item ID: ");
                    commandItemIds.add(scanner.nextInt());
                }

                commande.setCommandItemIds(commandItemIds);
                System.out.println("Commande updated.");
                return;
            }
        }
        System.out.println("Commande not found.");
    }

    private void deleteCommande() {
        System.out.print("Enter commande ID to delete: ");
        int id = scanner.nextInt();

        commandes.removeIf(commande -> commande.getId() == id);
        System.out.println("Commande deleted.");
    }
}
