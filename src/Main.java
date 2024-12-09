import java.util.Map;
import java.util.TreeMap;

//Task 3: Advanced Operations with TreeMap
public class Main {
    public static void main(String[] args) {
        // Step 1: Create and populate a TreeMap
        //TreeMap Creation and Population.
        //Create a TreeMap where keys are months (Strings) and values are average temperatures (Doubles). Populate it with data for at least six months.
        TreeMap<String, Double> temperatures = new TreeMap<>();
        temperatures.put("January", -5.0);
        temperatures.put("February", -2.0);
        temperatures.put("March", 5.0);
        temperatures.put("April", 12.0);
        temperatures.put("May", 18.0);
        temperatures.put("June", 22.0);

        System.out.println("Original TreeMap: " + temperatures);

        // Step 2: Find highest and lowest temperatures using an iterator
        String coldestMonth = null, hottestMonth = null;
        double lowestTemp = Double.MAX_VALUE, highestTemp = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : temperatures.entrySet()) {
            if (entry.getValue() < lowestTemp) {
                lowestTemp = entry.getValue();
                coldestMonth = entry.getKey();
            }
            if (entry.getValue() > highestTemp) {
                highestTemp = entry.getValue();
                hottestMonth = entry.getKey();
            }
        }

        System.out.println("Coldest Month: " + coldestMonth + ", Temperature: " + lowestTemp);
        System.out.println("Hottest Month: " + hottestMonth + ", Temperature: " + highestTemp);
    }
}