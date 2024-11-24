// Class to represent a node in the Generalized Linked List (GLL)
class GLLNode {
    boolean isAtom; // Indicates whether the node is an atomic element or a sublist
    char data;      // Stores data (for atomic elements)
    GLLNode next;   // Points to the next node
    GLLNode sublist; // Points to the sublist if this node represents a list
    
    // Constructor for atomic node (single element)
    GLLNode(char data) {
        this.isAtom = true;
        this.data = data;
        this.next = null;
        this.sublist = null;
    }
    
    // Constructor for sublist node
    GLLNode(GLLNode sublist) {
        this.isAtom = false;
        this.data = '\0'; // Not used for sublist nodes
        this.next = null;
        this.sublist = sublist;
    }
}

public class GeneralizedLinkedList {
    
    // Method to create and return a sample Generalized Linked List
    public static GLLNode createSampleGLL() {
        GLLNode a = new GLLNode('a');
        GLLNode b = new GLLNode('b');
        
        // Creating a sublist (c, d)
        GLLNode c = new GLLNode('c');
        GLLNode d = new GLLNode('d');
        c.next = d;
        GLLNode sublist1 = new GLLNode(c);  // Sublist (c, d)
        
        GLLNode e = new GLLNode('e');
        
        // Creating another sublist (f, g)
        GLLNode f = new GLLNode('f');
        GLLNode g = new GLLNode('g');
        f.next = g;
        GLLNode sublist2 = new GLLNode(f);  // Sublist (f, g)
        
        // Linking all nodes together to form the list (a, b, (c, d), e, (f, g))
        a.next = b;
        b.next = sublist1;
        sublist1.next = e;
        e.next = sublist2;
        
        return a; // Returning the head of the GLL
    }
    
    // Method to display the Generalized Linked List
    public static void displayGLL(GLLNode head) {
        GLLNode temp = head;
        while (temp != null) {
            if (temp.isAtom) {
                System.out.print(temp.data + " ");
            } else {
                System.out.print("(");
                displayGLL(temp.sublist);  // Recursively display the sublist
                System.out.print(") ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Method to perform the COPY operation on a Generalized Linked List
    public static GLLNode copyGLL(GLLNode head) {
        if (head == null) {
            return null;
        }
        
        // Create a new node for the current node
        GLLNode newNode = head.isAtom ? new GLLNode(head.data) : new GLLNode(copyGLL(head.sublist));
        
        // Recursively copy the rest of the list
        newNode.next = copyGLL(head.next);
        
        return newNode;
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Create a sample GLL
        GLLNode gllHead = createSampleGLL();
        
        // Display the original GLL
        System.out.println("Original Generalized Linked List:");
        displayGLL(gllHead);
        
        // Perform copy operation
        GLLNode copiedGLL = copyGLL(gllHead);
        
        // Display the copied GLL
        System.out.println("Copied Generalized Linked List:");
        displayGLL(copiedGLL);
    }
}
