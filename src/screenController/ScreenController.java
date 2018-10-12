package screenController;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import user.UserRepository;

import java.util.HashMap;

public class ScreenController {

    public UserRepository userRepository;

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
        main.setRoot( screenMap.get(name) );
    }
}
