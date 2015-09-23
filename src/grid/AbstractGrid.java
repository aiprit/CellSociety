package grid;

import block.Location;

import java.util.ArrayList;

public abstract class AbstractGrid<E> implements Grid<E>
{
	public ArrayList<E> getNeighbors(Location loc)
	{
		ArrayList<E> neighbors = new ArrayList<E>();
		for (Location neighborLoc : getOccupiedAdjacentLocations(loc))
			neighbors.add(get(neighborLoc));
		return neighbors;
	}

	public ArrayList<Location> getValidAdjacentLocations(Location loc)
	{
		ArrayList<Location> locs = new ArrayList<Location>();
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

	public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		for (Location neighborLoc : getValidAdjacentLocations(loc))
		{
			if (get(neighborLoc) == null)
				locs.add(neighborLoc);
		}
		return locs;
	}

	public ArrayList<Location> getOccupiedAdjacentLocations(Location loc)
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		for (Location neighborLoc : getValidAdjacentLocations(loc))
		{
			if (get(neighborLoc) != null)
				locs.add(neighborLoc);
		}
		return locs;
	}

	public String toString()
	{
		String s = "{";
		for (Location loc : getOccupiedLocations())
		{
			if (s.length() > 1)
				s += ", ";
			s += loc + "=" + get(loc);
		}
		return s + "}";
	}
	public ArrayList<Location> getAllEmptyLocations(){
		ArrayList<Location> theLocations = new ArrayList<Location>();
		for (int r = 0; r < getNumRows(); r++)
		{
			for (int c = 0; c < getNumCols(); c++)
			{
				Location loc = new Location(r, c);
				if (get(loc) == null)
					theLocations.add(loc);
			}
		}
		return theLocations;
	}

}
