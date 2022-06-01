import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        System.out.println("Start");

        // System.out.println(new HashSet<Integer>() instanceof HashSet<Number>);
        //HashSet<Number> hs = new HashSet<Integer>();


        // HashSet<? super ClassCastException> set = new HashSet<Exception>();
        //List<> list = new ArrayList<String>();
        // System.out.println(new HashSet<Object>() instanceof List<Object>); // false
        //List<Object> values = new HashSet<Object>();
        //List<Object> objects = new ArrayList<? extends Object>();

        Map<String, ? extends Number> hm = new HashMap<String, Integer>();
    }
}
