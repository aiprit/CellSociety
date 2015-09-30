package main;

import ui.Graphic_Handler;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    Stage full_view_window;



    @Override
    public void start(Stage primaryStage) {
        full_view_window = primaryStage;
        Graphic_Handler graphics = new Graphic_Handler(full_view_window);

    }





    public static void main(String[] args) {
        launch(args);
    }
}
