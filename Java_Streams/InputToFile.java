import java.io.*;

public class InputToFile{
    public static void main(String[] args) {
        String fileName = "source.txt";  
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            
            System.out.println("User information saved successfully in " + fileName);

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}