package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final List<Product> inventory = new ArrayList<>();
    private int currentId = 1;

    public List<Product> getAll() {
        return inventory;
    }

    public Optional<Product> findById(int id) {
        return inventory.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void add(Product product) {
        product.setId(currentId++);
        inventory.add(product);
    }

    public void update(Product product) {
        inventory.removeIf(p -> p.getId() == product.getId());
        inventory.add(product);
    }

    public boolean delete(int id) {
        return inventory.removeIf(p -> p.getId() == id);
    }

    public void loadInventory(List<Product> products) {
        inventory.clear();
        inventory.addAll(products);
        currentId = inventory.stream().mapToInt(Product::getId).max().orElse(0) + 1;
    }
}