import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question19 {
    public static void main(String[] args) {
        System.out.println("Start");
        List<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(12);
        q.remove(1);
        System.out.println(q); // [10]

        Queue<Integer> q1 = new LinkedList<>();
        q1.add(10);
        q1.add(12);
        q1.remove(1);
        System.out.println(q1); // [10, 12]
    }
}