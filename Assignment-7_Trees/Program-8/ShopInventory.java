/**Q7) 8)You have to maintain information for a shop owner. For each of the
products sold in his/hers shop the following information is kept: a
unique code, a name, a price, amount in stock, date received, expiration
date. For keeping track of its stock, the clerk would use a computer
program based on a search tree data structure. Write a program to help
this person, by implementing the following operations: • Insert an item
with all its associated data. • Find an item by its code, and support
updating of the item found. • List valid items in lexicographic order of
their names. */

import java.util.Scanner;

class Product {
    int code;
    String name;
    double price;
    int stock;
    String dateReceived;
    String expirationDate;

    // Constructor to initialize product details
    public Product(int code, String name, double price, int stock, String dateReceived, String expirationDate) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.dateReceived = dateReceived;
        this.expirationDate = expirationDate;
    }
}

class ProductNode {
    Product product;
    ProductNode left, right;

    // Constructor to create a new node with a given product
    public ProductNode(Product product) {
        this.product = product;
        this.left = this.right = null;
    }
}

public class ShopInventory {
    private ProductNode root;

    // Constructor to initialize an empty tree
    public ShopInventory() {
        root = null;
    }

    // Method to insert a product into the tree
    public void insertProduct(Product product) {
        root = insertRecursive(root, product);
    }

    // Recursive method to insert a product
    private ProductNode insertRecursive(ProductNode node, Product product) {
        if (node == null) {
            return new ProductNode(product);
        }
        if (product.code < node.product.code) {
            node.left = insertRecursive(node.left, product);
        } else if (product.code > node.product.code) {
            node.right = insertRecursive(node.right, product);
        }
        return node;
    }

    // Method to find a product by code
    public ProductNode findProduct(int code) {
        return findProductRecursive(root, code);
    }

    // Recursive method to find a product by code
    private ProductNode findProductRecursive(ProductNode node, int code) {
        if (node == null || node.product.code == code) {
            return node;
        }
        if (code < node.product.code) {
            return findProductRecursive(node.left, code);
        }
        return findProductRecursive(node.right, code);
    }

    // Method to update product details by code
    public void updateProduct(int code, String name, double price, int stock, String dateReceived, String expirationDate) {
        ProductNode productNode = findProduct(code);
        if (productNode != null) {
            productNode.product.name = name;
            productNode.product.price = price;
            productNode.product.stock = stock;
            productNode.product.dateReceived = dateReceived;
            productNode.product.expirationDate = expirationDate;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found with code: " + code);
        }
    }

    // Method to perform in-order traversal and list products in lexicographic order of their names
    public void listProductsInLexicographicOrder() {
        System.out.println("Products listed in lexicographic order of their names:");
        inOrderTraversal(root);
    }

    // Recursive in-order traversal to list products in lexicographic order of their names
    private void inOrderTraversal(ProductNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println("Code: " + node.product.code + ", Name: " + node.product.name +
                               ", Price: " + node.product.price + ", Stock: " + node.product.stock +
                               ", Date Received: " + node.product.dateReceived + ", Expiration Date: " + node.product.expirationDate);
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        ShopInventory inventory = new ShopInventory();
        Scanner scanner = new Scanner(System.in);

        // Sample products for testing
        inventory.insertProduct(new Product(101, "Milk", 1.5, 100, "2024-11-01", "2024-12-01"));
        inventory.insertProduct(new Product(102, "Bread", 2.0, 50, "2024-11-05", "2024-11-15"));
        inventory.insertProduct(new Product(103, "Cheese", 5.0, 30, "2024-11-03", "2024-11-20"));
        inventory.insertProduct(new Product(104, "Apple", 0.5, 200, "2024-11-07", "2024-11-14"));

        // Listing products initially
        inventory.listProductsInLexicographicOrder();

        // Example of finding and updating a product
        System.out.println("\nUpdating product with code 102:");
        inventory.updateProduct(102, "Whole Wheat Bread", 2.5, 60, "2024-11-05", "2024-11-20");

        // Listing products after update
        inventory.listProductsInLexicographicOrder();

        scanner.close();
    }
}
