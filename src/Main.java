import complaint.ComplaintRepository;
import database.Database;
import database.DatabaseLanguage;
import database.SQL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import screenController.ScreenController;
import user.UserRepository;

public class Main extends Application {

    private static ScreenController screenController;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource( "screens/login.fxml" ));
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("ComplaintsApp");
        primaryStage.setScene(scene);
        primaryStage.show();

        screenController = new ScreenController(scene);

        DatabaseLanguage dbLang = new SQL("root", "fys-resort5", "185.177.59.153:3306/ooad");
        Database database = new Database(dbLang);

        screenController.userRepository = new UserRepository(database);
        screenController.complaintRepository = new ComplaintRepository(database);

        screenController.addScreen("login", root);
//        screenController.addScreen("register", FXMLLoader.load(getClass().getResource( "screens/register.fxml" )));
        screenController.addScreen("viewComplaints", FXMLLoader.load(getClass().getResource( "screens/viewComplaints.fxml" )));
        screenController.addScreen("editComplaint", FXMLLoader.load(getClass().getResource("screens/NewComplaint.fxml")));
        screenController.addScreen("viewComplaint", FXMLLoader.load(getClass().getResource("screens/ViewSpecificComplaint.fxml")));
//        screenController.addScreen("viewUsers", FXMLLoader.load(getClass().getResource( "screens/viewUsers.fxml" )));
//        screenController.addScreen("addUser", FXMLLoader.load(getClass().getResource( "screens/addUser.fxml" )));
        screenController.activate("login");
    }
}
