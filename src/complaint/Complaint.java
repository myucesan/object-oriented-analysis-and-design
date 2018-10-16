package complaint;

import common.Image;
import user.Property;
import user.User;

import java.util.List;

public class Complaint {
    private int id;
    private String name;
    private String description;
    private Property property;
    private Category category;
    private Status status;
    private List<Image> imageList;
    private User customer;
    private User assignee;
    private List<History> history;

    public enum Status {NEW, OPEN, ASSIGNED, CLOSED}

    public enum Category {NEW, OPEN, ASSIGNED, CLOSED}


}
