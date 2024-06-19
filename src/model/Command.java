package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


public class Command {
    private static int MAX_ID = 0;
    private final int id;
    private final List<Article> articles;
    private double total;
    private LocalDateTime date;
    private Customer customer;

    // Constructor
    public Command() {
        this.id = ++MAX_ID;
        this.date = LocalDateTime.now();
        this.articles = new ArrayList<Article>();
        this.total = 0.0;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
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
        // set total
        this.total = this.total + article.getPrice();
    }

    // methods to remove article from command
    public boolean RemoveArticle(Article article) {
        return this.articles.remove(article);
    }

    // method to get all article from command
    public List<Article> getArticles() {
        return articles;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder articlesString = new StringBuilder();
        for (Article article : articles) {
            articlesString.append(article.toString()).append("\n");
        }

        return "Command{" +
                "id=" + id +
                ", articles=\n" + articlesString +
                ", total=" + total +
                ", date=" + date +
                ", customer=" + customer.getName() +
                '}';
    }
}


