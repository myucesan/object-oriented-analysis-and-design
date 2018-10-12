package complaint;

import database.Database;

public class ComplaintRepository {

    ComplaintDao dao;

    public ComplaintRepository(Database database) {
        this.dao = new ComplaintDao(database);
    }
}
