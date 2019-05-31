
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        primaryStage.setTitle("III obwodnica Krakowa");
        primaryStage.setScene(new Scene(root, 1000  , 900));
        primaryStage.show();
    }
    public static void main(String argv[]){
        launch(argv);
    }
}
