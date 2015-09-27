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
        list_of_parameters.add("vision");
        list_of_parameters.add("metabolism");
        list_of_parameters.add("maxsugar");
        list_of_parameters.add("maxsugarblood");
    }


    public AbstractSimulation get_sim(){
        return new ForagingAntsSim(this);
    }
}