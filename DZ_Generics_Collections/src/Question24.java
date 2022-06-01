import java.util.Set;

public class Question24 {
    public static void main(String[] args) {
        Set<?> set = Set.of("lion", "tiger", "bear");
        var s = Set.copyOf(set);

        //s.forEach(() -> System.out.println(s)); // incompatible types: incompatible parameter types in lambda expression
        // s.forEach(s -> System.out.println(s)); // variable s is already defined in method main(java.lang.String[])
        //s.forEach((s) -> System.out.println(s)); // variable s is already defined in method main(java.lang.String[])
        // s.forEach(System.out.println(s)); // 'void' type not allowed here
        // s.forEach(System::out::println); // method reference not expected here
        s.forEach(System.out::println); // ok
        }
}
