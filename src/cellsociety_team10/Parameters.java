package cellsociety_team10;

import java.util.ArrayList;
import java.util.HashMap;


abstract public class Parameters {
    protected ArrayList<String> list_of_parameters;
    protected HashMap<String, Double> init_params;

    String simulation_type;
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

    abstract public void fill_param_array();

    protected void fill_map(){
        for(String param: list_of_parameters){
            init_params.put(param, 0.0);
        }
    }

    abstract public AbstractSimulation get_sim();

}
