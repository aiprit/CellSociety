package simulation;

import block.Block;
import block.BlueBlock;
import block.Location;
import block.RedBlock;
import javafx.scene.paint.Color;
import parameter.Parameters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SegregationSim extends AbstractSimulation {

	private ResourceBundle myResources;
	private static double happyPercentage;

    public double getHappyPercentage() {
    	return happyPercentage;
    }

    @Override
    public Color getEmptyColor() {
        return (Color)myResources.getObject("EmptySegColor");
    }

    public SegregationSim(Parameters parameter) {
        super(parameter);
    	happyPercentage = parameter.get_param_map().get("happy_percent");
        reset(parameter.get_param_map().get("percent_blue"), parameter.get_param_map().get("percent_red") );
    }

    public Block chooseBlock(boolean placeBlock) {
		Block result = placeBlock ? new BlueBlock(happyPercentage) : new RedBlock(happyPercentage);
		return result;
	}

	@Override
	public void populateDefinite(int numBlueBlocks, int numRedBlocks) {
		loopToPlace(numBlueBlocks, true);
		loopToPlace(numRedBlocks, false);
	}

	@Override
	public void populateIndefinite(int numBlueBlocks, int numRedBlocks) {
		ArrayList<Location> locs = new ArrayList<Location>();
        for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++)
            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++)
                locs.add(new Location(r, c));
        Collections.shuffle(locs);
        for(int i = 0; i < numBlueBlocks; i++)
            new BlueBlock(happyPercentage).putSelfInGrid(theWorld, locs.get(i));
        for(int i = numBlueBlocks, limit = numBlueBlocks + numRedBlocks; i < limit; i++)
            new RedBlock(happyPercentage).putSelfInGrid(theWorld, locs.get(i));
	}

}
