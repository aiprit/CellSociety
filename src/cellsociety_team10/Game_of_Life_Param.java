package cellsociety_team10;

/**
 * Created by Rob on 9/19/15.
 */
public class Game_of_Life_Param extends Parameters{
    public Game_of_Life_Param(){
        super();
        fill_param_array();
        fill_map();
    }

    public void fill_param_array(){
        list_of_parameters.add("percent_alive");
        list_of_parameters.add("percent_dead");

    }

    public AbstractSimulation get_sim(){
        return new GameOfLifeSim(init_params);
    }
}
