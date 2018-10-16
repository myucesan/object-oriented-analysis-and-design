package screenController;

import complaint.Complaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ViewComplaintsScreen extends BaseScreen {

    ObservableList observableList = FXCollections.observableArrayList();
    @FXML
    private ListView listView;

    public void editComplaint() {

    }

    public void init() {
        //TODO populate list with items

        List<Complaint> complaintList = ScreenController.getInstance().complaintRepository.getComplaints();

        for (Complaint c : complaintList) {
            observableList.add(c);
        }

        listView.setItems(observableList);
        listView.setOnMouseClicked(click -> {

            if (click.getClickCount() == 2) {
                Complaint currentItemSelected = (Complaint) listView.getSelectionModel().getSelectedItem();
                ScreenController.getInstance().activate("editComplaint", currentItemSelected.getId());
            }
        });
    }
}
