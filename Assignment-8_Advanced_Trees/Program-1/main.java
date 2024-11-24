/**Q8) 1)Write a Program to create Inorder Threaded Binary Tree and Traverse it
in Inorder and Preorder way.
 */

 class InorderThreadedBinaryTree {
    
    // Node structure for Threaded Binary Tree
    static class Node {
        int data;
        Node left, right;
        boolean leftThread, rightThread;  // Flags for left and right threads
    }

    // Root of the tree
    Node root;
    
    // Constructor
    public InorderThreadedBinaryTree() {
        root = null;
    }
    
    // Helper to create a threaded binary tree
    private Node prev = null;

    // Inorder Threading Function
    public void createInorderThreading(Node node) {
        if (node == null) {
            return;
        }

        // Recursively thread left subtree
        createInorderThreading(node.left);

        // Thread the left pointer if it's null (left thread)
        if (node.left == null) {
            node.leftThread = true;
            node.left = prev;
        }

        // Thread the right pointer if it's null (right thread)
        if (prev != null && prev.right == null) {
            prev.rightThread = true;
            prev.right = node;
        }

        prev = node;

        // Recursively thread right subtree
        createInorderThreading(node.right);
    }

    // Preorder Traversal (Non-recursive)
    public void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " "); // Print node
        if (!node.leftThread) {
            preorderTraversal(node.left);  // Traverse left
        }
        if (!node.rightThread) {
            preorderTraversal(node.right); // Traverse right
        }
    }

    // Inorder Traversal (Non-recursive using threads)
    public void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // Move to leftmost node
        while (node != null && !node.leftThread) {
            node = node.left;
        }

        // Print nodes in inorder using threads
        while (node != null) {
            System.out.print(node.data + " "); // Print current node

            // If the right pointer is a thread, go to the inorder successor
            if (node.rightThread) {
                node = node.right;
            } else {
                node = node.right;
                // Move to the leftmost node of the right subtree
                while (node != null && !node.leftThread) {
                    node = node.left;
                }
            }
        }
    }

    // Function to insert a new node into the tree
    public Node insert(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        newNode.leftThread = newNode.rightThread = false;
        return newNode;
    }

    // Main Function
    public static void main(String[] args) {
        InorderThreadedBinaryTree tree = new InorderThreadedBinaryTree();

        // Manually creating a sample binary tree
        Node root = tree.insert(10);
        root.left = tree.insert(5);
        root.right = tree.insert(20);
        root.left.left = tree.insert(3);
        root.left.right = tree.insert(7);
        root.right.left = tree.insert(15);
        root.right.right = tree.insert(25);

        tree.root = root;

        // Creating Inorder Threading for the tree
        tree.createInorderThreading(tree.root);

        System.out.println("Inorder Traversal (Using Inorder Threading):");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);
    }
}
