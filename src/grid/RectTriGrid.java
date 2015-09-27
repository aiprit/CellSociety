package grid;

import block.Location;
import java.util.ArrayList;
import java.util.List;

public abstract class RectTriGrid<E> extends AbstractGrid<E>{
	public List<E> getNeighbors(Location loc)
	{
		List<E> neighbors = new ArrayList<E>();
		for (Location neighborLoc : getOccupiedAdjacentLocations(loc))
			neighbors.add(get(neighborLoc));
		return neighbors;
	}

	public List<Location> getValidAdjacentLocations(Location loc)
	{
		List<Location> locs = new ArrayList<Location>();
		int d = Location.NORTH;
		for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_RIGHT; i++)
		{
			Location neighborLoc = loc.getAdjacentLocation(d);
			if (isValid(neighborLoc))
				locs.add(neighborLoc);
			d = d + Location.HALF_RIGHT;
		}
		return locs;
	}

	public List<Location> getEmptyAdjacentLocations(Location loc)
	{
		List<Location> locs = new ArrayList<Location>();
		for (Location neighborLoc : getValidAdjacentLocations(loc))
		{
			if (get(neighborLoc) == null)
				locs.add(neighborLoc);
		}
		return locs;
	}

	public List<Location> getOccupiedAdjacentLocations(Location loc)
	{
		List<Location> locs = new ArrayList<Location>();
		for (Location neighborLoc : getValidAdjacentLocations(loc))
		{
			if (get(neighborLoc) != null)
				locs.add(neighborLoc);
		}
		return locs;
	}

	
}
