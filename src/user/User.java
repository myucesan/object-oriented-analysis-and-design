package user;

import java.util.List;

public class User {
    private int id = 0;
    private String name;
    private Password password;
    private boolean isAdmin;
    private List<Property> properties;

    public User(String name, Password password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(int id, String name, Password password, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
