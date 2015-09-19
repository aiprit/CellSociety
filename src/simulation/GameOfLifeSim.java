package simulation;

import block.AliveBlock;
import block.Block;
import block.DeadBlock;
import block.Location;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameOfLifeSim extends AbstractSimulation {

		private static Color emptyColor = Color.BEIGE;

		@Override
		public Color getEmptyColor() {
	        return emptyColor;
	    }
		
		public GameOfLifeSim(HashMap<String, Double> map) {
			super(map);
			reset(map.get("percent_alive"), map.get("percent_dead"));
		}
		
		public Block chooseBlock(boolean placeBlock) {
			Block result = placeBlock ? new DeadBlock() : new AliveBlock();
			return result;
		}

		
		@Override
		public void populateDefinite(int numDeadBlocks, int numAliveBlocks) {
			loopToPlace(numDeadBlocks, true);
			loopToPlace(numAliveBlocks, false);
		}

		@Override
		public void populateIndefinite(int numDeadBlocks, int numAliveBlocks) {
			ArrayList<Location> locs = new ArrayList<Location>();
	        for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++)
	            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++)
	                locs.add(new Location(r, c));
	        Collections.shuffle(locs);
	        for(int i = 0; i < numDeadBlocks; i++)
	            new DeadBlock().putSelfInGrid(theWorld, locs.get(i));
	        for(int i = numDeadBlocks, limit = numDeadBlocks + numAliveBlocks; i < limit; i++)
	            new AliveBlock().putSelfInGrid(theWorld, locs.get(i));
		}
}
