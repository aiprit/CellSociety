# Visualization API

### Graphic_Handler
    set_up_scene() - Set up scene 
    step(double delay) - Step through animation
    change_rate(double dub) - Change the rate of the simulation
    Scene scene_creation() - Create Scene from User Interface

### User_Interface
    Constructor User_Interface()
    set_up_base_scene(Group basic) - Create basic barebone scene for simulation
    outer_border_set_up() - Set up border pane design
    control_panel_set_up() - Set up right column for controlling simulation
    add_elements_to_pane() - Add elements to the control panel
    ChartPanel get_chart_panel() - Get graph
    boolean get_status() - Get the status of the interface
    double change_rate() - Change rate of simuation


### ChartPanel
    Constructor ChartPanel(int row) 
    Canvas get_canvas() - get graph
    void chart_handler(double sum1, double sum2) - form chart and get running
