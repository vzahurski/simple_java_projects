import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Question15 {
    public static void main(String[] args) {
        Comparator<Integer> c1 = (o1, o2) -> o2 - o1;
        Comparator<Integer> c2 = Comparator.naturalOrder();
        Comparator<Integer> c3 = Comparator.reverseOrder();
        var list = Arrays.asList(5, 4, 7, 2);
        // Collections.sort(list,c1); // -1
        // Collections.sort(list,c2); // 0
        //  Collections.sort(list,c3); // -1
        System.out.println(Collections.binarySearch(list, 2));




    }
}
