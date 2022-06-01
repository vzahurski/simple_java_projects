import java.util.HashMap;

public class Question11 {
    public static void main(String[] args) {
        System.out.println("Start");
        var map = new HashMap<Integer, Integer>(10);
        for (int i = 1; i <= 10; i++) {
            map.put(i, i * i);
        }
        System.out.println(map.get(4));
    }
}
