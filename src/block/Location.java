package block;

import java.util.ResourceBundle;

public class Location implements Comparable<Location>
{
    private int row; 
    private int col;
    private ResourceBundle myResources;

    public Location(int r, int c)
    {
        row = r;
        col = c;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }
    
    public Location getAdjacentLocation(int direction)
    {
        int adjustedDirection = (direction + (int)myResources.getObject("HalfRight") / 2) %(int)myResources.getObject("FullCircle");
        if (adjustedDirection < 0)
            adjustedDirection += (int)myResources.getObject("FullCircle");
        adjustedDirection = (adjustedDirection / (int)myResources.getObject("HalfRight")) * (int)myResources.getObject("HalfRight");
        int dc = 0;
        int dr = 0;
        if (adjustedDirection == (int)myResources.getObject("East"))
            dc = 1;
        else if (adjustedDirection == (int)myResources.getObject("SouthEast"))
        {
            dc = 1;
            dr = 1;
        }
        else if (adjustedDirection == (int)myResources.getObject("South"))
            dr = 1;
        else if (adjustedDirection == (int)myResources.getObject("SouthWest"))
        {
            dc = -1;
            dr = 1;
        }
        else if (adjustedDirection == (int)myResources.getObject("West"))
            dc = -1;
        else if (adjustedDirection == (int)myResources.getObject("NorthWest"))
        {
            dc = -1;
            dr = -1;
        }
        else if (adjustedDirection == (int)myResources.getObject("North"))
            dr = -1;
        else if (adjustedDirection == (int)myResources.getObject("NorthEast"))
        {
            dc = 1;
            dr = -1;
        }
        return new Location(getRow() + dr, getCol() + dc);
    }

    public int getDirectionToward(Location target)
    {
        int dx = target.getCol() - getCol();
        int dy = target.getRow() - getRow();
        int angle = (int) Math.toDegrees(Math.atan2(-dy, dx));

        int compassAngle = (int)myResources.getObject("Right") - angle;
        compassAngle += (int)myResources.getObject("HalfRight") / 2;
        if (compassAngle < 0)
            compassAngle += (int)myResources.getObject("FullCircle");
        return (compassAngle / (int)myResources.getObject("HalfRight")) * (int)myResources.getObject("HalfRight");
    }

    public boolean equals(Object other)
    {
        if (!(other instanceof Location))
            return false;

        Location otherLoc = (Location) other;
        return getRow() == otherLoc.getRow() && getCol() == otherLoc.getCol();
    }

    public int hashCode()
    {
        return getRow() * 3737 + getCol();
    }

    public int compareTo(Location other)
    {
        Location otherLoc = (Location) other;
        if (getRow() < otherLoc.getRow())
            return -1;
        if (getRow() > otherLoc.getRow())
            return 1;
        if (getCol() < otherLoc.getCol())
            return -1;
        if (getCol() > otherLoc.getCol())
            return 1;
        return 0;
    }

    public String toString()
    {
        return "(" + getRow() + ", " + getCol() + ")";
    }
}
