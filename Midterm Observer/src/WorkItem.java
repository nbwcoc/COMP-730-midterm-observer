public class WorkItem {
    private int id;
    private String message;
    
    public WorkItem(int id, String message) {
        this.id = id;
        this.message = message;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) { 
        this.id = id;
    }
    
    public String getMessage() {
        return message;
    }
}
