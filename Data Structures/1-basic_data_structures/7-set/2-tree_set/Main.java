import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<String> treeSet = new TreeSet<>();

        // Add elements to the TreeSet
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");

        // Display the TreeSet
        System.out.println("TreeSet: " + treeSet);

        // Check if an element exists
        String searchElement = "Apple";
        if (treeSet.contains(searchElement)) {
            System.out.println(searchElement + " is present in the TreeSet.");
        } else {
            System.out.println(searchElement + " is not present in the TreeSet.");
        }

        // Remove an element
        String elementToRemove = "Banana";
        if (treeSet.remove(elementToRemove)) {
            System.out.println(elementToRemove + " has been removed from the TreeSet.");
        } else {
            System.out.println(elementToRemove + " is not present in the TreeSet.");
        }

        // Display the TreeSet after removal
        System.out.println("TreeSet after removal: " + treeSet);
    }
}
