package screenController;

public class LoginScreen {

    public void login() {
        ScreenController.getInstance().activate("viewComplaints");
    }

    public void openRegister() {
        ScreenController.getInstance().activate("register");
    }

    public void init() {

    }
}
