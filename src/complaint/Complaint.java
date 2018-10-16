package complaint;

import common.Image;
import database.Column;
import user.Property;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Complaint {
    // Method to instantiate a new complaint
    public Complaint(String name, String description, Property property, Category category, List<Image> imageList, User customer) {
        this.name = name;
        this.description = description;
        this.property = property;
        this.category = category;
        this.status = Status.NEW;
        this.imageList = imageList;
        this.customer = customer;
        this.assignee = null;
        this.history.add(new History("Created new complaint"));
    }

    // Method to instantiate a new complaint from the database
    public Complaint(int id, String name, String description, Property property, Category category, Status status, List<Image> imageList, User customer, User assignee, List<History> history) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.property = property;
        this.category = category;
        this.status = status;
        this.imageList = imageList;
        this.customer = customer;
        this.assignee = assignee;
        this.history = history;
    }

    private int id;
    private String name;
    private String description;
    private Property property;
    private Category category;
    private Status status;
    private List<Image> imageList;

    private User customer;
    private User assignee;

    private List<History> history = new ArrayList<>();

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    // TODO refactor out of complaint
    public void serialize(ComplaintDao dao) {
        System.out.println("serialize");
        if (id == 0) {
            List<Column> columns = new ArrayList<Column>();
            Column c = new Column("name", this.name);
            columns.add(c);
            c = new Column("description", this.description);
            columns.add(c);
            c = new Column("property_id", this.property.getId());
            columns.add(c);
            c = new Column("category", this.category.toString());
            columns.add(c);
            c = new Column("status", this.status.toString());
            columns.add(c);
            c = new Column("customer_id", 2);
            columns.add(c);
            c = new Column("assignee_id", 3);
            columns.add(c);
            dao.database.insert("complaints", columns);
        } else {
            //TODO Write update
        }
    }

    //TODO use single point of definition and move these to the database (class)
    public enum Status {NEW, OPEN, ASSIGNED, CLOSED}

    public enum Category {PLUMMING, CARPENTERY, MAINSONRY, MISC}

    //TODO expand options
    @Override
    public String toString() {
        return this.name;
    }
}
