package service;

import model.Product;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(String name, String category, int quantity, double price) {
        repository.add(new Product(0, name, category, quantity, price));
    }

    public List<Product> listProducts() {
        return repository.getAll();
    }

    public Optional<Product> findProductById(int id) {
        return repository.findById(id);
    }

    public boolean updateProduct(int id, String name, String category, int quantity, double price) {
        Optional<Product> productOpt = repository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setName(name);
            product.setCategory(category);
            product.setQuantity(quantity);
            product.setPrice(price);
            repository.update(product);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        return repository.delete(id);
    }
}