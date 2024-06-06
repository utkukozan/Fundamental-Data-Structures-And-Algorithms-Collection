import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Creating a TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Adding key-value pairs to the TreeMap
        treeMap.put("John", 25);
        treeMap.put("Alice", 30);
        treeMap.put("Bob", 28);

        // Accessing elements in the TreeMap
        System.out.println("Age of John: " + treeMap.get("John"));

        // Iterating over the TreeMap
        for (String name : treeMap.keySet()) {
            int age = treeMap.get(name);
            System.out.println(name + " is " + age + " years old.");
        }

        // Checking if a key exists
        if (treeMap.containsKey("Alice")) {
            System.out.println("Alice's age is present in the TreeMap.");
        }

        // Removing a key-value pair
        treeMap.remove("Bob");

        // Checking size
        System.out.println("Size of TreeMap: " + treeMap.size());
    }
}
