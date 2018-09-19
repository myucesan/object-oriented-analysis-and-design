package ooad;

import database.SqlConnection;

import java.sql.SQLException;

public class Complaint {

    public static enum Status{NEW, OPEN, ASSIGNED, CLOSED}

    private int id;
    private String title;
    private String description;
    private Status status;
    private Image[] images;
    private String assignee;

    public Complaint(String title, String description){
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }

    public Complaint(int id, String title, String description, Image[] images, Status status, String assignee){
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
        this.status = status;
        this.assignee = assignee;
    }

    public void serialize(){
        if(images != null){
            for(Image i : images){
                i.serialize();
            }
        }

        try {
            if(id == 0) {
                SqlConnection.getInstance().InsertComplaint(title, description);
            }else{
                SqlConnection.getInstance().UpdateComplaint(id, title, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Id: "+id+" title: "+ title + " desc: "+description;
    }
}
