/**A linkedList reverse nodes B at a time */

import java.util.*;

class Node{
    int data;
    Node next;

    
    public static Node insert(Node head, int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.println("Enter the number of elements in the linked list: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the linked list: ");
        for(int i=0; i<n; i++){
            int data = sc.nextInt();
            head = insert(head, data);
        }

        System.out.println("Enter the value of B: ");
        int B = sc.nextInt();

        //now we have to reverse 'A' , B at a time
        Node temp = head.next;
        Node prev = head;
        int cnt = 0;
        while(temp.next != null){
            for(int i=0; i<B; i++){
                if(temp.next == null){
                    break;
                }
                Node next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }
        }

        //print the list
        Node temp1 = head;
        while(temp1 != null){
            System.out.print(temp1.data + " -> ");
            temp1 = temp1.next;
        }
    }
}
/**
public class main{

    // public static Node insert(Node head, int data){
    //     Node newNode = new Node();
    //     newNode.data = data;
    //     newNode.next = null;
    //     if(head == null){
    //         head = newNode;
    //     }else{
    //         Node temp = head;
    //         while(temp.next != null){
    //             temp = temp.next;
    //         }
    //         temp.next = newNode;
    //     }
    //     return head;
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     Node head = null;
    //     System.out.println("Enter the number of elements in the linked list: ");
    //     int n = sc.nextInt();
    //     System.out.println("Enter the elements of the linked list: ");
    //     for(int i=0; i<n; i++){
    //         int data = sc.nextInt();
    //         head = insert(head, data);
    //     }

    //     System.out.println("Enter the value of B: ");
    //     int B = sc.nextInt();

    //     //now we have to reverse 'A' , B at a time
    //     Node temp = head.next;
    //     Node prev = head;
    //     int cnt = 0;
    //     while(temp.next != null){
    //         for(int i=0; i<B; i++){
    //             Node next = temp.next;
    //             temp.next = prev;
    //             prev = temp;
    //             temp = next;
    //         }
    //     }

    //     //print the list
    //     Node temp1 = head;
    //     while(temp1 != null){
    //         System.out.print(temp1.data + " -> ");
    //         temp1 = temp1.next;
    //     }
    // }
}
    */