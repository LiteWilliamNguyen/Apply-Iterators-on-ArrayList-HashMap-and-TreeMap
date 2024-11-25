import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ArrayListIterator {
    public static void main(String[] args) {
        // Step 1: Create and populate an ArrayList with random integers
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            numbers.add(random.nextInt(100)) // Random integer between 0 and 99
        }
        System.out.println("List: " + numbers);

        // Step 2: Iteration using an Iterator and calculating sum
        Iterator<Integer> iterator = numbers.iterator();
        int sum = 0;
        while(iterator.hasNext()){
            int num = iterator.next();
            System.out.println("Number: " + num);
            sum += num;
        }
        System.out.println("Total sum: "+ sum);

        // Step 3: Modification during iteration
        try {
            iterator  = numbers.iterator();
            while (iterator.hasNext()) {
                int num = iterator.next();
                if (num % 2 ==0){
                    iterator.remove(); //using remove method
                }
            }
            System.out.print("List of odd number using iterator" + numbers);


        }

    }
}