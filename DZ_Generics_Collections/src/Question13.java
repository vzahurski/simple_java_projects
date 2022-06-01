import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question13 {
    public void showSize(List<?> list) {
        System.out.println(list.size());
    }
    public static void main(String[] args) {
        System.out.println("Start");
        Question13 card = new Question13();
        //List<?> list = new HashSet<String>(); // incompatible types: java.util.HashSet<java.lang.String> cannot be converted to java.util.List<?>
        //ArrayList<? super Date> list = new ArrayList<Date>();
        // List<?> list = new ArrayList<?>();
        //List<Exception> list = new LinkedList<java.io.IOException>();
        ArrayList<? extends Number> list = new ArrayList <Integer>();
        card.showSize(list);
    } }
