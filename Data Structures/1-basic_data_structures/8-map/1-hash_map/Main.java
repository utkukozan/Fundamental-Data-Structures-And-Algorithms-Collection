import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Adding key-value pairs to the HashMap
        hashMap.put("John", 25);
        hashMap.put("Alice", 30);
        hashMap.put("Bob", 28);

        // Accessing elements in the HashMap
        System.out.println("Age of John: " + hashMap.get("John"));

        // Iterating over the HashMap
        for (String name : hashMap.keySet()) {
            int age = hashMap.get(name);
            System.out.println(name + " is " + age + " years old.");
        }

        // Checking if a key exists
        if (hashMap.containsKey("Alice")) {
            System.out.println("Alice's age is present in the HashMap.");
        }

        // Removing a key-value pair
        hashMap.remove("Bob");

        // Checking size
        System.out.println("Size of HashMap: " + hashMap.size());
    }
}
