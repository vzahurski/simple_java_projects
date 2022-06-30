import java.io.*;

public class Task1 implements Serializable{
    private String name;
    private Integer age;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Task1 t = new Task1();
        t.setName("Valery");
        t.setAge(18);

        try (var os = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("data.dat")
                )
        )){
            os.writeObject(t);
        }

        try (var is = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("data.dat")
                )
        )) {

            Task1 b = (Task1) is.readObject();
            System.out.println(b.age);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
