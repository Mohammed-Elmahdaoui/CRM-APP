package model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Command {
    private static int MAX_ID = 0;
    private final int id;
    private final List<Article> articles;
    private final List<Paiement> paiements;
    private double total;
    private double rest;
    private LocalDateTime date;
    private Customer customer;

    // Constructor
    public Command() {
        this.id = ++MAX_ID;
        this.date = LocalDateTime.now();
        this.articles = new ArrayList<Article>();
        this.paiements = new ArrayList<Paiement>();
        this.total = 0.0;
        this.rest = 0.0;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public double getRest() {
        return rest;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Setters
    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customer.addCommand(this);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // methods to add new article to command
    public void AddArticle(Article article) {
        // set article to command
        this.articles.add(article);

        // add command in article
        article.addCommand(this);

        // set total
        this.total = this.total + article.getPrice();
    }

    public void AddPaiement(Paiement paiement) {
        // set article to command
        this.paiements.add(paiement);

        // add command in article
        paiement.addCommand(this);

        // set total
        this.rest = this.total - paiements.stream().mapToDouble(i -> i.getMontant()).sum();
    }

    // methods to remove article from command
    public boolean RemoveArticle(Article article) {
        return this.articles.remove(article);
    }

    public boolean RemovePaiement(Paiement paiement) {
        boolean done = this.paiements.remove(paiement);
        if (done) {
            this.rest += paiement.getMontant();
        }
        return done;
    }

    // method to get all article from command
    public List<Article> getArticles() {
        return Collections.unmodifiableList(articles);
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder articlesString = new StringBuilder();
        for (Article article : articles) {
            articlesString.append(article.toString()).append("\n");
        }

        return "Command{" + "id=" + id + ", articles=\n" + articlesString + ", total=" + total
                + ", rest=" + rest + ", date=" + date + ", customer=" + customer.getName() + '}';
    }
}


