import java.util.LinkedList;

public class Question4 {
    public static void main(String[] args) {
        System.out.println("Start");

        var greetings = new LinkedList<String>();
        greetings.offer("hello"); // Добавляет указанный элемент в качестве хвоста (последнего элемента) этого списка
        greetings.offer("hi");
        greetings.offer("ola");

        System.out.println(greetings); // [hello, hi, ola]
        greetings.pop(); // Извлекает элемент из стека, представленного этим списком, верхушка стека это нулевой элемент списка
        System.out.println(greetings); // [hi, ola]
        greetings.peek(); // Извлекает, но не удаляет первый элемент этого списка.
        System.out.println(greetings.peek()); // hi
        System.out.println(greetings); // [hi, ola] Извлекает, но не удаляет заголовок (первый элемент) этого списка.

        while (greetings.peek() != null)
            System.out.print(greetings.pop());

        // hiola
    }
}
