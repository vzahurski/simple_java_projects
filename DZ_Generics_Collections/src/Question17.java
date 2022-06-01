public class Question17<T>{
    public static void main(String[] args) {
        System.out.println("Start");
        Question17<String> g = new Question17<>(); // ok
        //Question17<String> g = new Question17<T>();
        //Question17<String> g = new Question17<?>();
        Question17<Object> g2 = new Question17();
    }
}
