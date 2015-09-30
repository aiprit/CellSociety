package grid;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import block.HexagonLocation;

public abstract class HexGrid<E> implements Grid<E>{
	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
	public List<E> getNeighbors(HexagonLocation loc) {
		List<E> neighbors = new ArrayList<E>();
		for (HexagonLocation neighborLoc : getOccupiedAdjacentLocations(loc))
			neighbors.add(get(neighborLoc));
		return neighbors;
	}
	
	public List<HexagonLocation> getValidAdjacentLocations(HexagonLocation loc)
	{
		List<HexagonLocation> locs = new ArrayList<HexagonLocation>();
		int d = Integer.parseInt(myResources.getString("North"));
		for (int i = 0; i < Integer.parseInt(myResources.getString("FullCircle")) 
			/ Integer.parseInt(myResources.getString("HalfRight")); i++)
		{
			HexagonLocation neighborLoc = (HexagonLocation) loc.getAdjacentLocation(d);
			if (isValid(neighborLoc))
				locs.add(neighborLoc);
			d = d + Integer.parseInt(myResources.getString("HalfRight"));
		}
		return locs;
	}

	public List<HexagonLocation> getEmptyAdjacentLocations(HexagonLocation loc)
	{
		List<HexagonLocation> locs = new ArrayList<HexagonLocation>();
		for (HexagonLocation neighborLoc : getValidAdjacentLocations(loc))
		{
			if (get(neighborLoc) == null)
				locs.add(neighborLoc);
		}
		return locs;
	}

	public List<HexagonLocation> getOccupiedAdjacentLocations(HexagonLocation loc)
	{
		List<HexagonLocation> locs = new ArrayList<HexagonLocation>();
		for (HexagonLocation neighborLoc : getValidAdjacentLocations(loc))
		{
			if (get(neighborLoc) != null)
				locs.add(neighborLoc);
		}
		return locs;
	}
	
	public List<HexagonLocation> getAllEmptyHexagonLocations(){
		List<HexagonLocation> theLocations = new ArrayList<HexagonLocation>();
		for (int r = 0; r < getNumRows(); r++)
		{
			for (int c = 0; c < getNumCols(); c++)
			{
				HexagonLocation loc = new HexagonLocation(r, c);
				if (get(loc) == null)
					theLocations.add(loc);
			}
		}
		return theLocations;
	}

}
