import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var manager = new WorkManager();
        int items[] = {1, 3, 5};
        Random rng = new Random();
        for (int i = 1; i < 5; i++)
            manager.registerWorker(new Worker(i));
        for (int i : items)
            manager.publish(new WorkItem(i, Long.toHexString(rng.nextLong())));
    }
}
