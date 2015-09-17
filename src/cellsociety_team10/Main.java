package cellsociety_team10;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;



public class Main extends Application {
    Stage full_view_window;



    @Override
    public void start(Stage primaryStage) {
        full_view_window = primaryStage;
        Graphic_Controller graphics = new Graphic_Controller(full_view_window);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
