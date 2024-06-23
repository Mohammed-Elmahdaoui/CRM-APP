package utils;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Article;
import model.Command;
import model.Issue;
import model.Paiement;

public class DataStore {
    private static final List<Customer> customers = new ArrayList<>();
    private static final List<Article> articles = new ArrayList<>();
    private static final List<Command> commands = new ArrayList<>();
    private static final List<Issue> issues = new ArrayList<>();
    private static final List<Paiement> paiements = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static List<Article> getArticles() {
        return articles;
    }

    public static List<Command> getCommands() {
        return commands;
    }

    public static List<Issue> getIssues() {
        return issues;
    }
    
    public static List<Paiement> getPaiements() {
        return paiements;
    }

    private DataStore() {
        // Prevent instantiation
    }
}
