package screenController;

import complaint.Complaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.Property;
import user.User;

public class EditComplaintScreen extends BaseScreen {
    @FXML
    private TextField titleTf;
    @FXML
    private TextArea descriptionTa;
    @FXML
    private ComboBox propertyCb;
    @FXML
    private ComboBox categoryCb;

    public void createComplaint() {
        User user = ScreenController.getInstance().userRepository.getUserById(2);
        ScreenController.getInstance().complaintRepository.createComplaint(titleTf.getText(), descriptionTa.getText(), new Property(), (Complaint.Category) categoryCb.getValue(), null, user);
    }

    public void saveComplaint() {

    }

    @Override
    public void init() {
        ObservableList<String> properties =
                FXCollections.observableArrayList(
                        "home1",
                        "home2"
                );
        propertyCb.setItems(properties);

        ObservableList<Complaint.Category> outputTypes = FXCollections.observableArrayList();
        for (Complaint.Category t : Complaint.Category.values()) {
            outputTypes.add(t);
        }
        ObservableList<Complaint.Category> categories = outputTypes;
        categoryCb.setItems(categories);

        System.out.println("Should be opening id " + idToOpen);
    }
}
