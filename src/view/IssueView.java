package view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Date;
import model.Customer;
import model.Issue;
import utils.CustomerUtil;
import utils.DataStore;
import utils.IssueUtil;
import utils.ScannerUtil;
import static utils.ConsoleHelpers.clearScreen;

public class IssueView {
  private List<Issue> issues = DataStore.getIssues();
  private List<Customer> customers = DataStore.getCustomers();
  private Scanner scanner = ScannerUtil.getScanner();

  public IssueView() {}

  public void showMenu() {
    clearScreen();
    boolean exit = false;
    while (!exit) {
      System.out.println("Issue Menu:");
      System.out.println("1. Add Issue");
      System.out.println("2. View Issues");
      System.out.println("3. Update Issue");
      System.out.println("4. Delete Issue");
      System.out.println("0. Back to Main Menu");
      System.out.print("Choose an option: ");
      try {
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (option) {
          case 1:
            addIssue();
            break;
          case 2:
            viewIssues();
            break;
          case 3:
            updateIssue();
            break;
          case 4:
            deleteIssue();
            break;
          case 0:
            exit = true;
            break;
          default:
            System.out.println("Invalid option. Please try again.");
        }
      } catch (Exception e) {
        System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private void addIssue() {
    clearScreen();
    System.out.println("########################### - Add issue: - ###########################");
    Customer selectedCustomer = CustomerUtil.selectCustomer(customers);
    System.out.print("Enter issue detail: ");
    String detail = scanner.nextLine();
    Date createdAt = new Date(); // Current date
    System.out.print("Enter issue feedback: ");
    String feedback = scanner.nextLine();
    System.out.print("Enter issue status: ");
    String status = scanner.nextLine();

    Issue newIssue = new Issue(detail, createdAt, feedback, status);
    issues.add(newIssue);
    selectedCustomer.addIssue(newIssue);

    System.out.println("Issue added.");
    System.out.println("#######################################################################");
  }



  private void viewIssues() {
    clearScreen();
    System.out.println("########################### - Issues List - ########################");
    Customer selectedCustomer = CustomerUtil.selectCustomer(customers);
    List<Issue> filtredIssues =
        issues.stream().filter(issue -> issue.getCustomer().getId() == selectedCustomer.getId())
            .collect(Collectors.toList());
    scanner.nextLine(); // Consume newline
    if (filtredIssues.isEmpty()) {
      System.out.println("No issues found.");
    } else {
      for (Issue issue : filtredIssues) {
        System.out.println(issue);
      }
    }
    System.out.println("#####################################################################");
  }

  private void updateIssue() {
    clearScreen();
    System.out.println("########################### - Update issue: - ###########################");
    Customer selectedCustomer = CustomerUtil.selectCustomer(customers);
    List<Issue> filtredIssues =
        issues.stream().filter(issue -> issue.getCustomer().getId() == selectedCustomer.getId())
            .collect(Collectors.toList());
    scanner.nextLine(); // Consume newline
    if (filtredIssues.isEmpty()) {
      System.out.println("No issues found.");
    } else {
      Issue selectedIssue = IssueUtil.selectIssue(filtredIssues);
      System.out.print("Enter new issue feedback: ");
      selectedIssue.setFeedback(scanner.nextLine());
      System.out.print("Enter new issue status: ");
      selectedIssue.setStatus(scanner.nextLine());
      System.out.println("Issue updated.");
    }
    System.out.println("#####################################################################");
  }

  private void deleteIssue() {
    clearScreen();
    System.out.println("########################### - Delete issue: - ###########################");
    Customer selectedCustomer = CustomerUtil.selectCustomer(customers);
    List<Issue> filtredIssues =
        issues.stream().filter(issue -> issue.getCustomer().getId() == selectedCustomer.getId())
            .collect(Collectors.toList());
    scanner.nextLine(); // Consume newline
    if (filtredIssues.isEmpty()) {
      System.out.println("No issues found.");
    } else {
      Issue selectedIssue = IssueUtil.selectIssue(filtredIssues);
      selectedCustomer.removeIssue(selectedIssue);
      var result = issues.removeIf(issue -> issue.getId() == selectedIssue.getId());
      if (result) {
        System.out.println("Issue deleted.");
      } else {
        System.out.printf("Issue not found with this ID {%s}.%n", selectedIssue.getId());
      }
    }
    System.out
        .println("###########################################################################");
  }
}
