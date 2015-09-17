package cellsociety_team10;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class User_Interface {
    private Group basic_scene;
    private BorderPane outer_format;
    private VBox control_panel;
    private Label title;
    private GridPane grid_view;


    public User_Interface(){
        control_panel = new VBox();
        grid_view = new GridPane();
        title = new Label("CellSociety");
    }

    public void set_up_base_scene(Group basic){
        outer_format = new BorderPane();
        control_panel = new VBox();
        outer_format.setRight(control_panel);
        outer_format.setLeft(grid_view);
        outer_format.setTop(title);
        basic.getChildren().add(outer_format);
    }




}
