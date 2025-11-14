package example;

public class App {

    public static void main() {
        Student student=new Student.Builder("name","university").setAge(19)
                .build();
        System.out.println(student);
    }
}
