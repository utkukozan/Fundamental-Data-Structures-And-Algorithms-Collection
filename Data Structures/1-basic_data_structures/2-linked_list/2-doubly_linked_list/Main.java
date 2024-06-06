class Node {
    int data;
    Node prev;
    Node next;

    // Constructor to create a new node with given data
    Node(int d) {
        data = d;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList {
    Node head; // Head of the list

    // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
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
        if (prevNode.next != null)
            prevNode.next.prev = newNode;
        prevNode.next = newNode;
        newNode.prev = prevNode;
    }

    // Method to insert a new node at the end of the list
    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = newNode;
        newNode.prev = last;
    }

    // Method to display the linked list in forward direction
    public void displayForward() {
        Node current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the linked list in reverse direction
    public void displayBackward() {
        Node last = head;
        while (last.next != null)
            last = last.next;
        System.out.print("Backward: ");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAfter(list.head.next, 4);

        list.displayForward(); // Output: Forward: 3 2 4 1
        list.displayBackward(); // Output: Backward: 1 4 2 3
    }
}
