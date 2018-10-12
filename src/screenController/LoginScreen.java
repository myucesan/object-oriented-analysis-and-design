package screenController;

public class LoginScreen {

    //TODO: remove
    public void addComplaint(){

    }

    public void openComplaintView(){
        ScreenController.getInstance().activate("viewComplaints");
    }

    public void login() {

    }

    public void openRegister() {
        ScreenController.getInstance().activate("register");
    }
}
