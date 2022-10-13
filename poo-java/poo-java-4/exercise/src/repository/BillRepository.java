package repository;

import model.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillRepository implements Repository<Bill> {

    private final List<Bill> bills;

    public BillRepository() {
        this.bills = new ArrayList<>();
    }

    @Override
    public void save(Bill bill) {
        bills.add(bill);
    }

    @Override
    public void showAll() {
        for (Bill bill : bills)
            System.out.println(bill);
    }

    @Override
    public Optional<Bill> getById(Long id) {
        for (Bill bill : bills)
            if (bill.getCode().equals(id))
                return Optional.of(bill);
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        bills.removeIf(bill -> bill.getCode().equals(id));
    }

    @Override
    public List<Bill> getAll() {
        return bills;
    }

}
