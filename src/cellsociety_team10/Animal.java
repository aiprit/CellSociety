package cellsociety_team10;


import javafx.scene.paint.Color;

public class Animal {
	private Grid<Animal> grid;
	private Location location;
	private int direction;
	private Color color;
	
	public Animal() {
		color = Color.BLUE;
		direction = Location.NORTH;
		grid = null;
		location = null;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int newDirection) {
		direction = newDirection % Location.FULL_CIRCLE;
		if (direction < 0) 
			direction+=Location.FULL_CIRCLE;
	}
	
	public Grid<Animal> getGrid() {
		return grid;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void putSelfInGrid(Grid<Animal> gr, Location loc) {
		if (grid != null)
			throw new IllegalStateException("This animal is already in a grid.");
		Animal animal = grid.get(loc);
		if (animal != null)
			animal.removeSelfFromGrid();
		gr.put(loc, this);
		grid = gr;
		location = loc;
	}
	
	public void removeSelfFromGrid() {
		if (grid == null) 
			throw new IllegalStateException("This actor is not in a grid");
		if (grid.get(location) != this)
			throw new IllegalStateException("The grid contains a different animal at location" + location);
		if (!grid.isValid(newLocation))
			throw new IllegalArgumentExpection("Location " + newLocation + " is not valid");
		if (newLocation.equals(location))
			return;
		grid.remove(location);
		Animal other = grid.get(newLocation);
		if (other != null)
			other.removeSelfFromGrid();
		location = newLocation;
		grid.put(location, this);
	}
	
	public void moveTo(Location newLocation) {
		if ((grid == null)
				throw new IllegalStateException("This actor is not in a grid.");
		if (grid.get(location) != this) 
			throw new IllegalStateException("The grid contains a different actor at location "
						+ location + ".");
		if (!grid.isValid(newLocation))
			throw new IllegalArgumentException("Location " + newLocation
	            		+ " is not valid.");
		if (newLocation.equals(location))
			return;
	    grid.remove(location);
	    Animal other = grid.get(newLocation);
	    if (other != null)
	    	other.removeSelfFromGrid();
	    location = newLocation;
	    grid.put(location, this);
		}

	   
	}
	
	public void act() {
		setDirection(getDirection() + Location.HALF_CIRCLE);
	}
	
	public String toString() {
		return getClass().getName() + "[location=" + location + ",direction=" + direction + ",color=" + color + "]";
	}
	
	public char getChar() {
		return '.';
	}
	
	public boolean isEdible() {
		return false;
	}
}
