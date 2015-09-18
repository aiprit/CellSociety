package cellsociety_team10;

import javafx.scene.Node;

import java.util.ArrayList;

public class UI_Segregation extends User_Interface {

	private Custom_Slider similar_slider;
	private Custom_Slider red_blue_slider;
	private Custom_Slider empty_slider;
	private Custom_Slider size_slider;
	private Custom_Slider delay_slider;
	private Custom_Button reset_button;
	private Custom_Button start_button;
	private Custom_Button stop_button;
	private Custom_Button step_button;
	protected ArrayList<Node> button_list;
	protected ArrayList<Node> slider_list;

	public UI_Segregation() {
		button_list = new ArrayList<Node>();
		slider_list = new ArrayList<Node>();
		// TODO Auto-generated constructor stub
		sliders_initializer();
	}

	private void sliders_initializer(){
		init_similar_slider();
		init_red_blue_slider();
		init_empty_slider();
		init_size_slider();
		init_delay_slider();
		for(Node slider: slider_list){
			control_panel.getChildren().add(slider);
		}
	}


	private void init_similar_slider(){
		similar_slider = new Custom_Slider(0, 100,30);
		slider_list.add(similar_slider);
	}
	private void init_red_blue_slider(){
		// 100 is all red, 0 is all blue
		red_blue_slider = new Custom_Slider(0, 100,50);
		slider_list.add(red_blue_slider);
	}
	private void init_empty_slider(){
		empty_slider = new Custom_Slider(0,100, 10);
		slider_list.add(empty_slider);
	}

	private void init_size_slider(){
		size_slider = new Custom_Slider(0,50, 30);
		slider_list.add(size_slider);
	}

	private void init_delay_slider(){
		delay_slider = new Custom_Slider(0, 3000, 100);
		slider_list.add(delay_slider);
	}

	private void button_initializer(){
		init_reset_button();
		init_start_button();
		init_stop_button();
		init_step_button();
		for(Node button: button_list){
			control_panel.getChildren().add(button);
		}
	}

	private void init_reset_button(){
		reset_button = new Custom_Button("Reset");
		button_list.add(reset_button);
	}

	private void init_start_button(){
		start_button = new Custom_Button("Start");
		button_list.add(start_button);
	}

	private void init_stop_button(){
		stop_button = new Custom_Button("Stop");
		button_list.add(stop_button);
	}

	private void init_step_button(){
		step_button = new Custom_Button("Step");
		button_list.add(step_button);
	}







}
