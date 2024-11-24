/**Q7) 7)You have to maintain information for a shop owner. For each of the
products sold in his/hers shop the following information is kept: a
unique code, a name, a price, amount in stock, date received, expiration
date. For keeping track of its stock, the clerk would use a computer
program based on a search tree data structure. Write a program to help
this person, by implementing the following operations: • Insert an item
with all its associated data. • Find an item by its code, and support
updating of the item found. • List valid items in lexicographic order of
their names. */

class Product {
    int code;
    String name;
    double price;
    int stock;
    String dateReceived;
    String expirationDate;
    
    // Constructor to initialize product details
    Product(int code, String name, double price, int stock, String dateReceived, String expirationDate) {
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

    // Constructor to create a new node with the given product
    ProductNode(Product product) {
        this.product = product;
        left = right = null;
    }
}

public class ShopInventory {
    ProductNode root;

    // Constructor to initialize an empty inventory (BST)
    public ShopInventory() {
        root = null;
    }

    // Insert a product into the BST by its unique code
    public void insertProduct(Product product) {
        root = insertRecursive(root, product);
    }

    private ProductNode insertRecursive(ProductNode node, Product product) {
        if (node == null) {
            return new ProductNode(product);
        }
        // Insert based on product code
        if (product.code < node.product.code) {
            node.left = insertRecursive(node.left, product);
        } else if (product.code > node.product.code) {
            node.right = insertRecursive(node.right, product);
        }
        return node;
    }

    // Find and update a product by its code
    public void updateProduct(int code, String name, double price, int stock, String dateReceived, String expirationDate) {
        ProductNode productNode = findProductByCode(root, code);
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

    private ProductNode findProductByCode(ProductNode node, int code) {
        if (node == null || node.product.code == code) {
            return node;
        }
        if (code < node.product.code) {
            return findProductByCode(node.left, code);
        }
        return findProductByCode(node.right, code);
    }

    // List all valid products in lexicographic order of their names
    public void listValidProducts() {
        System.out.println("Products in lexicographic order of their names:");
        inorderTraversal(root);
    }

    private void inorderTraversal(ProductNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("Code: " + node.product.code + ", Name: " + node.product.name + 
                               ", Price: " + node.product.price + ", Stock: " + node.product.stock + 
                               ", Received: " + node.product.dateReceived + ", Expiration: " + node.product.expirationDate);
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        ShopInventory inventory = new ShopInventory();

        // Inserting products into the inventory
        inventory.insertProduct(new Product(101, "Milk", 1.5, 100, "2024-11-01", "2024-12-01"));
        inventory.insertProduct(new Product(102, "Bread", 2.0, 50, "2024-11-05", "2024-11-15"));
        inventory.insertProduct(new Product(103, "Cheese", 5.0, 30, "2024-11-03", "2024-11-20"));
        inventory.insertProduct(new Product(104, "Apple", 0.5, 200, "2024-11-07", "2024-11-14"));

        // Listing products in lexicographic order of their names
        inventory.listValidProducts();

        // Finding and updating a product
        inventory.updateProduct(102, "Whole Wheat Bread", 2.5, 60, "2024-11-05", "2024-11-20");

        // Listing products after update
        System.out.println("\nAfter updating product 102:");
        inventory.listValidProducts();
    }
}
