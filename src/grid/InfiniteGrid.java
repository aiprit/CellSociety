package grid;

import java.util.ArrayList;
import block.Block;
import block.Location;

public class InfiniteGrid<E> extends BoundedGrid<E>{
	public InfiniteGrid(int rows, int cols) {
		super(rows, cols);
	}
	
	public ArrayList<Location> getValidAdjacentLocations(Location loc) {
		ArrayList<Location> locs = new ArrayList<Location>();
		int d = Location.NORTH;
		  for (int i = 0, limit = Location.FULL_CIRCLE / Location.HALF_RIGHT; i < limit; i++) {
	            Location neighborLoc = loc.getAdjacentLocation(d);
	            if (!isValid(neighborLoc)){
	            	put(neighborLoc, null);
	            }
	            locs.add(neighborLoc);
	            d = d + Location.HALF_RIGHT;
		  }
		  return locs;
	}
	
	@SuppressWarnings("unchecked")
	public E get(Location loc, E obj) {
		return (E) occupantArray[loc.getRow()][loc.getCol()];
	}
	
	@Override 
	public E put(Location loc, E obj) {
		E oldOccupant = get(loc);
		occupantArray[loc.getRow()][loc.getCol()] = obj;
		return oldOccupant;
	}
	
	@Override
	public E remove(Location loc) {
		E r = get(loc);
		occupantArray[loc.getRow()][loc.getCol()] = null;
		return r;
	}
}
