package cellsociety_team10;

import javafx.scene.paint.Color;
public class Block
{
    private Grid<Block> grid;
    private Location location;
    private int direction;
    private Color color;

    public Block()
    {
        color = Color.BLUE;
        direction = Location.NORTH;
        grid = null;
        location = null;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color newColor)
    {
        color = newColor;
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
        grid = null;
        location = null;
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

    public void act()
    {
        setDirection(getDirection() + Location.HALF_CIRCLE);
    }

    public String toString()
    {
        return getClass().getName() + "[location=" + location + ",direction="
                + direction + ",color=" + color + "]";
    }
   
    public char getChar(){
        return '.';
    }
   
    public boolean isEdible(){
        return false;
    }
}