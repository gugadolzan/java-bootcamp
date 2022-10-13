package model;

import java.util.List;

public class Bill {

    private Long code;
    private Customer customer;
    private List<Item> items;

    public Bill(Long code, Customer customer, List<Item> items) {
        this.code = code;
        this.customer = customer;
        this.items = items;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "code=" + code +
                ", customer=" + customer.getName() +
                ", total=" + getTotal() +
                '}';
    }

}
