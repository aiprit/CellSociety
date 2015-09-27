package parameter;

import simulation.AbstractSimulation;
import java.util.ArrayList;
import java.util.HashMap;


abstract public class Parameters {
    protected ArrayList<String> list_of_parameters;
    protected HashMap<String, Double> init_params;
    protected String grid_type;
    String simulation_type;

    String blue_line;

    String orange_line;
    String name;
    String author;
    double grid_size;

    public Parameters(){
        init_params = new HashMap<String, Double>();
        list_of_parameters = new ArrayList<String>();
        list_of_parameters.add("grid_size");


    }

    public ArrayList<String> get_param_list(){
        return list_of_parameters;
    }

    public HashMap<String, Double>  get_param_map(){
        return init_params;
    }

    public String get_grid_type(){
        return grid_type;
    }
    public void set_grid_type(String s){
        grid_type = s;
    }

    public void set_blue_line(String blue_line) {
        this.blue_line = blue_line;
    }

    public String get_blue_line() {
        return blue_line;
    }

    public void set_orange_line(String blue_line) {
        this.orange_line = blue_line;
    }

    public String get_orange_line() {
        return orange_line;
    }

    abstract protected void fill_param_array();

    protected void fill_map(){
        for(String param: list_of_parameters){
            init_params.put(param, 0.0);
        }
    }

    abstract public AbstractSimulation get_sim();

}
