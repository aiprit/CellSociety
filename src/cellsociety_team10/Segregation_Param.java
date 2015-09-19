package cellsociety_team10;

/**
 * Created by Rob on 9/19/15.
 */
public class Segregation_Param extends Parameters{

    public Segregation_Param(){
        super();
        fill_param_array();
        fill_map();
    }


    public void fill_param_array(){
        list_of_parameters.add("happy_percent");
        list_of_parameters.add("percent_blue");
        list_of_parameters.add("percent_red");

    }

    public AbstractSimulation get_sim(){
        return new SegregationSim(init_params);
    }

}
