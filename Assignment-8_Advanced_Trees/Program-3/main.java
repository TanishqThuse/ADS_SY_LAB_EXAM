/**Q8) 3)Write a Program to implement AVL tree and perform different rotations
on it. */

// AVL Tree Node
class AVLTree {
    
    static class Node {
        int data;
        Node left, right;
        int height;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;  // New node is initially at height 1
        }
    }

    private Node root;

    // Function to get the height of the tree
    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    // Function to get the balance factor of a node
    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right Rotation
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return the new root
        return x;
    }

    // Left Rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return the new root
        return y;
    }

    // Left-Right Rotation
    private Node leftRightRotate(Node node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    // Right-Left Rotation
    private Node rightLeftRotate(Node node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    // Insert a node and balance the tree
    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        // Perform normal BST insert
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            // Duplicates are not allowed in the AVL tree
            return node;
        }

        // Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor to check whether the node became unbalanced
        int balance = getBalance(node);

        // Left-Left Case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // Right-Right Case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // Left-Right Case
        if (balance > 1 && data > node.left.data) {
            return leftRightRotate(node);
        }

        // Right-Left Case
        if (balance < -1 && data < node.right.data) {
            return rightLeftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Preorder Traversal (for testing)
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Main function to test the AVL tree implementation
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Node root = null;

        // Insert nodes
        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 15);
        root = tree.insert(root, 25);
        root = tree.insert(root, 5);
        root = tree.insert(root, 12);

        System.out.println("Preorder traversal of the AVL tree:");
        tree.preorder(root);  // Expected balanced tree after rotations

        // After inserting nodes, the AVL tree should automatically
        // balance itself using rotations (right or left).
    }
}
