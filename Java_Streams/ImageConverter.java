import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageConverter {

    public static void main(String[] args) {
        String inputImagePath = "messi.jpeg";
        String outputImagePath = "Messi10.jpeg";

        try {
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            writeByteArrayToImage(imageBytes, outputImagePath);

            boolean isIdentical = verifyImages(inputImagePath, outputImagePath);
            System.out.println("Images are identical: " + isIdentical);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        FileInputStream fis = new FileInputStream(imagePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        fis.close();
        return baos.toByteArray();
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream(outputPath);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = bais.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        bais.close();
        fos.close();
    }

    private static boolean verifyImages(String originalImagePath, String newImagePath) throws IOException {
        byte[] originalImageBytes = Files.readAllBytes(new File(originalImagePath).toPath());
        byte[] newImageBytes = Files.readAllBytes(new File(newImagePath).toPath());
        return Arrays.equals(originalImageBytes, newImageBytes);
    }
}