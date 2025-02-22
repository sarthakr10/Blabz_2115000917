import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    public void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        listManager.addElement(testList, 10);
        listManager.addElement(testList, 20);
        assertEquals(2, testList.size());
        assertTrue(testList.contains(10));
        assertTrue(testList.contains(20));
    }

    @Test
    public void testRemoveElement() {
        testList.add(10);
        testList.add(20);
        listManager.removeElement(testList, 10);
        assertEquals(1, testList.size());
        assertFalse(testList.contains(10));
    }

    @Test
    public void testGetSize() {
        assertEquals(0, listManager.getSize(testList));
        testList.add(5);
        assertEquals(1, listManager.getSize(testList));
        testList.add(10);
        assertEquals(2, listManager.getSize(testList));
    }

    @Test
    public void testRemoveNonExistingElement() {
        testList.add(10);
        listManager.removeElement(testList, 30);
        assertEquals(1, testList.size());
    }

    @Test
    public void testNullListHandling() {
        assertDoesNotThrow(() -> listManager.addElement(null, 5));
        assertDoesNotThrow(() -> listManager.removeElement(null, 5));
        assertEquals(0, listManager.getSize(null));
    }
}
