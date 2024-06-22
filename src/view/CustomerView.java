package view;

import java.util.List;
import java.util.Scanner;

import model.Customer;

import static utils.ConsoleHelpers.clearScreen;
import static utils.EmailValidator.validate;

public class CustomerView {
    private final List<Customer> customers;
    private final Scanner scanner;

    public CustomerView(List<Customer> customers, Scanner scanner) {
        this.customers = customers;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("️⌨ Customer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            try {
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
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("\uD83D\uDE14 Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("\uD83D\uDE14 Invalid option. Please try again.");
            }
        }
    }

    private void addCustomer() {
        clearScreen();
        System.out.println("########################### - Add customer: - ###########################");// Consume newline
        System.out.print("⌨ Enter customer name: ");
        String name = scanner.nextLine();

        // validate email
        String email = "";
        while (true) {
            System.out.print("⌨ Enter customer email: ");
            String userEmail = scanner.nextLine();
            if (validate(userEmail)) {
                email = userEmail;
                break;
            } else {
                System.out.println("\uD83D\uDE14 Invalid email. Please try again.");
            }
        }

        // validate phone
        System.out.print("⌨ Enter customer phone: ");
        String phone = scanner.nextLine();

        customers.add(new Customer(name, email, phone));
        System.out.println("\uD83D\uDE00 Customer added.");
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

        if (customers.isEmpty()) {
            System.out.println("\uD83D\uDE14 No customers found.");
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

        System.out.print("⌨ Enter customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.print("⌨ Enter new customer name: ");
                customer.setName(scanner.nextLine());

                // validate email after set it to the customer
                while (true) {
                    System.out.print("⌨ Enter new customer email: ");
                    String userEmail = scanner.nextLine();
                    if (validate(userEmail)) {
                        customer.setEmail(userEmail);
                        break;
                    } else {
                        System.out.println("\uD83D\uDE14 Invalid email. Please try again.");
                    }
                }

                System.out.print("⌨ Enter new customer phone: ");
                customer.setPhone(scanner.nextLine());
                System.out.println("\uD83D\uDE00 Customer updated.");
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
        System.out.print("⌨ Enter article ID to delete or 'I' to exit: ");
        var id = scanner.nextLine();

        if (id.equals("I") || id.equals("i")) {
            System.out.println("\uD83D\uDE2D Operation finished");
            return;
        }

        var result = customers.removeIf(customer -> customer.getId() == Integer.parseInt(id));
        if (result) {
            System.out.println("\uD83D\uDE00 Customer deleted.");
        } else {
            System.out.printf("\uD83D\uDE14 Customer not found with this ID {%s}.%n", id);
        }
        System.out.println("###########################################################################");
    }
}
