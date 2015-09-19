package cellsociety_team10;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;

public class Graphic_Handler {
	private static final String APPLICATION_NAME = "Cell Society";
	public static final int SCREEN_WIDTH = 700;
	public static final int SCREEN_HEIGHT = 700;
	private Stage current_stage;
	private Scene current_scene;
	private Group root;
	private User_Interface ui;


	public Graphic_Handler(Stage main_stage){

		current_stage = main_stage;
		root = new Group();
		ui= new User_Interface();
		set_up_scene();

	}

	public void set_up_scene() {
		current_scene = scene_creation();
		root.getStylesheets().add("/cellsociety_team10/Stylesheet.css");
		current_stage.setScene(current_scene);
		current_stage.setTitle(APPLICATION_NAME);
		current_stage.show();
		ui.set_up_base_scene(root);


	}

	public void step(double delay){
		//System.out.println("hi");
		if(ui.start==true) {
			ui.get_panel().update();
		}

	}


	public Scene scene_creation(){
		return new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
	}







}
