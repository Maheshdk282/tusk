import java.util.Scanner;

class DoublyCircularLinkedList {
    private Node head; // Head of the list

    // Node class as a private inner class
    private class Node {
        int data;       // Data part of the node
        Node next;     // Pointer to the next node
        Node prev;     // Pointer to the previous node

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            // If the list is empty, create the first node
            head = newNode;
            head.next = head;  // Point to itself
            head.prev = head;  // Point to itself
        } else {
            // Find the last node
            Node tail = head.prev;

            // Insert the new node at the end
            tail.next = newNode; // Link the last node to the new node
            newNode.prev = tail; // Link the new node back to the last node
            newNode.next = head; // Link new node to head
            head.prev = newNode; // Link head back to the new node
        }
    }

    // Method to display the list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Method to display the list in backward direction
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head.prev; // Start from the last node
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != head.prev); // Stop when we reach the head again
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();

        // Input number of elements to be inserted
        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        // Inserting elements into the list
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int data = scanner.nextInt();
            list.insert(data);
        }

        // Display the list in forward direction
        System.out.println("Doubly Circular Linked List (Forward):");
        list.displayForward();

        // Display the list in backward direction
        System.out.println("Doubly Circular Linked List (Backward):");
        list.displayBackward();

        scanner.close();
    }
}
