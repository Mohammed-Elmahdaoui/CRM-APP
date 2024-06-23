package view;

import java.util.List;
import java.util.Scanner;

import model.Article;
import model.Command;
import model.Customer;
import utils.DataStore;
import utils.ScannerUtil;
import static utils.ConsoleHelpers.clearScreen;

public class ArticleView {
    private final List<Article> articles = DataStore.getArticles();
    private final Scanner scanner = ScannerUtil.getScanner();

    public ArticleView() {
    }

    public void showMenu() {
        clearScreen();
        boolean exit = false;
        while (!exit) {
            System.out.println("Article Menu:");
            System.out.println("1. Add Article");
            System.out.println("2. View Articles");
            System.out.println("3. Update Article");
            System.out.println("4. Delete Article");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                switch (option) {
                    case 1:
                        addArticle();
                        break;
                    case 2:
                        viewArticles(false);
                        break;
                    case 3:
                        updateArticle();
                        break;
                    case 4:
                        deleteArticle();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("\uD83D\uDE14 Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("\uD83D\uDE14 Invalid option. Please try again.");
            }
        }
    }

    private void addArticle() {
        clearScreen();
        System.out.println("########################### - Add article: - ###########################");
        System.out.print("⌨ Enter article reference: ");
        var ref = scanner.nextLine();
        System.out.print("⌨ Enter article designation: ");
        var designation = scanner.nextLine();
        double price = 0.0;
        while (true) {
            try {
                System.out.print("⌨ Enter article price: ");
                price = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("\uD83D\uDE14 Invalid article price. Please try again.");
                // this line for avoid error happening  when calling nextDouble
                scanner.nextLine();
            }
        }
        articles.add(new Article(ref, designation, price));
        System.out.println("\uD83D\uDE00 Article added.");
        System.out.println("#######################################################################");
    }

    private void viewArticles(boolean inOtherView) {
        clearScreen();
        if (inOtherView) {
            System.out.println("Articles List :");
        } else {
            System.out.println("########################### - Articles List - ########################");
        }

        for (Article article : articles) {
            System.out.println(article);
        }

        if (articles.isEmpty()) {
            System.out.println("\uD83D\uDE14 No articles found.");
        }

        if (inOtherView) {
            System.out.println("--------------");
        } else {
            System.out.println("#####################################################################");
        }

    }

    private void updateArticle() {
        clearScreen();
        System.out.println("########################### - Update article: - ###########################");
        viewArticles(true);
        System.out.print("⌨ Enter article ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Article article : articles) {
            if (article.getId() == id) {
                System.out.print("⌨ Enter new article reference: ");
                article.setRef(scanner.nextLine());
                System.out.print("⌨ Enter new article designation: ");
                article.setDesignation(scanner.nextLine());
                while (true) {
                    try {
                        System.out.print("⌨ Enter article price: ");
                        article.setPrice(scanner.nextDouble());
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid article price. Please try again.");
                        // this line for avoid error happening  when calling nextDouble
                        scanner.nextLine();
                    }
                }
                System.out.println("\uD83D\uDE00 Article updated.");
                System.out.println("#####################################################################");
                return;
            }
        }
        System.out.printf("Article not found with this ID {%s}.%n", id);
        System.out.println("#####################################################################");
    }

    private void deleteArticle() {
        clearScreen();
        System.out.println("########################### - Delete article: - ###########################");
        viewArticles(true);
        System.out.print("⌨ Enter article ID to delete or 'I' to exit: ");
        var id = scanner.nextLine();

        if (id.equals("I") || id.equals("i")) {
            System.out.println("\uD83D\uDE2D Operation finished");
            return;
        }

        var result = articles.removeIf(article -> article.getId() == Integer.parseInt(id));
        if (result) {
            System.out.println("\uD83D\uDE00 Article deleted.");
        } else {
            System.out.printf("\uD83D\uDE14 Article not found with this ID {%s}.%n", id);
        }
        System.out.println("###########################################################################");
    }
}
