import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class WorkManagerTest {

    private WorkManager testObject = new WorkManager();
    // I really don't like not having var here
    private ByteArrayOutputStream os = new ByteArrayOutputStream();
    
    WorkManagerTest() {
        testObject.registerWorker(new Worker(1));
        System.setOut(new PrintStream(os));
    }
    
    @Test
    void testRegisterWorker() {
        testObject.registerWorker(new Worker(2));
        testObject.publish(new WorkItem(2, "test"));
        var result = os.toString();
        assertTrue(os.toString().contains("2: Completed work on 3"));
    }

    @Test
    void testPublish() {
        testObject.publish(new WorkItem(1, "test"));
        assertTrue(os.toString().contains("1: Completed work on 2"));
    }
    
    @Test
    void testPublishNoReceivers() {
        testObject.publish(new WorkItem(50, "test"));
        assertEquals("", os.toString());
    }

}
