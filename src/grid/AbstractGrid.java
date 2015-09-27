package grid;

import block.Location;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGrid<E> implements Grid<E>
{
	public abstract List<E> getNeighbors(Location loc);

	public abstract List<Location> getValidAdjacentLocations(Location loc);

	public abstract List<Location> getEmptyAdjacentLocations(Location loc);
	
	public abstract List<Location> getOccupiedAdjacentLocations(Location loc);
	

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
	public List<Location> getAllEmptyLocations(){
		List<Location> theLocations = new ArrayList<Location>();
		for (int r = 0; r < getNumRows(); r++)
		{
			for (int c = 0; c < getNumCols(); c++)
			{
				Location loc = new Location(r, c);
				if (get(loc) == null){
					theLocations.add(loc);
				}
			}
		}
		return theLocations;
	}

}
