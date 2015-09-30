package ui;

import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Graphic_Handler {
	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
	private Stage current_stage;
	private Scene current_scene;
	private Group root;
	private User_Interface ui;
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
		root.getStylesheets().add(myResources.getString("StyleSheet"));
		current_stage.setScene(current_scene);
		current_stage.setTitle(myResources.getString("ApplicationName"));
		current_stage.show();
		ui.set_up_base_scene(root);
		set_up_timeline();



	}

	private void set_up_timeline(){
		KeyFrame frame = new KeyFrame(Duration.millis(Double.parseDouble(myResources.getString("MillisecondDelay"))),
				e -> step(Double.parseDouble(myResources.getString("SecondDelay"))));
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.setRate(Double.parseDouble(myResources.getString("StartSpeed")));
		animation.play();
	}



	public void step(double delay){


		if(check_status()) {
			if(ui.change_rate()!= rate){
				change_rate(ui.change_rate());
				rate = ui.change_rate();
			}

			ui.get_panel().update();
			ui.get_chart_panel().chart_handler(ui.get_panel().getSum1(), ui.get_panel().getSum2());

		}

	}

	public void change_rate(double dub){

		animation.pause();
		animation.setRate(dub);
		animation.playFromStart();


	}


	private boolean check_status(){
		return ui.get_status();
	}

	public Scene scene_creation(){
		return new Scene(root, Integer.parseInt(myResources.getString("ScreenWidth")), Integer.parseInt(myResources.getString("ScreenHeight")));
	}







}
