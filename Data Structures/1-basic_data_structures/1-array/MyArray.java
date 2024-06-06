public class MyArray {
    private int[] array;
    private int size;

    // Constructor to initialize the array with a specific size
    public MyArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // Method to get the current size of the array
    public int size() {
        return size;
    }

    // Method to check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to add an element to the end of the array
    public void add(int element) {
        if (size < array.length) {
            array[size] = element;
            size++;
        } else {
            // If the array is full, resize it by creating a new array with double the capacity
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[size] = element;
            size++;
        }
    }

    // Method to get an element at a specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return array[index];
    }

    // Method to print the elements of the array
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Method to remove an element at a specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // Method to clear the array
    public void clear() {
        array = new int[array.length];
        size = 0;
    }

    public static void main(String[] args) {
        // Create a new instance of MyArray with an initial capacity of 5
        MyArray myArray = new MyArray(5);

        // Add elements to the array
        myArray.add(10);
        myArray.add(20);
        myArray.add(30);
        myArray.add(40);
        myArray.add(50);

        // Print the elements of the array
        System.out.println("Array elements:");
        myArray.print();

        // Get and print the element at index 2
        System.out.println("Element at index 2: " + myArray.get(2));

        // Remove the element at index 3
        myArray.remove(3);

        // Print the updated elements of the array
        System.out.println("Array elements after removing element at index 3:");
        myArray.print();

        // Clear the array
        myArray.clear();

        // Print the elements of the cleared array
        System.out.println("Array elements after clearing:");
        myArray.print();
    }
}
