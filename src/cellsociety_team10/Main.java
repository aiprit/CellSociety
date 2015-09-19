package cellsociety_team10;

import javafx.application.*;
import javafx.stage.*;


public class Main extends Application {
    Stage full_view_window;



    @Override
    public void start(Stage primaryStage) {
        full_view_window = primaryStage;
      //  Graphic_Handler graphics = new Graphic_Handler(full_view_window);
        GridPanel a = new GridPanel(10,10,400,400,0.5,0.3,0.5);
        a.update();
        primaryStage.setScene(a.getScene());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
