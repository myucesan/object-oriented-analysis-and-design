package database;

public class Join {

    public String table;
    public String where;

    public Join(String table, String where){
        this.table = table;
        this.where = where;
    }

    public String toString(){
        return " JOIN `"+table+"` ON " + where;
    }
}
