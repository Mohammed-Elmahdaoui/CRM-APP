package model;

public class Article {
    private static int MAX_ID = 0;
    private final int id;
    private String ref;
    private String designation;
    private double price;

    // Constructor
    public Article(String ref, String designation, double price) {
        this.id = ++MAX_ID;
        this.ref = ref;
        this.designation = designation;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "Article [id=" + id + ", ref=" + ref + ", designation=" + designation + ", Price=" + price
                + "]";
    }
}
