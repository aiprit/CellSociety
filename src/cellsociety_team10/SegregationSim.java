package cellsociety_team10;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.paint.Color;

public class SegregationSim extends AbstractSimulation {
	
    private static Color emptyColor = Color.BEIGE; //blue
    private static double happyPercentage;
    
    public double getHappyPercentage() {
    	return happyPercentage;
    }
    
    @Override
    public Color getEmptyColor() {
        return emptyColor;
    }
    
    public SegregationSim(int rows, int cols, double fractionBlue, double fractionRed) {
    	super(rows, cols, fractionBlue, fractionRed);
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
