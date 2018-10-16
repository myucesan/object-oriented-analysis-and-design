package screenController;

import complaint.Complaint;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewComplaintsScreen extends BaseScreen implements Initializable {

    public void editComplaint() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO populate list with items

        List<Complaint> complaintList = ScreenController.getInstance().complaintRepository.getComplaints();

        System.out.println("initialize");
        for (Complaint c : complaintList) {
            System.out.println(c.getName());
        }
    }
}
