
public class Question6<T> {
    T t;
    public Question6(T t) { this.t = t; }
    public String toString() { return t.toString(); }
    private <T> void println(T message) {
        System.out.print(t + "-" + message);
    }

    public static void main(String[] args) {
        System.out.println("Start");
        new Question6<String>("hi").println(1);
        new Question6("hola").println(true); // непонятно почему можно не указывать тип <String>
    } }
