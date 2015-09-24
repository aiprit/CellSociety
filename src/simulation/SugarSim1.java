package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import block.AgentBlock;
import block.Block;
import block.FishBlock;
import block.FoodBlock;
import block.GroundBlock;
import block.Location;
import block.NestBlock;
import block.SugarBlock;
import javafx.scene.paint.Color;

public class SugarSim1 extends AbstractSimulation{
	private static Color emptyColor = Color.WHITE;

	public SugarSim1(HashMap<String, Double> map){
		super(map);
	}
	@Override
	public void populateWorld(double maxsugar, double fraction2) {

		if(fraction2 > 1) {
			// too many creatures. scale each
			fraction2= fraction2 / 3;
		}
		int num2 = (int) (fraction2 * getNumSpots());
		populateIndefinite((int)maxsugar, num2);
	}

	@Override
	public Block chooseBlock(boolean placeBlock) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void populateDefinite(int num1, int num2) {
		// TODO Auto-generated method stub

	}
	@Override
	public void populateIndefinite(int maxsugar, int num2) {
		 ArrayList<Location> locs = new ArrayList<Location>();
		 Random r1 = new Random(6);
		 Random r2 = new Random(4);
		 Random r3 = new Random(maxsugar);
		for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++){
            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++){
            	locs.add(new Location(r, c));
            }
        }
		 Collections.shuffle(locs);
	        for(int i = 0; i < num2; i++){
	            new AgentBlock(maxsugar,r2.nextInt(),r1.nextInt()).putSelfInGrid(theWorld, locs.get(i));
	            locs.remove(locs.get(i));
	        }
	        for(Location sugar:locs){
	        	new SugarBlock(r3.nextInt(),maxsugar);
	        }
	}
	@Override
	public Color getEmptyColor() {
		// TODO Auto-generated method stub
		return null;
	}

}
