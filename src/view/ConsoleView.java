package view;

import model.Product;
import service.ProductService;
import util.JsonUtil;

import java.util.Scanner;

public class ConsoleView {
    private final ProductService service;
    private final Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILE = "inventory.json";

    public ConsoleView(ProductService service) {
        this.service = service;
        service.listProducts().addAll(JsonUtil.loadFromFile(DATA_FILE)); // Load data
    }

    public void start() {
        while (true) {
            System.out.println("\n--- AgilStore Inventory Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addProduct();
                case 2 -> listProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> {
                    JsonUtil.saveToFile(service.listProducts(), DATA_FILE);
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        service.addProduct(name, category, quantity, price);
        System.out.println("Product added!");
    }

    private void listProducts() {
        for (Product product : service.listProducts()) {
            System.out.println(product);
        }
    }

    private void updateProduct() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Category: ");
        String category = scanner.nextLine();

        System.out.print("New Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("New Price: ");
        double price = scanner.nextDouble();

        if (service.updateProduct(id, name, category, quantity, price)) {
            System.out.println("Product updated!");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void deleteProduct() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();

        if (service.deleteProduct(id)) {
            System.out.println("Product deleted!");
        } else {
            System.out.println("Product not found.");
        }
    }
}