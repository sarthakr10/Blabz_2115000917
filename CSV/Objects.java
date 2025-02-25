import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + " ', age=" + age + ", grade='" + grade + "'}";
    }
}

public class Objects {
    public static void main(String[] args) {
        String csvFile = "/path/to/your/csvfile.csv";
        String line;
        String csvSplitBy = ",";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(csvSplitBy);
                Student student = new Student(studentData[0], Integer.parseInt(studentData[1]), studentData[2]);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}