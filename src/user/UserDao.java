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
        columns.add(new Column("name"));
        columns.add(new Column("password"));
        columns.add(new Column("isAdmin"));

        List<List<Column>> result = database.select("users", columns, null, null);

        List<User> userList = new ArrayList<>();
        for (List<Column> lc : result) {
            User user = new User(
                    Integer.parseInt(lc.get(0).value),
                    lc.get(1).value,
                    new Password(lc.get(2).value),
                    lc.get(3).value.equals("1")
            );
            userList.add(user);
        }

        return userList;
    }
}
