package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import block.Block;
import block.FoodBlock;
import block.GroundBlock;
import block.Location;
import block.NestBlock;
import javafx.scene.paint.Color;

public class ForagingAntsSim extends AbstractSimulation{

	private static Color emptyColor = Color.BROWN;

	public ForagingAntsSim(HashMap<String, Double> map) {
		super(map);
		reset(1,1);
	}

	@Override
	public void populateWorld(double fraction1, double fraction2) {
		Random r = new Random();
		int row1 = r.nextInt(getNumRows());
		int col1 = r.nextInt(getNumCols());
		int row2 = r.nextInt(getNumRows());
		int col2 = r.nextInt(getNumCols());

		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumCols(); j++) {
				if (i==row1 && j == col1) {
					new NestBlock().putSelfInGrid(theWorld, new Location(i,j));
				}
				else if (i == row2 && j == col2) {
					new FoodBlock().putSelfInGrid(theWorld, new Location(i,j));
				}
				else {
					new GroundBlock(0,0).putSelfInGrid(theWorld, new Location(i,j));
				}
			}
		}
	}

	public Color getEmptyColor() {
		return emptyColor;
	}

	@Override
	public Block chooseBlock(boolean placeBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void step() {
		List<Location> occupiedLocations = theWorld.getOccupiedLocations();
		Collections.shuffle(occupiedLocations);
		ArrayList<Location> list = new ArrayList<Location>();
		for(Location loc : occupiedLocations){
			Block a = theWorld.get(loc);
			// in case eaten
			if(a.getChar() == 'A'||a.getChar() == 'H')
				list.add(loc);

		}
		for (Location loca: list) {
			Block a = theWorld.get(loca);
			a.act();
		}
//		occupiedLocations = theWorld.getOccupiedLocations();
//		list = new ArrayList<Location>();
//		for(Location loc : occupiedLocations){
//			Block a = theWorld.get(loc);
//			if(a.getChar() == 'G'){
//				list.add(loc);
//			}
//		}
//		for (Location loca: list) {
//			Block a = theWorld.get(loca);
//			a.act();
//		}
	}
	@Override
	public void populateDefinite(int num1, int num2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void populateIndefinite(int num1, int num2) {
		// TODO Auto-generated method stub

	}

}
