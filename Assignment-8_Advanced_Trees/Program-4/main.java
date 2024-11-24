/**Q8) 4)Write a Program to create Inorder Threaded Binary Tree and Traverse it
in Postorder and Preorder way. */

class InorderThreadedBinaryTree {

    // Node class for Tree
    static class Node {
        int data;
        Node left, right;
        boolean leftThread, rightThread;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.leftThread = false;
            this.rightThread = false;
        }
    }

    Node root;

    public InorderThreadedBinaryTree() {
        root = null;
    }

    // Insert a new node
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            Node parent = null;
            while (temp != null) {
                parent = temp;
                if (data < temp.data) {
                    if (!temp.leftThread) {
                        temp = temp.left;
                    } else {
                        break;
                    }
                } else {
                    if (!temp.rightThread) {
                        temp = temp.right;
                    } else {
                        break;
                    }
                }
            }

            if (data < parent.data) {
                parent.left = newNode;
                parent.leftThread = false;
                newNode.right = parent;
                newNode.rightThread = true;
            } else {
                parent.right = newNode;
                parent.rightThread = false;
                newNode.left = parent;
                newNode.leftThread = true;
            }
        }
    }

    // Preorder Traversal (Non-recursive)
    public void preorder() {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            if (!current.leftThread) {
                current = current.left;
            } else if (!current.rightThread) {
                current = current.right;
            } else {
                break;
            }
        }
    }

    // Postorder Traversal (Non-recursive)
    public void postorder() {
        Node current = root;
        while (current != null) {
            if (!current.rightThread) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
    }

    // Inorder Traversal using Threaded Tree (non-recursive)
    public void inorder() {
        Node current = root;
        
        // Traverse to leftmost node
        while (current != null) {
            while (!current.leftThread) {
                current = current.left;
            }
            
            // Print the node
            System.out.print(current.data + " ");
            
            // If right thread exists, print the node and follow the thread
            while (current.rightThread) {
                current = current.right;
                System.out.print(current.data + " ");
            }

            // Move to the right node
            current = current.right;
        }
    }

    public static void main(String[] args) {
        InorderThreadedBinaryTree tree = new InorderThreadedBinaryTree();

        // Insert nodes into the tree
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);

        // Inorder traversal (using threads)
        System.out.println("Inorder Traversal (Threaded):");
        tree.inorder();

        // Preorder traversal
        System.out.println("\nPreorder Traversal:");
        tree.preorder();

        // Postorder traversal
        System.out.println("\nPostorder Traversal:");
        tree.postorder();
    }
}


/**Inorder Traversal (Threaded):
2 5 7 10 12 15 18 
Preorder Traversal:
10 5 2 7 15 12 18 
Postorder Traversal:
 */