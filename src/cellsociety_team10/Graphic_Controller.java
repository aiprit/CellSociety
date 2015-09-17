package cellsociety_team10;

import java.util.ArrayList;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Graphic_Controller {
	private static final String APPLICATION_NAME = "Cell Society";
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 800;
	private Stage current_stage;
	private ArrayList<Scene> simulations;
	private Scene current_scene;

	public Graphic_Controller(Stage main_stage){
		current_stage = main_stage;
	}

	public void set_up_scene(){
		current_stage.setScene(current_scene);
	    current_stage.setTitle(APPLICATION_NAME);
	    current_stage.show();
	}







}
