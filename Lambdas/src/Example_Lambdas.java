import java.util.function.Function;

interface Checker{
    boolean test(Object obj);
}

class EmptyChecker implements Checker{

    @Override
    public boolean test(Object obj) {
        return obj == null;
    }
}

class Util{
    public static Object[] myFilter(Object[] array, Checker checker){
        Object[] myArray = new Object[array.length];

        for (int ind = 0, i = 0; ind < array.length; ind++) {
            Object elem = array[ind];
            if (checker.test(elem)) {
                myArray[i++] = elem;
            }
        }
        return myArray;
    }
}

public class Example_Lambdas {

    public static void main(String[] args) {
        Object[] myArray = {"Ms", "MST", null, "hi"};
        Checker checker = new EmptyChecker();
        Util.myFilter(myArray, checker);


        Util.myFilter(myArray, obj -> false);
        Util.myFilter(myArray, obj -> {return obj == null;});
        Util.myFilter(myArray, (obj) -> obj == null);
    }
}
