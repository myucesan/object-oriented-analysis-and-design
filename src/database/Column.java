package database;

public class Column {

    public String name;
    public String value;

    public Column(String name, String value){
        this.name = name;
        this.value = value;
    }

    public Column(String name) {
        this(name, null);
    }
}
