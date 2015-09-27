package block;

import grid.Grid;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Block
{
	protected Grid<Block> grid;
	protected Location location;
	private int direction;
	private Color blockColor;

	public Block()
	{
		direction = Location.NORTH;
		grid = null;
		location = null;
	}

	public Color getColor() {
		return blockColor;
	}

	public void setColor(Color newColor)
	{
		blockColor = newColor;
	}

	public int getDirection()
	{
		return direction;
	}

	public void setDirection(int newDirection)
	{
		direction = newDirection % Location.FULL_CIRCLE;
		if (direction < 0)
			direction += Location.FULL_CIRCLE;
	}

	public Grid<Block> getGrid()
	{
		return grid;
	}

	public Location getLocation()
	{
		return location;
	}

	public void putSelfInGrid(Grid<Block> gr, Location loc)
	{
		if (grid != null)
			throw new IllegalStateException(
					"This Block is already contained in a grid.");

		Block block = gr.get(loc);
		if (block != null)
			block.removeSelfFromGrid();
		gr.put(loc, this);
		grid = gr;
		location = loc;
	}

	public void removeSelfFromGrid()
	{
		if (grid == null)
			throw new IllegalStateException(
					"This Block is not contained in a grid.");
		if (grid.get(location) != this)
			throw new IllegalStateException(
					"The grid contains a different Block at location "
							+ location + ".");
		grid.remove(location);
	}

	public void moveTo(Location newLocation)
	{
		if (grid == null)
			throw new IllegalStateException("This Block is not in a grid.");
		if (grid.get(location) != this)
			throw new IllegalStateException(
					"The grid contains a different Block at location "
							+ location + ".");
		if (!grid.isValid(newLocation))
			throw new IllegalArgumentException("Location " + newLocation
					+ " is not valid.");

		if (newLocation.equals(location))
			return;
		grid.remove(location);
		Block other = grid.get(newLocation);
		if (other != null)
			other.removeSelfFromGrid();
		location = newLocation;
		grid.put(location, this);
	}

	abstract public void act();

	public String toString()
	{
		return getClass().getName() + "[location=" + location + ",direction="
				+ direction + ",color=" + blockColor + "]";
	}

	public char getChar(){
		return '.';
	}

	public void tryMove() {
		List<Location> openSpots = getGrid().getEmptyAdjacentLocations(getLocation());
		if(openSpots.size() > 0){
			Collections.shuffle(openSpots);
			moveTo(openSpots.get(0));
		}
	}
}