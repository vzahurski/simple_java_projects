public class Question12 {
    public static <U extends Exception>
    void printException(U u) {
        System.out.println(u.getMessage());
    }
    public static void main(String[] args) {
        //Question12.printException(new FileNotFoundException("A"));
        //Question12.printException(new Exception("B")); // B
        //Question12.<Throwable>printException(new Exception("C"));
        //Question12.<NullPointerException>printException(new NullPointerException ("D")); // D
        //Question12.printException(new Throwable("E"));
    } }
