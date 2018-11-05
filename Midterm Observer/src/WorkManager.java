import java.util.HashMap;

public class WorkManager {
    private HashMap<Integer, Worker> workers = new HashMap<>();
    
    public void registerWorker(Worker worker) {
        workers.put(worker.getId(), worker);
    }
    
    public void publish(WorkItem item) {
        for (var worker : workers.values()) {
            var newItem = worker.notify(item);
            if (newItem != null) {
                item = newItem;
                System.out.printf("%d: Completed work on %d\n", worker.getId(), item.getId());
            }
        }
    }
}
