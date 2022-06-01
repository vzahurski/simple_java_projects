import java.util.Arrays;
import java.util.Comparator;

public class Question10 implements Comparator<String> {
    public int compare(String a, String b) {
        return b.toLowerCase().compareTo(a.toLowerCase());
        // a < b, если возвращаем -1, т.е. b < a при их приведении к маленьким буквам
        // "aab" < "abb" => "Abb" будет предшествовать "aab" в сортировке =>
    }
    public static void main(String[] args) {
        System.out.println("Start");
        String[] values = { "123", "Abb", "aab" };
        Arrays.sort(values, new Question10());
        for (var s: values)
            System.out.print(s + " ");
    }
}
