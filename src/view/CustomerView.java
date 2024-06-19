package view;

import java.util.List;
import java.util.Scanner;
import model.Customer;

public class CustomerView {
    private List<Customer> customers;
    private Scanner scanner;

    public CustomerView(List<Customer> customers, Scanner scanner) {
        this.customers = customers;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Customer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
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
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        customers.add(new Customer(id, name, email, phone));
        System.out.println("Customer added.");
    }

    private void viewCustomers() {
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void updateCustomer() {
        System.out.print("Enter customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.print("Enter new customer name: ");
                customer.setName(scanner.nextLine());
                System.out.print("Enter new customer email: ");
                customer.setEmail(scanner.nextLine());
                System.out.print("Enter new customer phone: ");
                customer.setPhone(scanner.nextLine());
                System.out.println("Customer updated.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private void deleteCustomer() {
        System.out.print("Enter customer ID to delete: ");
        int id = scanner.nextInt();

        customers.removeIf(customer -> customer.getId() == id);
        System.out.println("Customer deleted.");
    }
}
