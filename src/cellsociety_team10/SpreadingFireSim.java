package cellsociety_team10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import javafx.scene.paint.Color;

public class SpreadingFireSim extends AbstractSimulation{

	private static Color backColor = Color.YELLOW;
	private double probCatch;

<<<<<<< HEAD
=======
=======
	
<<<<<<< HEAD
=======
	
>>>>>>> master
>>>>>>> 16fc013185ce961693826d055078a5bd11bc595f
>>>>>>> master
	public SpreadingFireSim(HashMap<String, Double> map) {
		super(map);
		probCatch = map.get("probability_catch");
		reset(map.get("percent_fire"),map.get("percent_tree"));
	}
<<<<<<< HEAD
	
=======





>>>>>>> 16fc013185ce961693826d055078a5bd11bc595f
	public void populateDefinite(int num1, int num2){
		loopToPlace(num1,true);
		loopToPlace(num2, false);
	}

	public void populateIndefinite(int num1, int num2){
		ArrayList<Location> locs = new ArrayList<Location>();
		for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++)
			for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++)
				locs.add(new Location(r, c));
		Collections.shuffle(locs);
		for(int i = 0; i < num1; i++)
			new TreeBlock().putSelfInGrid(theWorld, locs.get(i));
		for(int i = num1, limit = num1 + num2; i < limit; i++)
			new FireBlock(probCatch).putSelfInGrid(theWorld, locs.get(i));
	}

	@Override
	public Color getEmptyColor() {
		return backColor;
	}

	@Override
	public Block chooseBlock(boolean placeBlock) {
		Block result= placeBlock ? new TreeBlock():new FireBlock(probCatch);
		return result;
	}
	
	@Override
	public void step() {
		ArrayList<Location> occupiedLocations = theWorld.getOccupiedLocations();
		Collections.shuffle(occupiedLocations);
		ArrayList<Location> fires = new ArrayList<Location>();
		for(Location loc : occupiedLocations){
			Block a = theWorld.get(loc);
			// in case eaten
			if(a.getChar() != 'T')
				fires.add(loc);
		}
		for (Location loca: fires) {
			Block a = theWorld.get(loca);
			a.act();
		}
	}
}

