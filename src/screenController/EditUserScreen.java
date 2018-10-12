package screenController;

public class EditUserScreen extends BaseScreen {

    public void saveUser() {

    }

    public void createUser() {
        // Collect data from UI

        String name = "";
        String password = "";
        boolean isAdmin = false;

        // Call create user function
        ScreenController.getInstance().userRepository.createUser(name, password, isAdmin);
    }
}
