package flightsgui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chanv
 */
public class FlightsGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) 
       throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FlightsLibrary.fxml"));
        primaryStage.setTitle("Flight Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
