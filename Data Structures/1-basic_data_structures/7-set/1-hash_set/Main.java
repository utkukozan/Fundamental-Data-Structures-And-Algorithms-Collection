import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> hashSet = new HashSet<>();

        // Add elements to the HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");

        // Display the HashSet
        System.out.println("HashSet: " + hashSet);

        // Check if an element exists
        String searchElement = "Apple";
        if (hashSet.contains(searchElement)) {
            System.out.println(searchElement + " is present in the HashSet.");
        } else {
            System.out.println(searchElement + " is not present in the HashSet.");
        }

        // Remove an element
        String elementToRemove = "Banana";
        if (hashSet.remove(elementToRemove)) {
            System.out.println(elementToRemove + " has been removed from the HashSet.");
        } else {
            System.out.println(elementToRemove + " is not present in the HashSet.");
        }

        // Display the HashSet after removal
        System.out.println("HashSet after removal: " + hashSet);
    }
}
