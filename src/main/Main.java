/**class Main
 * @author Matteo Falkenberg
 * @version 1.2, 21.01.2021
 */

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        primaryStage.setTitle("Color Calculator");
        primaryStage.setScene(new Scene(root, 400, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
