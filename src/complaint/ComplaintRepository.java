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
        return getComplaints(false);
    }

    private List<Complaint> getComplaints(boolean force) {
        if (complaintList == null || force) {
            complaintList = dao.getComplaints();
        }
        return complaintList;
    }

    public List<Complaint> getComplaintById(int id) {
        return null;
    }

    public Complaint createComplaint(String name, String description, Property property, Complaint.Category category, List<Image> imageList, User customer) {

        //TODO: Check if user exsists


        Complaint complaint = new Complaint(name, description, property, category, imageList, customer);
        complaint.serialize(dao);

        getComplaints(true);

        return complaint;
    }
    
        public Complaint updateComplaint(String name, String description, Property property, Complaint.Category category, List<Image> imageList, User customer) {

        //TODO: Check if user exsists


        Complaint complaint = new Complaint(name, description, property, category, imageList, customer);
        complaint.serialize(dao);

        getComplaints(true);

        return complaint;
    }
}
