
public class Question18 {
    public static void main(String[] args) {
        System.out.println("Start");
    }

    class W {}
    class X extends W {}
    class Y extends X {}

    class Z<Y> {
        //W w1 = new W();
        //W w2 = new X();
        //W w3 = new Y();
        //Y y1 = new W();
        //Y y2 = new X();
        //Y y1 = new Y();
    }

}
