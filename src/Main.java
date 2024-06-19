import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Article;
import model.Commande;
import model.Customer;
import model.Facture;
import view.ArticleView;
import view.CommandeView;
import view.CustomerView;
import view.FactureView;

public class Main {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Article> articles = new ArrayList<>();
    private static List<Commande> commandes = new ArrayList<>();
    private static List<Facture> factures = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArticleView articleView = new ArticleView(articles, scanner);
        CommandeView commandeView = new CommandeView(commandes, scanner);
        FactureView factureView = new FactureView(factures, scanner);
        CustomerView customerView = new CustomerView(customers, scanner);

        boolean exit = false;

        while (!exit) {
            System.out.println("Main Menu:");
            System.out.println("1. Articles");
            System.out.println("2. Commandes");
            System.out.println("3. Factures");
            System.out.println("4. Customers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    articleView.showMenu();
                    break;
                case 2:
                    commandeView.showMenu();
                    break;
                case 3:
                    factureView.showMenu();
                    break;
                case 4:
                    customerView.showMenu();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
