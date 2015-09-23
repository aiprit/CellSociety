package grid;

import java.util.ArrayList;

import cell.Block;
import cell.Location;

public class InfiniteGrid<E> extends BoundedGrid<E>{
	public InfiniteGrid(int rows, int cols) {
		super(rows, cols);
	}
	
	public ArrayList<Location> getValidAdjacentLocations(Location loc) {
		ArrayList<Location> locs = new ArrayList<Location>();
		int d = Location.NORTH;
		for (int i = 0, limit = Location.FULL_CIRCLE / Location.HALF_RIGHT; i < limit; i++) {
			Location neighborLoc = loc.getAdjacentLocation(d);
			if (!isValid(neighborLoc)) {
				Block newBlock = new Block();
				newBlock.putSelfInGrid(, neighborLoc);
			}
		}
	}
}
