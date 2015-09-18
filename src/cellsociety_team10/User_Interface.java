package cellsociety_team10;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class User_Interface {
    private Group basic_scene;
    private BorderPane outer_format;
    protected VBox control_panel;
    private Label title;
    private GridPane grid_view;
    private ArrayList<Node> option_list;


    public User_Interface(){
        control_panel = new VBox();
        grid_view = new GridPane();
        title = new Label("CellSociety");
        option_list = new ArrayList<Node>();
    }

    public void set_up_base_scene(Group basic){
        outer_border_set_up();
        control_panel_set_up();
        grid_view_setup();
        add_elements_to_pane();
        basic.getChildren().add(outer_format);
    }

    public void outer_border_set_up(){
        outer_format = new BorderPane();
        outer_format.setPrefSize(Graphic_Handler.SCREEN_HEIGHT, Graphic_Handler.SCREEN_WIDTH);
        outer_format.setId("pane");
    }

    public void control_panel_set_up(){
        control_panel = new VBox();
        control_panel.setSpacing(15);

    }

    public void grid_view_setup(){
        grid_view = new GridPane();
        grid_view.setPrefSize(300, 300);
        grid_view.setGridLinesVisible(true);

        for(int x = 0 ; x< 10; x++){
            for(int i = 0; i<10; i++){
                grid_view.add(new Button(), x, i);

            }
        }
    }

    public void add_elements_to_pane(){
        outer_format.setRight(control_panel);
        outer_format.setLeft(grid_view);
        outer_format.setTop(title);
        outer_format.setAlignment(title, Pos.TOP_CENTER);
        outer_format.setAlignment(control_panel, Pos.CENTER_RIGHT);
        outer_format.setAlignment(grid_view, Pos.CENTER_LEFT);
        init_generic_options();
    }

    private void init_generic_options(){
        init_start_button();
        init_stop_button();
        init_step_button();
        init_animation_speed_slider();
        for(Node option: option_list){
            control_panel.getChildren().add(option);
        }
    }

    private void init_start_button(){
        Custom_Button start_button = new Custom_Button("Start");
        option_list.add(start_button);
    }

    private void init_stop_button(){
        Custom_Button stop_button = new Custom_Button("Stop");
        option_list.add(stop_button);
    }

    private void init_step_button(){
        Custom_Button step_button = new Custom_Button("Step");
        option_list.add(step_button);
    }

    private void init_animation_speed_slider(){
        Custom_Slider animation_speed_slider = new Custom_Slider(0, 100, 20);
        option_list.add(animation_speed_slider);
    }

}
