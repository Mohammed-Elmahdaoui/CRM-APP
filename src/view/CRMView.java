package view;

import controller.CRMController;
import model.Customer;

import java.util.Scanner;

public class CRMView {
    private CRMController controller;
    private Scanner scanner;

    public CRMView(CRMController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        controller.addCustomer(name, email, phone);
        System.out.println("Customer added successfully.");
    }

    private void viewCustomers() {
        for (Customer customer : controller.getCustomers()) {
            System.out.println(customer);
        }
    }

    private void updateCustomer() {
        System.out.print("Enter customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine();
        if (controller.updateCustomer(id, name, email, phone)) {
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void deleteCustomer() {
        System.out.print("Enter customer ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (controller.deleteCustomer(id)) {
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }
}
