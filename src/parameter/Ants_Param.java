package parameter;

import simulation.AbstractSimulation;
import simulation.ForagingAntsSim;
import simulation.SpreadingFireSim;

/**
 * Created by Rob on 9/19/15.
 */
public class Ants_Param extends Parameters {

    public Ants_Param(){
        super();
        fill_param_array();
        fill_map();
    }

    public void fill_param_array(){
        list_of_parameters.add("ant_life");
        list_of_parameters.add("max_pheremones");
        list_of_parameters.add("diffusion_rate");
        list_of_parameters.add("decrease_rate");
        
    }


    public AbstractSimulation get_sim(){
        return new ForagingAntsSim(this);
    }
}