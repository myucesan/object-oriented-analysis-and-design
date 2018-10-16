package complaint;

import common.Image;
import database.Database;
import user.Property;
import user.User;

import java.util.List;

public class ComplaintRepository {

    private ComplaintDao dao;

    private List<Complaint> complaintList;

    public ComplaintRepository(Database database) {
        this.dao = new ComplaintDao(database);
    }

    public List<Complaint> getComplaints() {
        if (complaintList == null) {
            complaintList = dao.getComplaints();
        }
        return complaintList;
    }

    public List<Complaint> getComplaintById(int id) {
        return null;
    }

    public Complaint createComplaint(String name, String description, Property property, Complaint.Category category, List<Image> imageList, User customer) {

        if (complaintList == null) {
            getComplaints();
        }

        //TODO: Check if user exsists


        Complaint complaint = new Complaint(name, description, property, category, imageList, customer);
        complaintList.add(complaint);

        return complaint;
    }
}
