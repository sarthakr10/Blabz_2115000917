import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";
    private FileProcessor fileProcessor;

    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @Test
    public void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(TEST_FILE, content);
        
        String readContent = fileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "Content should match after reading from file.");
    }

    @Test
    public void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(TEST_FILE, "Test Data");
        assertTrue(Files.exists(Path.of(TEST_FILE)), "File should exist after writing.");
    }

    @Test
    public void testReadFromFile_FileNotFound() {
        Exception exception = assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nonexistent.txt");
        });

        assertTrue(exception.getMessage().contains("nonexistent.txt"), "IOException should mention missing file.");
    }
}
