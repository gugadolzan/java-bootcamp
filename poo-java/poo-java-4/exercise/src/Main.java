import model.Bill;
import model.Customer;
import model.Item;
import repository.BillRepository;
import repository.CustomerRepository;
import repository.ItemRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BillRepository billRepository = new BillRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        ItemRepository itemRepository = new ItemRepository();

        // Create and save a few customers
        Customer customer = new Customer(1L, "Anthony", "Kiedis");
        customerRepository.save(customer);
        customerRepository.save(new Customer(2L, "Michael", "Balzary"));
        customerRepository.save(new Customer(3L, "Chad", "Smith"));
        customerRepository.save(new Customer(4L, "John", "Frusciante"));
        customerRepository.save(new Customer(5L, "Josh", "Klinghoffer"));

        System.out.println("Customers:");
        customerRepository.showAll();

        System.out.println();

        // Search for a customer by id
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer id to search for: ");
        long id = scanner.nextLong();
        System.out.println(customerRepository.getById(id));

        System.out.println();

        // Delete a customer by id
        System.out.print("Enter customer id to delete: ");
        id = scanner.nextLong();
        customerRepository.deleteById(id);

        System.out.println();

        itemRepository.save(new Item(1L, "Item 1", 10, 100.0));
        itemRepository.save(new Item(2L, "Item 2", 20, 200.0));
        itemRepository.save(new Item(3L, "Item 3", 30, 300.0));
        itemRepository.save(new Item(4L, "Item 4", 40, 400.0));

        System.out.println("Items:");
        itemRepository.showAll();

        System.out.println();

        Bill bill = new Bill(1L, customer, itemRepository.getAll());
        System.out.println("Bill:");
        System.out.println(bill);
    }

}
