public class Worker {
    private int id;
    
    public Worker(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public WorkItem notify(WorkItem item) {
        int itemId = item.getId();
        if (itemId != id)
            return null;
        
        System.out.printf("Worker %d processed WorkItem %d message %s\n", id, itemId, item.getMessage());
        item.setId(itemId + 1);
        return item;
    }
    
}
