package complaint;

public class History {

    private int id;
    private String datetime;
    private String description;

    public History(String description) {
        this.description = description;
        this.datetime = "NOW"; //TODO
    }
}
