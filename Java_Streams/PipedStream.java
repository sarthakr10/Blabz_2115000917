import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

    public static void main(String[] args) {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();

        try {
            outputStream.connect(inputStream);

            Thread writerThread = new Thread(new Writer(outputStream));
            writerThread.start();

            Thread readerThread = new Thread(new Reader(inputStream));
            readerThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable {
    private PipedOutputStream outputStream;

    public Writer(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                outputStream.write(("Message " + i + "\n").getBytes());
                Thread.sleep(500); // Simulate some delay
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Reader implements Runnable {
    private PipedInputStream inputStream;

    public Reader(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}