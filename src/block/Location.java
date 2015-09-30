package block;

import java.util.ResourceBundle;

public class Location implements Comparable<Location>
{
	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
	private int row; 
    private int col;

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
        int adjustedDirection = (direction + Integer.parseInt(myResources.getString("HalfRight")) / 2) 
        		% Integer.parseInt(myResources.getString("FullCircle"));
        if (adjustedDirection < 0)
            adjustedDirection += Integer.parseInt(myResources.getString("FullCircle"));
        adjustedDirection = (adjustedDirection / Integer.parseInt(myResources.getString("HalfRight"))
        		* Integer.parseInt(myResources.getString("HalfRight")));
        int dc = 0;
        int dr = 0;
        if (adjustedDirection == Integer.parseInt(myResources.getString("East")))
            dc = 1;
        else if (adjustedDirection == Integer.parseInt(myResources.getString("SouthEast")))
        {
            dc = 1;
            dr = 1;
        }
        else if (adjustedDirection == Integer.parseInt(myResources.getString("South")))
            dr = 1;
        else if (adjustedDirection == Integer.parseInt(myResources.getString("SouthWest")))
        {
            dc = -1;
            dr = 1;
        }
        else if (adjustedDirection == Integer.parseInt(myResources.getString("West")))
            dc = -1;
        else if (adjustedDirection == Integer.parseInt(myResources.getString("NorthWest")))
        {
            dc = -1;
            dr = -1;
        }
        else if (adjustedDirection == Integer.parseInt(myResources.getString("North")))
            dr = -1;
        else if (adjustedDirection == Integer.parseInt(myResources.getString("NorthEast")))
        	
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

        int compassAngle = Integer.parseInt(myResources.getString("Right")) - angle;
        compassAngle += Integer.parseInt(myResources.getString("HalfRight")) / 2;
        if (compassAngle < 0)
            compassAngle += Integer.parseInt(myResources.getString("FullCircle"));
        return (compassAngle / Integer.parseInt(myResources.getString("HalfRight"))) 
        		* Integer.parseInt(myResources.getString("HalfRight"));
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
