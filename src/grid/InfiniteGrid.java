package grid;

import java.util.ArrayList;
import java.util.List;

import block.Block;
import block.Location;

public class InfiniteGrid<E> extends BoundedGrid<E>{
	public InfiniteGrid(int rows, int cols) {
		super(rows, cols);
	}
	
	public List<Location> getValidAdjacentLocations(Location loc) {
		List<Location> locs = new ArrayList<Location>();
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
}
