package screenController;

import complaint.ComplaintRepository;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import user.UserRepository;

import java.util.HashMap;

public class ScreenController {

    public UserRepository userRepository;
    public ComplaintRepository complaintRepository;

    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    private static ScreenController instance;

    public ScreenController(Scene main){
        this.main = main;

        instance = this;
    }

    public static ScreenController getInstance(){
        return instance;
    }

    public void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name){
        activate(name, 0);
    }

    public void activate(String name, int id) {
        Pane parent = screenMap.get(name);
        if (parent != null) {
            main.setRoot(parent);
            Object controllerObject;
            do {
                controllerObject = parent.getProperties().get("controller");
            } while (controllerObject == null);

            if (controllerObject instanceof LoginScreen) {
                LoginScreen controller = (LoginScreen) controllerObject;
                controller.init();
            } else if (controllerObject instanceof RegisterScreen) {
                RegisterScreen controller = (RegisterScreen) controllerObject;
                controller.init();
            } else {
                BaseScreen controller = (BaseScreen) controllerObject;
                controller.idToOpen = id;
                controller.init();
            }

        } else {
            System.out.println("pageNotFound");
        }
    }
}
