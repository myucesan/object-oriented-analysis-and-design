package screenController;

public abstract class BaseScreen {

    public void openComplaints() {
        ScreenController.getInstance().activate("viewComplaints");
    }

    public void openNewComplaint() {
        ScreenController.getInstance().activate("editComplaint");
    }

    public void openUsers() {
        ScreenController.getInstance().activate("viewUsers");
    }

    public void openNewUser() {
        ScreenController.getInstance().activate("addUser");
    }

    public int idToOpen;

    public abstract void init();
}
