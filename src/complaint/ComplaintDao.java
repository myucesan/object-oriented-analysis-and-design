package complaint;

import common.dao;
import database.Database;

public class ComplaintDao implements dao {

    Database database;

    public ComplaintDao(Database database) {
        this.database = database;
    }
}
