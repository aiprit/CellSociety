// This entire file is part of my masterpiece.
// Rob Martorano

package parameter;

import simulation.AbstractSimulation;
import java.util.ArrayList;
import java.util.HashMap;


abstract public class Parameters {
    protected ArrayList<String> list_of_parameters;
    protected HashMap<String, Double> init_params;
    protected String grid_type;
    String blue_line;
    String orange_line;

    //Variables not currently used but could be useful in future
    String simulation_type;
    String name;
    String author;

    public Parameters(){
        init_params = new HashMap<String, Double>();
        list_of_parameters = new ArrayList<String>();
        list_of_parameters.add("grid_size");
        fill_param_array();
        fill_map();


    }

    protected ArrayList<String> get_param_list(){
        return list_of_parameters;
    }

    public HashMap<String, Double>  get_param_map(){
        return init_params;
    }

    public String get_grid_type(){
        return grid_type;
    }

    protected void set_grid_type(String s){
        this.grid_type = s;
    }

    public String get_blue_line() {
        return blue_line;
    }

    protected void set_blue_line(String blue_line) {
        this.blue_line = blue_line;
    }

    public String get_orange_line() {
        return orange_line;
    }

    protected void set_orange_line(String blue_line) {
        this.orange_line = blue_line;
    }



    abstract protected void fill_param_array();

    protected void fill_map(){
        for(String param: list_of_parameters){
            init_params.put(param, 0.0);
        }
    }

    abstract protected AbstractSimulation get_sim();

}
