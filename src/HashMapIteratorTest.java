import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class HashMapTest {

    @Test
    void testHashMapIteration() {
        HashMap<String, Integer> items = new HashMap<>(Map.of("Books", 10, "Movies", 20, "Games", 30));
        Iterator<Map.Entry<String, Integer>> iterator = items.entrySet().iterator();
        int sum = 0;

        while (iterator.hasNext()) {
            sum += iterator.next().getValue();
        }

        assertEquals(60, sum, "The sum of all values should be 60");
    }

    @Test
    void testRemoveEntryDuringIteration() {
        HashMap<String, Integer> items = new HashMap<>(Map.of("Books", 10, "Movies", 20, "Games", 30));
        Iterator<Map.Entry<String, Integer>> iterator = items.entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals("Games")) {
                iterator.remove();
            }
        }

        assertFalse(items.containsKey("Games"), "The 'Games' entry should be removed");
    }

    @Test
    void testEmptyHashMap() {
        HashMap<String, Integer> items = new HashMap<>();
        Iterator<Map.Entry<String, Integer>> iterator = items.entrySet().iterator();

        assertFalse(iterator.hasNext(), "Iterator should have no elements to iterate over");
    }

    @Test
    void testDuplicateValues() {
        HashMap<String, Integer> items = new HashMap<>(Map.of("Books", 10, "Movies", 20, "Sports", 20));
        long count = items.values().stream().filter(value -> value == 20).count();

        assertEquals(2, count, "The value '20' should appear twice in the map");
    }
}