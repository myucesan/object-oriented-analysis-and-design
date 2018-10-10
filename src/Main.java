import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import screenController.ScreenController;

public class Main extends Application {

    public static ScreenController screenController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource( "screens/login.fxml" ));
        Scene scene = new Scene(root, 500, 275);
        primaryStage.setTitle("ComplaintsApp");
        primaryStage.setScene(scene);
        primaryStage.show();

        screenController = new ScreenController(scene);
        screenController.addScreen("login", root);
//        screenController.addScreen("register", FXMLLoader.load(getClass().getResource( "screens/register.fxml" )));
        screenController.addScreen("viewComplaints", FXMLLoader.load(getClass().getResource( "screens/viewComplaints.fxml" )));
//        screenController.addScreen("addComplaint", FXMLLoader.load(getClass().getResource( "screens/addComplaints.fxml" )));
//        screenController.addScreen("viewUsers", FXMLLoader.load(getClass().getResource( "screens/viewUsers.fxml" )));
//        screenController.addScreen("addUser", FXMLLoader.load(getClass().getResource( "screens/addUser.fxml" )));
        screenController.activate("login");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
