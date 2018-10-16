package screenController;

import user.User;

public class EditUserScreen extends BaseScreen {

    public void saveUser() {

    }

    public void createUser() {
        // Collect data from UI

        String name = "";
        String password = "";
        boolean isAdmin = false;

        // Call create user function
        User user = ScreenController.getInstance().userRepository.createUser(name, password, isAdmin);

        // Create properties

        // Add properties to user
    }

    @Override
    public void init() {

    }
}
