package ui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import resources.Parser;
import xml_creation.XML_Builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class User_Interface {
    private Group basic_scene;
    private BorderPane outer_format;
    protected VBox control_panel;
    private ChartPanel chart;
    private Label title;
    private GridPane grid_view;
    private ArrayList<Node> option_list;
    Parser parser;
    private GridPanel panel;
    private Canvas canvas;
    private Canvas graph_canvas;
    private boolean status;
    private double rate;
    HashMap<String,String> sim_map;
    String current_sim;
    private ResourceBundle myResources;
    private ResourceBundle bleh;
    private ComboBox<String> simulation_choices;

    public User_Interface(String property){
        myResources = ResourceBundle.getBundle(myResources.getString("DefaultResourcePackage")+ property);
        status = false;
        control_panel = new VBox();
        grid_view = new GridPane();

        title = new Label(myResources.getString("Title"));
        title.setId("title");
        option_list = new ArrayList<Node>();

        sim_chooser();


    }
    
    private void sim_chooser(){

        sim_map = new HashMap<String, String>();
        sim_map.put(myResources.getString("SimSeg"), myResources.getString("XmlSeg"));
        sim_map.put(myResources.getString("SimPP"), myResources.getString("XmlPP"));
        sim_map.put(myResources.getString("SimFire"), myResources.getString("XmlFire"));
        sim_map.put(myResources.getString("SimGOL"), myResources.getString("XmlGOL"));
        sim_map.put(myResources.getString("SimAnts"),myResources.getString("XmlAnts"));
        sim_map.put(myResources.getString("SimSugar"),myResources.getString("XmlSugar"));
    }



    public void set_up_base_scene(Group basic){
        outer_border_set_up();
        control_panel_set_up();
        add_elements_to_pane();
        basic.getChildren().add(outer_format);
    }

    public void outer_border_set_up(){
        outer_format = new BorderPane();
        outer_format.setPrefSize((int)myResources.getObject("ScreenWidth"), (int)myResources.getObject("ScreenHeight"));
        outer_format.setId("pane");
    }

    public void control_panel_set_up(){
        control_panel = new VBox();
        control_panel.setSpacing((int)myResources.getObject("VerticalSpacing"));
    }



    public void add_elements_to_pane(){
        outer_format.setRight(control_panel);
        outer_format.setLeft(canvas);
        outer_format.setTop(title);
        outer_format.setBottom(graph_canvas);
        outer_format.setAlignment(title, Pos.TOP_CENTER);
        outer_format.setAlignment(control_panel, Pos.CENTER_RIGHT);
        init_generic_options();
    }

    private void init_generic_options(){
        init_custom_button();
        init_simulation_chooser();
        init_start_button();
        init_stop_button();
        init_step_button();
        init_reset_button();

        init_animation_speed_slider();

        for(Node option: option_list){
            control_panel.getChildren().add(option);
        }
    }

    private void init_start_button(){
        Custom_Button start_button = new Custom_Button(myResources.getString("Startbutton"));
        start_button.setOnAction((event) -> start());
        option_list.add(start_button);

    }


    private void init_stop_button(){
        Custom_Button stop_button = new Custom_Button(myResources.getString("Stopbutton"));
        stop_button.setOnAction((event) -> stop());
        option_list.add(stop_button);
    }

    private void init_step_button(){
        Custom_Button step_button = new Custom_Button(myResources.getString("Stepbutton"));
        step_button.setOnAction((event) -> step());
        option_list.add(step_button);
    }
    private void init_reset_button(){
        Custom_Button reset_button = new Custom_Button(myResources.getString("Resetbutton"));
        reset_button.setOnAction((event) -> reset());
        option_list.add(reset_button);
    }
    private void init_custom_button(){
        Custom_Button custom_button = new Custom_Button("CustomSimButton");
        custom_button.setOnAction((event) -> custom());
        custom_button.setId("custom");
        option_list.add(custom_button);
    }

    private void init_animation_speed_slider(){
        Label speed = new Label(myResources.getString("SpeedLabel"));
        //speed.s
        Custom_Slider animation_speed_slider = new Custom_Slider((double)myResources.getObject("MinSpeed"), (int)myResources.getObject("MaxSpeed"),
        		(double)myResources.getObject("StartSpeed"));
        animation_speed_slider.valueProperty().addListener((observable, oldValue, newValue) -> {

            rate = newValue.doubleValue();
        });
        option_list.add(speed);

        option_list.add(animation_speed_slider);
    }

    private void init_simulation_chooser(){
        simulation_choices = new ComboBox<String>();

        simulation_choices.setValue(myResources.getString("SimChoice"));
        for(String simulation: sim_map.keySet()){
            simulation_choices.getItems().add(simulation);

        }
        option_list.add(simulation_choices);
        simulation_choices.setOnAction((event) -> {
            set_sim(simulation_choices.getValue());

        });

    }

    private void init_grid_cell_chooser(){
        simulation_choices = new ComboBox<String>();

        simulation_choices.setValue(myResources.getString("SimChoice"));
        for(String simulation: sim_map.keySet()){
            simulation_choices.getItems().add(simulation);

        }
        option_list.add(simulation_choices);
        simulation_choices.setOnAction((event) -> {
            set_sim(simulation_choices.getValue());

        });

    }



    public GridPanel get_panel(){
        return panel;
    }

    public ChartPanel get_chart_panel(){return chart;}


    public boolean get_status(){
        return status;
    }

    private void start(){
        status = true;

    }
    private void stop(){
        status = false;

    }
    private void step(){

        panel.update();
        chart.chart_handler(panel.getSum1(), panel.getSum2());

    }

    private void reset(){
        set_sim(current_sim);
    }

    private void custom(){
        XML_Builder builder = new XML_Builder();
        builder.getD();
        while(builder.check_params());
        sim_map.put(myResources.getString("CustomSim"),myResources.getString("XmlTest"));
        simulation_choices.setValue(myResources.getString("CustomSim"));


    }

    private void set_sim(String key){
        current_sim = key;
        System.out.println(sim_map.get(key));
        parser = new Parser(sim_map.get(key));
        panel = new GridPanel(parser.parse());
        chart = new ChartPanel();
        canvas = panel.getCanvas();
        graph_canvas = chart.get_canvas();
        outer_format.setLeft(canvas);
        outer_format.setBottom(graph_canvas);
    }

    public double change_rate(){
        return rate;
    }
}
