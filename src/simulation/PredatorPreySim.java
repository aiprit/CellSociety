package simulation;


import block.Block;
import block.FishBlock;
import block.Location;
import block.SharkBlock;
import javafx.scene.paint.Color;
import parameter.Parameters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PredatorPreySim extends AbstractSimulation {

    private double sharkBreedTime, fishBreedTime, sharkStarveTime;

    @Override
    public Color getEmptyColor() {
        return Color.BLUE;
    }

    public PredatorPreySim(Parameters parameter){
        super(parameter);
        sharkBreedTime = parameter.get_param_map().get("standard_breed_time_shark");
        fishBreedTime = parameter.get_param_map().get("standard_breed_time_fish");
        sharkStarveTime = parameter.get_param_map().get("standard_starve_time");
       // System.out.println(sharkBreedTime) ;
        //System.out.println(fishBreedTime);
       // System.out.println(sharkStarveTime);
        reset(parameter.get_param_map().get("percent_fish"),parameter.get_param_map().get("percent_sharks"));
    }

    @Override
	public void populateIndefinite(int numFish, int numSharks) {
        ArrayList<Location> locs = new ArrayList<Location>();
        for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++)
            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++)
                locs.add(new Location(r, c));
        Collections.shuffle(locs);
        for(int i = 0; i < numFish; i++)
            new FishBlock().putSelfInGrid(theWorld, locs.get(i));
        for(int i = numFish, limit = numFish + numSharks; i < limit; i++)
            new SharkBlock().putSelfInGrid(theWorld, locs.get(i));
    }

    public Block chooseBlock(boolean placeBlock){
    	Block result= placeBlock ? new FishBlock():new SharkBlock();
    return result;
    }

    @Override
    public void populateDefinite(int numFish, int numSharks) {
        loopToPlace(numFish, true);
        loopToPlace(numSharks, false);
    }


}
