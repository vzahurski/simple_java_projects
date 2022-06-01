import java.util.Comparator;
import java.util.TreeSet;

public class Question14 implements Comparable<Question14>, Comparator<Question14> {
    private int num;
    private String text;

    public String toString() { return "" + num; }
    public int compareTo(Question14 s) {                 // Comparable используется при сортировке
        return text.compareTo(s.text);
    }
    public int compare(Question14 s1, Question14 s2) {   // Comparator используется при добавлении объекта в TreeSet
        return s1.num - s2.num;
    }
    public static void main(String[] args) {
        var s1 = new Question14(88, "a");
        var s2 = new Question14(55, "b");
        var t1 = new TreeSet<Question14>();
        t1.add(s1); t1.add(s2);
        var t2 = new TreeSet<Question14>(s1);
        t2.add(s1); t2.add(s2);
        System.out.println(t1 + " " + t2);
    }

    public Question14(int num, String text) {
        this.num = num;
        this.text = text;
    }

    public int getNum() {
        return num;
    }

    public String getText() {
        return text;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setText(String text) {
        this.text = text;
    }
}
