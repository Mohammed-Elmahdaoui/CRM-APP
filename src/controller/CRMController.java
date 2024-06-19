package controller;

import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CRMController {
    private List<Customer> customers;
    private int nextId;

    public CRMController() {
        customers = new ArrayList<>();
        nextId = 1;
    }

    public void addCustomer(String name, String email, String phone) {
        customers.add(new Customer(name, email, phone));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public boolean updateCustomer(int id, String name, String email, String phone) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(int id) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customers.remove(customer);
            return true;
        }
        return false;
    }
}
