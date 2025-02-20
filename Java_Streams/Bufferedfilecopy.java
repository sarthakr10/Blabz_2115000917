import java.io.*;

public class Bufferedfilecopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  
        String destBuffered = "copy_buffered.txt";
        String destUnbuffered = "copy_unbuffered.txt";
        
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destBuffered);
        System.out.println("Buffered Streams Copy Time: " + bufferedTime + " nanoseconds");

        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Unbuffered Streams Copy Time: " + unbufferedTime + " nanoseconds");

        if (bufferedTime < unbufferedTime) {
            System.out.println("Buffered streams were faster!");
        } else {
            System.out.println("Unbuffered streams were faster!");
        }
    }

    private static long copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error copying file with Buffered Streams: " + e.getMessage());
        }

        return System.nanoTime() - startTime; 
    }
    private static long copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime(); 

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096]; 
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error copying file with Unbuffered Streams: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}