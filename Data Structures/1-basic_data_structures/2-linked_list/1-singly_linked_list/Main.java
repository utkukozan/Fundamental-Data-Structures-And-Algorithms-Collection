class Node {
    int data;
    Node next;

    // Constructor to create a new node with given data
    Node(int d) {
        data = d;
        next = null;
    }
}

class SinglyLinkedList {
    Node head; // Head of the list

    // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a new node after a given node
    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Method to insert a new node at the end of the list
    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAfter(list.head.next, 4);

        System.out.print("Linked list: ");
        list.display(); // Output: 3 2 4 1
    }
}
