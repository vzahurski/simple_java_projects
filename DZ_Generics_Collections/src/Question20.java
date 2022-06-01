import java.util.HashMap;
import java.util.Map;

public class Question20 {
    public static void main(String[] args) {
        System.out.println("Start");
        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        // System.out.println(m.contains("123")); // Cannot resolve method 'contains' in 'Map'
    }
}