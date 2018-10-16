package complaint;

import common.Image;
import common.dao;
import database.Column;
import database.Database;
import screenController.ScreenController;
import user.Property;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class ComplaintDao implements dao {

    Database database;

    public ComplaintDao(Database database) {
        this.database = database;
    }

    public List<Complaint> getComplaints() {
        List<Column> columns = new ArrayList<>();

        columns.add(new Column("id"));          // 0
        columns.add(new Column("name"));        // 1
        columns.add(new Column("description")); // 2
        columns.add(new Column("property_id"));    // 3  id -> query in fetch
        columns.add(new Column("category"));    // 4
        columns.add(new Column("status"));      // 5
        columns.add(new Column("customer_id"));    // 6  id -> subfunction
        columns.add(new Column("assignee_id"));    // 7  id -> subfunction

        List<List<Column>> result = database.select("complaints", columns, null, null);

        List<Complaint> complaintList = new ArrayList<>();
        for (List<Column> lc : result) {

            int id = Integer.parseInt(lc.get(0).value);
            Property property = getPropertyComplaint(id);
            Complaint.Category category = Complaint.Category.MISC;
            Complaint.Status status = Complaint.Status.NEW;
            List<Image> imageList = getImagesComplaint(id);
            User customer = ScreenController.getInstance().userRepository.getUserById(Integer.parseInt(lc.get(6).value));
            User assignee = ScreenController.getInstance().userRepository.getUserById(Integer.parseInt(lc.get(7).value));
            List<History> history = getHistoryComplaint(id);

            Complaint complaint = new Complaint(
                    id,                 //id
                    lc.get(1).value,    //name
                    lc.get(2).value,    //description
                    property,           //property
                    category,           //category
                    status,             //status
                    imageList,          //imageList
                    customer,           //customer
                    assignee,           //assignee
                    history             //history
            );
            complaintList.add(complaint);
        }

        return complaintList;
    }

    public List<Image> getImagesComplaint(int complaintId) {
        return null;
    }

    public List<History> getHistoryComplaint(int complaintId) {
        return null;
    }

    public Property getPropertyComplaint(int complaintId) {
        return null;
    }
}
