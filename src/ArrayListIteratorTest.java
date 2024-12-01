import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class ArrayListHashMapTest {

    @Test
    void testNormalArrayListIteration() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        Iterator<Integer> iterator = numbers.iterator();
        int sum = 0;

        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        assertEquals(150, sum, "The sum of all elements should be 150");
    }

    @Test
    void testRemoveEvenNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }

        assertEquals(List.of(1, 3, 5), numbers, "Only odd numbers should remain in the list");
    }

    @Test
    void testDuplicateElements() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(10, 20, 10, 20, 30));
        Iterator<Integer> iterator = numbers.iterator();
        int count = 0;

        while (iterator.hasNext()) {
            if (iterator.next() == 10) {
                count++;
            }
        }

        assertEquals(2, count, "The count of '10' in the list should be 2");
    }

    @Test
    void testEmptyArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();

        assertFalse(iterator.hasNext(), "Iterator should have no elements to iterate over");
    }

    @Test
    void testConcurrentModification() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        assertThrows(java.util.ConcurrentModificationException.class, () -> {
            for (Integer number : numbers) {
                numbers.add(4); // Modifying list during iteration
            }
        });
    }
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