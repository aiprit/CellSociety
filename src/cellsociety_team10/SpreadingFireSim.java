package cellsociety_team10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.paint.Color;

public class SpreadingFireSim extends AbstractSimulation{

	private static Color backColor = Color.YELLOW;
	private double probCatch;
	
	
	public SpreadingFireSim(Object parameters) {
		super(parameters.rows, parameters.cols, parameters.fraction1, parameters.fraction2);
		probCatch = parameters.probCatch;
	}

		

	

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
			new FlammableBlock().putSelfInGrid(theWorld, locs.get(i));
		for(int i = num1, limit = num1 + num2; i < limit; i++)
			new BurningBlock(probCatch).putSelfInGrid(theWorld, locs.get(i));
	}
	@Override
	public Color getEmptyColor() {
		// TODO Auto-generated method stub
		return backColor;
	}





	@Override
	public Block chooseBlock(boolean placeBlock) {
		Block result= placeBlock ? new FlammableBlock():new BurningBlock(probCatch);
		return result;
	}
}
