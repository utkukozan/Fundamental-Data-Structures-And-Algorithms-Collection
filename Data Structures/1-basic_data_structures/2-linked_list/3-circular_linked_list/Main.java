class Node {
    int data;
    Node next;

    // Constructor to create a new node with given data
    Node(int d) {
        data = d;
        next = null;
    }
}

class CircularLinkedList {
    Node head; // Head of the list

    // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            newNode.next = newNode; // Point to itself if the list is empty
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
        }
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

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAfter(list.head, 4);

        System.out.print("Circular linked list: ");
        list.display(); // Output: 3 4 2 1
    }
}
