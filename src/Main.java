import java.util.Scanner;
import utils.ScannerUtil;
import view.ArticleView;
import view.CommandView;
import view.CustomerView;
import view.IssueView;
import view.PaiementView;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = ScannerUtil.getScanner();
        ArticleView articleView = new ArticleView();
        CommandView commandView = new CommandView();
        PaiementView paiementView = new PaiementView();
        CustomerView customerView = new CustomerView();
        IssueView issueView = new IssueView();

        boolean exit = false;

        while (!exit) {
            System.out.println("Main Menu:");
            System.out.println("1. Articles");
            System.out.println("2. Customers");
            System.out.println("3. Commands");
            System.out.println("4. Paiement");
            System.out.println("5. Repport issue");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            try {
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        articleView.showMenu();
                        break;
                    case 2:
                        customerView.showMenu();
                        break;
                    case 3:
                        commandView.showMenu();
                        break;
                    case 4:
                        paiementView.showMenu();
                        break;
                    case 5:
                        issueView.showMenu();
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

        scanner.close();
    }
}
