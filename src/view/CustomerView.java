package view;

import java.util.List;
import java.util.Scanner;

import model.Customer;
import utils.DataStore;
import utils.ScannerUtil;
import static utils.ConsoleHelpers.clearScreen;

public class CustomerView {
    private final List<Customer> customers= DataStore.getCustomers();
    private Scanner scanner = ScannerUtil.getScanner();

    public CustomerView() {}

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Customer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewCustomers(false);
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addCustomer() {
        clearScreen();
        System.out.println("########################### - Add customer: - ###########################");// Consume newline
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        customers.add(new Customer(name, email, phone));
        System.out.println("Customer added.");
        System.out.println("#######################################################################");
    }

    private void viewCustomers(boolean inOtherView) {
        clearScreen();
        if (inOtherView) {
            System.out.println("Customers List :");
        } else {
            System.out.println("########################### - Customers List - ########################");
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        if (inOtherView) {
            System.out.println("--------------");
        } else {
            System.out.println("#####################################################################");
        }
    }

    private void updateCustomer() {
        clearScreen();
        System.out.println("########################### - Update customer: - ###########################");
        viewCustomers(true);

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
                System.out.println("#####################################################################");
                return;
            }
        }
        System.out.printf("Customer not found with this ID {%s}.%n", id);
        System.out.println("#####################################################################");
    }

    private void deleteCustomer() {
        clearScreen();
        System.out.println("########################### - Delete article: - ###########################");
        viewCustomers(true);
        System.out.print("Enter customer ID to delete: ");
        int id = scanner.nextInt();

        var result = customers.removeIf(customer -> customer.getId() == id);
        if (result) {
            System.out.println("Customer deleted.");
        } else {
            System.out.printf("Customer not found with this ID {%s}.%n", id);
        }
        System.out.println("###########################################################################");
    }
}
