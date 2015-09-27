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
	
	public abstract List<Location> getAllEmptyLocations();

}
