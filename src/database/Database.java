package database;

import java.util.List;

public class Database {

    private DatabaseLanguage currentLanguage;

    public Database(DatabaseLanguage currentLanguage) {
        this.currentLanguage = currentLanguage;
    }

    public List<List<Column>> select(String table, List<Column> columns, List<Join> joins, String where) {
        return currentLanguage.select(table, columns, joins, where);
    }

    public void update(String table, List<Column> columns, String where){
        currentLanguage.update(table, columns, where);
    }

    public void insert(String table, List<Column> columns){
        currentLanguage.insert(table, columns);
    }

    public void delete(String table, int id){
        currentLanguage.delete(table, id);
    }

    public void enumToList() {

    }

}
