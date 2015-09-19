package cellsociety_team10;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javafx.scene.paint.Color;

public class PredatorPreySim extends AbstractSimulation{

    private static Color oceanColor = Color.BLUE; //blue
    private static double sharkBreedTime, fishBreedTime, sharkStarveTime;
    
    @Override
    public Color getEmptyColor() {
        return oceanColor;
    }
    
    public PredatorPreySim(HashMap<String, Double> map){
        super(map);
        sharkBreedTime = map.get("standard_breed_time_shark");
        fishBreedTime = map.get("standard_breed_time_fish");
        sharkStarveTime = map.get("standard_starve_time");
        reset(map.get("percent_sharks"), map.get("percent_fish"));
    }
   
    @Override
	public void populateIndefinite(int numFish, int numSharks) {
        ArrayList<Location> locs = new ArrayList<Location>();
        int a =theWorld.getNumRows();
        for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++)
            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++)
                locs.add(new Location(r, c));
        Collections.shuffle(locs);
        for(int i = 0; i < numFish; i++)
            new FishBlock().putSelfInGrid(theWorld, locs.get(i));
        for(int i = numFish, limit = numFish + numSharks; i < limit; i++)
            new SharkBlock().putSelfInGrid(theWorld, locs.get(i));
    }

    public  Block chooseBlock(boolean placeBlock){
    	Block result= placeBlock ? new FishBlock():new SharkBlock();
    return result;
    }

    @Override
    public void populateDefinite(int numFish, int numSharks) {
        loopToPlace(numFish, true); 
        loopToPlace(numSharks, false);
    }
    
   
   
}
