import java.io.*;

public class Contentreaderwriter{
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                System.out.println("Error: Source file does not exist.");
                return;
            }

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(destinationFile);
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing the file streams: " + e.getMessage());
            }
        }
    }
}