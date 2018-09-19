package ooad;

import database.SqlConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddComplaintController implements Initializable{

    List<Complaint> complaintList = new ArrayList<Complaint>();

    @FXML
    AnchorPane pane;

    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button printList;

    @FXML
    private Button serialize;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        printList.setOnAction(event -> {
//            for(Complaint c : complaintList){
//                System.out.println(c.toString());
//            }
//        });
//        serialize.setOnAction(event -> {
//            for(Complaint c : complaintList){
//                c.serialize();
//            }
//
//            complaintList = getComplaintsList(true);
//        });
    }
    @FXML
    public void addComplaint() throws SQLException {

        Complaint c = new Complaint(nameField.getText(), descriptionField.getText());

        if(complaintList.isEmpty()){
            getComplaintsList(false);
        }

        complaintList.add(c);

    }

    public List<Complaint> getComplaintsList(boolean force){

        if(complaintList.isEmpty() || force){
            complaintList = SqlConnection.getInstance().getComplaints();
        }

        return complaintList;
    }
    @FXML
    public void openComplaintView() throws IOException {
        viewFades.FadeOut(pane, "ViewComplaint.fxml");
    }


}
