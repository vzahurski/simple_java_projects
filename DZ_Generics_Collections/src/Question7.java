import java.util.HashSet;
import java.util.Iterator;

public class Question7 {
    public static void main(String[] args) {
        System.out.println("Start");

        var numbers = new HashSet<Number>();
        numbers.add(Integer.valueOf(86));
        numbers.add(75);
        numbers.add(Integer.valueOf(86));
        numbers.add(null);
        numbers.add(309L);

        System.out.println(numbers);

        Iterator iter = numbers.iterator();
        while (iter.hasNext())
            System.out.print(iter.next());

    }
}
