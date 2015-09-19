package cellsociety_team10;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.util.Duration;

public class Graphic_Handler {
	private static final String APPLICATION_NAME = "Cell Society";
	public static final int SCREEN_WIDTH = 700;
	public static final int SCREEN_HEIGHT = 700;
	private Stage current_stage;
	private Scene current_scene;
	private Group root;
	private User_Interface ui;
	public static final int FRAMES_PER_SECOND = 60;
	private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private double rate;
	Timeline animation;


	public Graphic_Handler(Stage main_stage){

		current_stage = main_stage;
		root = new Group();
		ui= new User_Interface();
		set_up_scene();
		rate= ui.change_rate();
	}


	public void set_up_scene() {
		current_scene = scene_creation();
		root.getStylesheets().add("/cellsociety_team10/Stylesheet.css");
		current_stage.setScene(current_scene);
		current_stage.setTitle(APPLICATION_NAME);
		current_stage.show();
		ui.set_up_base_scene(root);
		set_up_timeline();



	}

	private void set_up_timeline(){
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY));
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}



	public void step(double delay){


		if(check_status()) {
			if(ui.change_rate()!= rate){
				change_rate(ui.change_rate());
				rate = ui.change_rate();
			}

			ui.get_panel().update();
		}

	}

	public void change_rate(double dub){

		animation.setRate(dub);

		System.out.println(animation.getCurrentRate());
		set_up_timeline();

	}


	private boolean check_status(){
		return ui.get_status();
	}

	public Scene scene_creation(){
		return new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
	}







}
