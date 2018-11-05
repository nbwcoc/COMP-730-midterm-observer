import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class WorkerTest {
    Worker testObject = new Worker(1);
    
    @Test
    void testGetId() {
        assertEquals(1, testObject.getId());
    }

    @Test
    void testNotifyWorkItem() {
        var os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        
        var item = testObject.notify(new WorkItem(1, "test"));
        
        assertEquals(2, item.getId());
        assertEquals("Worker 1 processed WorkItem 1 message test\n", os.toString());
    }

}
