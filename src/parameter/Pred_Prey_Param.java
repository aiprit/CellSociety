package parameter;

import simulation.AbstractSimulation;
import simulation.PredatorPreySim;

/**
 * Created by Rob on 9/19/15.
 */
public class Pred_Prey_Param extends Parameters {


    public Pred_Prey_Param(){
        super();
        fill_param_array();
        fill_map();
    }

    public void fill_param_array(){
        list_of_parameters.add("percent_sharks");
        list_of_parameters.add("percent_fish");
        list_of_parameters.add("standard_breed_time_shark");
        list_of_parameters.add("standard_breed_time_fish");
        list_of_parameters.add("standard_starve_time");
    }

    public AbstractSimulation get_sim(){
        return new PredatorPreySim(init_params);
    }







}
