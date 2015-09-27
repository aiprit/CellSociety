package grid;

import block.Location;

import java.util.ArrayList;
import java.util.List;

public interface Grid<E>
{
    int getNumRows();

    int getNumCols();

    boolean isValid(Location loc);

    E put(Location loc, E obj);

    E remove(Location loc);

    E get(Location loc);

    List<Location> getOccupiedLocations();

    List<Location> getValidAdjacentLocations(Location loc);

    List<Location> getEmptyAdjacentLocations(Location loc);

    List<Location> getOccupiedAdjacentLocations(Location loc);

    List<E> getNeighbors(Location loc);

	List<Location> getAllEmptyLocations();

	List<Location> getValidCompassLocations(Location location);
}
