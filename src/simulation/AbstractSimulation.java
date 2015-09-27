package simulation;

import block.Block;
import block.FishBlock;
import block.Location;
import block.SharkBlock;
import grid.BoundedGrid;
import grid.Grid;
import grid.InfiniteGrid;
import javafx.scene.paint.Color;
import parameter.Parameters;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public abstract class AbstractSimulation {
	protected String simulationType;
	protected Grid<Block> theWorld;
	private ArrayList<String> param_list;

	public AbstractSimulation(Parameters parameter) {
		//theWorld = new BoundedGrid<Block>(parameter.get_param_map().get("grid_size").intValue(), parameter.get_param_map().get("grid_size").intValue());

		try {
			Class c = Class.forName("grid."+parameter.get_grid_type().trim());
			Class[] cArg = new Class[2]; //Our constructor has 3 arguments
			cArg[0] = int.class; //First argument is of *object* type Long
			cArg[1] = int.class; //Second argument is of *object* type String
			int i = parameter.get_param_map().get("grid_size").intValue();

			try {
				theWorld = (Grid<Block>) c.getDeclaredConstructor(cArg).newInstance(i, i);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> get_param_list(){
		return param_list;
	}

	protected void reset(double fraction1, double fraction2){
		List<Location> occupiedCells = theWorld.getOccupiedLocations();
		for(Location loc : occupiedCells){
			theWorld.get(loc).removeSelfFromGrid();
		}
		populateWorld(fraction1, fraction2);
	}
	public void loopToPlace(int num, boolean place){
		int placed = 0;
		Random r = new Random();
		List<Location> locsUsed = new ArrayList<Location>();
		while(placed < num){
			int row = r.nextInt(theWorld.getNumRows());
			int col = r.nextInt(theWorld.getNumCols());
			Location loc = new Location(row, col);
			if(theWorld.get(loc) == null){
				placed++;
				Block result = chooseBlock(place);
				result.putSelfInGrid(theWorld, loc);
				locsUsed.add(loc);
			}
		} 
	}
	public abstract Block chooseBlock(boolean placeBlock);

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
		List<Location> occupiedLocations = theWorld.getOccupiedLocations();
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