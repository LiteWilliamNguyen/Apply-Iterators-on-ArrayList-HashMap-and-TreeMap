import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {
    public static void main(String[] args) {
        // Step 1: Create and populate a HashMap
        HashMap<String, Integer> items = new HashMap<>();
        items.put("Books", 12);
        items.put("Movies", 8);
        items.put("Games", 15);
        items.put("Music", 20);
        items.put("Sports", 5);

        System.out.println("Original HashMap: " + items);

        // Step 2: Iterate over the HashMap using entrySet() and an Iterator
        Iterator<Map.Entry<String, Integer>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Category: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        // Step 3: Modify values and remove entries during iteration
        iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getKey().equals("Sports")) {
                iterator.remove(); // Safely remove entry
            } else {
                items.put(entry.getKey(), entry.getValue() + 5); // Update value
            }
        }
        System.out.println("Updated HashMap: " + items);
    }
}