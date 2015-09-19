package cellsociety_team10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.paint.Color;

public class SpreadingFire extends AbstractSimulation{

	private static Color backColor = Color.YELLOW;
	private double probCatch;
	public SpreadingFire(int rows, int cols, double fraction1, double fraction2, double prob) {
		super(rows, cols, fraction1, fraction2);
		probCatch = prob;
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
			new Flammable().putSelfInGrid(theWorld, locs.get(i));
		for(int i = num1, limit = num1 + num2; i < limit; i++)
			new Burning(probCatch).putSelfInGrid(theWorld, locs.get(i));
	}
	@Override
	public Color getEmptyColor() {
		// TODO Auto-generated method stub
		return backColor;
	}





	@Override
	public Block chooseBlock(boolean placeBlock) {
		Block result= placeBlock ? new Flammable():new Burning(probCatch);
		return result;
	}
}

