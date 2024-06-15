package view;

import controller.CRMController;
import model.Contact;
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
            System.out.println("5. Add contact to Customer");
            System.out.println("6. View single customer data");
            System.out.println("7. Exit");
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
                    manageCustomerContact();
                    break;
                case 6:
                    viewSingleCustomer();
                    break;
                case 7:
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

    private void viewSingleCustomer() {
        System.out.println(
                "######################## single customer data ##########################################");
        System.out.print("Enter customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = controller.getCustomerById(id);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println(customer);
        System.out.println("Customer contacts");
        customer.getContacts().forEach(item -> System.out.println("\t" + item));
        System.out.println(
                "######################## single customer data ##########################################");
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

    private void manageCustomerContact() {
        System.out.println("The list of all customers");
        viewCustomers();
        System.out.print("Enter customer ID to update: ");
        int id = scanner.nextInt();
        var customer = controller.getCustomerById(id);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        System.out.println("add contact to Customer : " + customer.getName());

        while (true) {
            var contact = new Contact();
            System.out.print("Enter contact name: ");
            String name = scanner.nextLine();
            System.out.print("Enter contact email: ");
            String email = scanner.nextLine();
            System.out.print("Enter contact phone: ");
            String phone = scanner.nextLine();
            contact.setName(name);
            contact.setEmail(email);
            contact.setPhone(phone);

            customer.AddContact(contact);

            // ask user if what to add more contact or exit
            System.out.println("Enter I to insert more or other key to exit :");
            String choice = scanner.nextLine();
            if (choice.equals("I") || choice.equals("i")) {
                System.out.println("Insert other contact.");
            } else {
                break;
            }
        }
    }
}
