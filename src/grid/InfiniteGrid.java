package grid;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import block.Block;
import block.Location;

public class InfiniteGrid<E> extends BoundedGrid<E>{
	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
	public InfiniteGrid(int rows, int cols) {
		super(rows, cols);
	}
	
	public List<Location> getValidAdjacentLocations(Location loc) {
		List<Location> locs = new ArrayList<Location>();
		int d = Integer.parseInt(myResources.getString("North"));
		  for (int i = 0, limit = Integer.parseInt(myResources.getString("FullCircle"))
				  / Integer.parseInt(myResources.getString("HalfRight")); i < limit; i++) {
	            Location neighborLoc = loc.getAdjacentLocation(d);
	            if (!isValid(neighborLoc)){
	            	put(neighborLoc, null);
	            }
	            locs.add(neighborLoc);
	            d = d + Integer.parseInt(myResources.getString("HalfRight"));
		  }
		  return locs;
	}
}
