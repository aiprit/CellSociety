package parameter;

import simulation.AbstractSimulation;
import simulation.SegregationSim;
import simulation.SugarSim1;

/**
 * Created by Rob on 9/19/15.
 */
public class Sugar_Param extends Parameters {

    public Sugar_Param(){
        super();
        fill_param_array();
        fill_map();
    }


    public void fill_param_array(){
        list_of_parameters.add("vision");
        list_of_parameters.add("metabolism");
        list_of_parameters.add("agent_fract");
        list_of_parameters.add("maxsugar");
        list_of_parameters.add("maxsugarblood");
        list_of_parameters.add("sugargrowth");

    }

    public AbstractSimulation get_sim(){
        return new SugarSim1(this);
    }

}
