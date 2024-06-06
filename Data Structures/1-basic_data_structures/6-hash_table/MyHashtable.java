import java.util.Hashtable;

public class MyHashtable {
    public static void main(String[] args) {
        // Creating a Hashtable instance
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        // Adding key-value pairs to the Hashtable
        hashtable.put(1, "Java");
        hashtable.put(2, "Python");
        hashtable.put(3, "C++");

        // Accessing elements
        System.out.println("Value at key 1: " + hashtable.get(1));
        System.out.println("Value at key 2: " + hashtable.get(2));

        // Removing an element
        hashtable.remove(3);

        // Displaying the Hashtable
        System.out.println("Hashtable after removal: " + hashtable);
    }
}
