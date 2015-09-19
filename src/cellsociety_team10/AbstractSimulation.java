package cellsociety_team10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.paint.Color;

public abstract class AbstractSimulation {
	private String simulationType;
	private Grid<Block> theWorld;

	public AbstractSimulation(int rows, int cols, double fraction1, double fraction2) {
		theWorld = new BoundedGrid<Block>(rows, cols);
		reset(fraction1, fraction2);
	}

	public abstract void reset(double fraction1, double fraction2);

	public abstract void loopToPlace(int num, boolean place);

	public abstract void populateDefinite(int num1, int num2);

	public abstract void populateIndefinite(int num1, int num2);

	public void populateWorld(double fraction1, double fraction2) {
		double totalFractionCreatures = fraction1 + fraction2;
		if(totalFractionCreatures > 1) {
			// too many creatures. scale each
			fraction1 = fraction1 / totalFractionCreatures;
			fraction2= fraction2 / totalFractionCreatures;
		}
		int num1 = (int) (fraction1 * getNumSpots());
		int num2 = (int) (fraction2 * getNumSpots());
		if(num1 + num2 < getNumSpots() / 2)
			populateDefinite(num1, num2);
		else
			populateIndefinite(num1, num2);
	}

	public void step(){
		ArrayList<Location> occupiedLocations = theWorld.getOccupiedLocations();
		Collections.shuffle(occupiedLocations);
		for(Location loc : occupiedLocations){
			Block a = theWorld.get(loc);
			// in case eaten
			if(a != null)
				a.act();
		}
	}

	public Color getColor(int row, int col){
		Block a = theWorld.get(new Location(row, col));
		if(a == null)
			return getEmptyColor();
		else
			return a.getColor();
	}

	public abstract Color getEmptyColor();

	public int getNumSpots() {
		return theWorld.getNumRows() * theWorld.getNumCols();
	}

	public int getNumRows() {
		return theWorld.getNumRows();
	}

	public int getNumCols(){
		return theWorld.getNumCols();
	}

	public String toString(){
		StringBuilder b = new StringBuilder();
		for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++){
			for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++){
				Block a = theWorld.get(new Location(r, c));
				if(a == null)
					b.append('.');
				else
					b.append( a.getChar() );
			}
			b.append('\n');
		}
		return b.toString();
	}
}
