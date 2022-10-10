package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements Repository<Customer> {
    private final List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void showAll() {
        for (Customer customer : customers) System.out.println(customer);
    }

    @Override
    public Optional<Customer> getById(Long id) {
        for (Customer customer : customers) if (customer.getId().equals(id)) return Optional.of(customer);
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = getById(id).orElse(null);
        if (customer != null) {
            System.out.println("Customer: " + customer + " was deleted successfully.");
        } else {
            System.out.println("Customer with id " + id + " was not found.");
        }
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}
