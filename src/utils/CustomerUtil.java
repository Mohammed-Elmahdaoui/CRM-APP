package utils;

import java.util.List;
import java.util.Scanner;
import java.util.Optional;
import model.Customer;

public class CustomerUtil {

    private static Scanner scanner = ScannerUtil.getScanner();

    public static Customer selectCustomer(List<Customer> customers) {
        System.out.println("--------------------------- Customers ---------------------------");
        for (var customer : customers) {
            System.out.println(customer);
        }
        System.out.println("-----------------------------------------------------------------");

        while (true) {
            System.out.print("Please select customer ID from this list: ");
            int customerId = scanner.nextInt();
            Optional<Customer> customer = customers.stream().filter(i -> i.getId() == customerId).findFirst();
            if (customer.isPresent()) {
                return customer.get();
            } else {
                System.out.println("Invalid customer ID. Please try again.");
            }
        }
    }
}
