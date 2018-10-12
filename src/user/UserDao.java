package user;

import common.dao;
import database.Column;
import database.Database;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements dao {

    private Database database;

    public UserDao(Database database) {
        this.database = database;
    }

    public List<User> getUsers() {
        List<Column> columns = new ArrayList<Column>();

        columns.add(new Column("id"));


        database.select("users", columns, null, null);
        return null;
    }
}
