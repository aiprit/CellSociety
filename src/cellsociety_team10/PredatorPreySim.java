package cellsociety_team10;


import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.paint.Color;

public class PredatorPreySim extends AbstractSimulation{

    private static Color oceanColor = Color.BLUE; //blue
    
    @Override
    public Color getEmptyColor() {
        return oceanColor;
    }
    
    public PredatorPreySim(int rows, int cols, double fractionFish, double fractionSharks){
        super(rows, cols, fractionFish, fractionSharks);
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
            new Fish().putSelfInGrid(theWorld, locs.get(i));
        for(int i = numFish, limit = numFish + numSharks; i < limit; i++)
            new Shark().putSelfInGrid(theWorld, locs.get(i));
    }

    public  Block chooseBlock(boolean placeBlock){
    	Block result= placeBlock ? new Fish():new Shark();
    return result;
    }

    
    
    @Override
    public void populateDefinite(int numFish, int numSharks) {
        loopToPlace(numFish, true); 
        loopToPlace(numSharks, false);
    }
    
    @Override
    public void loopToPlace(int num, boolean placeFish){
    	int placed = 0;
		Random r = new Random();
		ArrayList<Location> locsUsed = new ArrayList<Location>();
		while(placed < num){
			int row = r.nextInt(theWorld.getNumRows());
			int col = r.nextInt(theWorld.getNumCols());
			Location loc = new Location(row, col);
			if(theWorld.get(loc) == null){
				placed++;
				Block result = placeFish ? new Fish() : new Shark();
				result.putSelfInGrid(theWorld, loc);
				locsUsed.add(loc);
			}
		} 
    }
   
    public int getNumFish(){
        return Fish.getNumFish();
    }

    public int getNumSharks(){
        return Shark.getNumSharks();
    }
}
