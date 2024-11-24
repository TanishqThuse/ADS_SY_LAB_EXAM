// Q7) 14) You have to maintain information for a shop owner. For each of the
// products sold in his/hers shop the following information is kept: a
// unique code, a name, a price, amount in stock, date received, expiration
// date. For keeping track of its stock, the clerk would use a computer
// program based on a search tree data structure. Write a program to help
// this person, by implementing the following operations: • Insert an item
// with all its associated data. • List expired items in Prefix order of their
// .txt individual
// 07/11/2015 Subjects & Assignments
// http://172.17.0.24/asportal/manageassign.php 8/8
// names. • List all items. • Delete an item given by its code. • Delete all
// expired items.

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

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

    // Helper function to convert string date to Date object for comparison
    public Date getExpirationDateAsDate() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(this.expirationDate);
        } catch (Exception e) {
            return null;
        }
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

    // Method to find a product by its code
    public ProductNode findProduct(int code) {
        return findProductRecursive(root, code);
    }

    // Recursive method to find a product by its code
    private ProductNode findProductRecursive(ProductNode node, int code) {
        if (node == null || node.product.code == code) {
            return node;
        }
        if (code < node.product.code) {
            return findProductRecursive(node.left, code);
        }
        return findProductRecursive(node.right, code);
    }

    // Method to delete a product by its code
    public void deleteProduct(int code) {
        root = deleteRecursive(root, code);
    }

    // Recursive method to delete a product
    private ProductNode deleteRecursive(ProductNode node, int code) {
        if (node == null) {
            return null;
        }

        if (code < node.product.code) {
            node.left = deleteRecursive(node.left, code);
        } else if (code > node.product.code) {
            node.right = deleteRecursive(node.right, code);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.product = minValue(node.right);
            node.right = deleteRecursive(node.right, node.product.code);
        }
        return node;
    }

    // Helper method to find the smallest product in the right subtree
    private Product minValue(ProductNode node) {
        Product minValueProduct = node.product;
        while (node.left != null) {
            minValueProduct = node.left.product;
            node = node.left;
        }
        return minValueProduct;
    }

    // Method to delete all expired products
    public void deleteExpiredItems() {
        root = deleteExpiredRecursive(root);
    }

    // Recursive method to delete all expired products
    private ProductNode deleteExpiredRecursive(ProductNode node) {
        if (node == null) {
            return null;
        }

        Date currentDate = new Date();
        Date expirationDate = node.product.getExpirationDateAsDate();

        if (expirationDate != null && expirationDate.before(currentDate)) {
            node = deleteRecursive(node, node.product.code);
        }

        node.left = deleteExpiredRecursive(node.left);
        node.right = deleteExpiredRecursive(node.right);

        return node;
    }

    // Method to perform pre-order traversal and list expired items in prefix order
    public void listExpiredItemsInPrefixOrder() {
        System.out.println("Expired products listed in prefix order:");
        listExpiredItemsInPrefixOrderRecursive(root);
    }

    // Recursive method to perform pre-order traversal and list expired items
    private void listExpiredItemsInPrefixOrderRecursive(ProductNode node) {
        if (node != null) {
            Date currentDate = new Date();
            Date expirationDate = node.product.getExpirationDateAsDate();
            if (expirationDate != null && expirationDate.before(currentDate)) {
                System.out.println("Code: " + node.product.code + ", Name: " + node.product.name +
                                   ", Expiration Date: " + node.product.expirationDate);
            }
            listExpiredItemsInPrefixOrderRecursive(node.left);
            listExpiredItemsInPrefixOrderRecursive(node.right);
        }
    }

    // Method to list all products
    public void listAllProducts() {
        System.out.println("All products listed:");
        listAllProductsRecursive(root);
    }

    // Recursive method to list all products in in-order
    private void listAllProductsRecursive(ProductNode node) {
        if (node != null) {
            listAllProductsRecursive(node.left);
            System.out.println("Code: " + node.product.code + ", Name: " + node.product.name +
                               ", Price: " + node.product.price + ", Stock: " + node.product.stock +
                               ", Date Received: " + node.product.dateReceived + ", Expiration Date: " + node.product.expirationDate);
            listAllProductsRecursive(node.right);
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

        // Listing all products
        inventory.listAllProducts();

        // Listing expired products in prefix order
        inventory.listExpiredItemsInPrefixOrder();

        // Deleting an item
        System.out.println("\nDeleting product with code 102:");
        inventory.deleteProduct(102);
        inventory.listAllProducts();

        // Deleting all expired products
        System.out.println("\nDeleting all expired products:");
        inventory.deleteExpiredItems();
        inventory.listAllProducts();

        scanner.close();
    }
}
