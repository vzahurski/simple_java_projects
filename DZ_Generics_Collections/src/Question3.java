import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        System.out.println("Start");

        List<?> q = List.of("mouse", "parrot"); // Returns an immutable list containing two elements.
        System.out.println(q);
        System.out.println(q.getClass());

        var v = List.of("mouse", "parrot");
        System.out.println(v);
        System.out.println(v.getClass());
        /*
         q - List<?>
         v - List<String>
         List<String> есть подтип List<?>

         Ни одна из следующих команд не выполнится, т.к. List.of возвращает неизменяемый список
         q.removeIf(String::isEmpty);
         q.removeIf(s -> s.length() == 4);
         v.removeIf(String::isEmpty);
         v.removeIf(s -> s.length() == 4);
        */

    }
}
