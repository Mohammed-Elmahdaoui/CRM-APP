package view;

import java.util.List;
import java.util.Scanner;
import model.Article;

public class ArticleView {
    private List<Article> articles;
    private Scanner scanner;

    public ArticleView(List<Article> articles, Scanner scanner) {
        this.articles = articles;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Article Menu:");
            System.out.println("1. Add Article");
            System.out.println("2. View Articles");
            System.out.println("3. Update Article");
            System.out.println("4. Delete Article");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addArticle();
                    break;
                case 2:
                    viewArticles();
                    break;
                case 3:
                    updateArticle();
                    break;
                case 4:
                    deleteArticle();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addArticle() {
        System.out.print("Enter article ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter article reference: ");
        String ref = scanner.nextLine();
        System.out.print("Enter article designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter article price: ");
        double prix = scanner.nextDouble();
        System.out.print("Enter article quantity in stock: ");
        int quantityStock = scanner.nextInt();

        articles.add(new Article(id, ref, designation, prix, quantityStock));
        System.out.println("Article added.");
    }

    private void viewArticles() {
        System.out.println("Articles:");
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    private void updateArticle() {
        System.out.print("Enter article ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Article article : articles) {
            if (article.getId() == id) {
                System.out.print("Enter new article reference: ");
                article.setRef(scanner.nextLine());
                System.out.print("Enter new article designation: ");
                article.setDesignation(scanner.nextLine());
                System.out.print("Enter new article price: ");
                article.setPrix(scanner.nextDouble());
                System.out.print("Enter new article quantity in stock: ");
                article.setQuantityStock(scanner.nextInt());
                System.out.println("Article updated.");
                return;
            }
        }
        System.out.println("Article not found.");
    }

    private void deleteArticle() {
        System.out.print("Enter article ID to delete: ");
        int id = scanner.nextInt();

        articles.removeIf(article -> article.getId() == id);
        System.out.println("Article deleted.");
    }
}
