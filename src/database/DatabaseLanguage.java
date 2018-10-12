package database;

import java.util.List;

public interface DatabaseLanguage {

    List<List<Column>> select(String table, List<Column> columns, List<Join> joins, String where);
    void update(String table, List<Column> columns, String where);
    void insert(String table, List<Column> columns);
    void delete(String table, int id);
}
