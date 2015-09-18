package cellsociety_team10;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Graphic_Handler {
	private static final String APPLICATION_NAME = "Cell Society";
	public static final int SCREEN_WIDTH = 700;
	public static final int SCREEN_HEIGHT = 700;
	private Stage current_stage;
	private ArrayList<Scene> simulations;
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

		current_stage.setScene(scene_creation());
		current_stage.setTitle(APPLICATION_NAME);
		current_stage.show();

		ui.set_up_base_scene(root);

	}

	public Scene scene_creation(){
		current_scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT, Color.GREY);
		root.getStylesheets().add("/Stylesheet.css");
		return current_scene;
	}







}
