package grid;

import block.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public abstract class RectTriGrid<E> extends AbstractGrid<E>{
	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
	
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
		int d = Integer.parseInt(myResources.getString("North"));
		for (int i = 0; i < Integer.parseInt(myResources.getString("FullCircle")) / Integer.parseInt(myResources.getString("HalfRight")); i++)
		{
			Location neighborLoc = loc.getAdjacentLocation(d);
			if (isValid(neighborLoc))
				locs.add(neighborLoc);
			d = d + Integer.parseInt(myResources.getString("HalfRight"));
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
