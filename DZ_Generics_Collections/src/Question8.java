import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question8 {
    String name;
    int beakLength;

    public String getName() {
        return name;
    }

    public int getBeakLength() {
        return beakLength;
    }

    public Question8(String name, int beakLength) {
        this.name = name;
        this.beakLength = beakLength;
    }

    // Assume getters/setters/constructors provided

    public String toString() {return "" + beakLength;}

    public static void main(String[] args) {
        System.out.println("Start");
        Question8 p1 = new Question8("Paula", 3);
        Question8 p2 = new Question8("Peter", 5);
        Question8 p3 = new Question8("Peter", 7);

        List<Question8> list = Arrays.asList(p1, p2, p3);

        //Collections.sort(list, Comparator.comparing(Question8::getBeakLength)); // [3, 5, 7]
        // Collections.sort(list, Comparator.comparing(Question8::getBeakLength).reversed()); // [7, 5, 3]
        // Collections.sort(list, Comparator.comparing(Question8::getName).thenComparing(Question8::getBeakLength)); // [3, 5, 7]
        // Collections.sort(list, Comparator.comparing(Question8::getName).thenComparing(Comparator.comparing(Question8::getBeakLength).reversed())); // [3, 7, 5]
        // Collections.sort(list, Comparator.comparing(Question8::getName).thenComparingNumber(Question8::getBeakLength).reversed()); // cannot find symbol thenComparingNumber
        //Collections.sort(list, Comparator.comparing(Question8::getName).thenComparingInt(Question8::getBeakLength).reversed()); // [7, 5, 3]

        System.out.println(list);
    }


}
