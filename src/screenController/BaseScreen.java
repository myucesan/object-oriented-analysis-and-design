package screenController;

public class BaseScreen {

    public void openComplaints() {
        ScreenController.getInstance().activate("viewComplaints");
    }

    public void openNewComplaint() {
        ScreenController.getInstance().activate("addComplaint");
    }

    public void openUsers() {
        ScreenController.getInstance().activate("viewUsers");
    }

    public void openNewUser() {
        ScreenController.getInstance().activate("addUser");
    }
}
