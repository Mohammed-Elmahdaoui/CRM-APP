package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int MAX_ID = 0;
    private final int id;
    private String name;
    private String email;
    private String phone;
    private final List<Command> commands;

    public Customer(String name, String email, String phone) {
        this.id = ++MAX_ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.commands = new ArrayList<>();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }
}
