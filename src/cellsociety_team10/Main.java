package cellsociety_team10;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.stage.*;
import javafx.util.Duration;


public class Main extends Application {
    Stage full_view_window;
    public static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;


    @Override
    public void start(Stage primaryStage) {
        full_view_window = primaryStage;
      //  Graphic_Handler graphics = new Graphic_Handler(full_view_window);
        GridPanel a = new GridPanel(10,10,400,400,0.5,0.3,0.5);
        primaryStage.setScene(a.getScene());
        primaryStage.show();


//        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
//                e -> graphics.step(SECOND_DELAY));
//        Timeline animation = new Timeline();
//        animation.setCycleCount(Timeline.INDEFINITE);
//        animation.getKeyFrames().add(frame);
//        animation.play();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
