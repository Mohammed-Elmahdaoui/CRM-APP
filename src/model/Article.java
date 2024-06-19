package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Article {
    private static int MAX_ID = 0;
    private final int id;
    private String ref;
    private String designation;
    private double price;
    private final List<Command> commands;

    // Constructor
    public Article(String ref, String designation, double price) {
        this.id = ++MAX_ID;
        this.ref = ref;
        this.designation = designation;
        this.price = price;
        this.commands = new ArrayList<>();
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

    public List<Command> getCommands() {
        return Collections.unmodifiableList(commands);
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    // toString method
    @Override
    public String toString() {
        return "Article [id=" + id + ", ref=" + ref + ", designation=" + designation + ", Price=" + price
                + "]";
    }
}
