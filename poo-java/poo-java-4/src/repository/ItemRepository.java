package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepository implements Repository<Item> {
    private final List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>();
    }

    @Override
    public void save(Item item) {
        items.add(item);
    }

    @Override
    public void showAll() {
        for (Item item : items) System.out.println(item);
    }

    @Override
    public Optional<Item> getById(Long id) {
        for (Item item : items) if (item.getCode().equals((id))) return Optional.of(item);
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        items.removeIf(item -> item.getCode().equals(id));
    }

    @Override
    public List<Item> getAll() {
        return items;
    }
}
