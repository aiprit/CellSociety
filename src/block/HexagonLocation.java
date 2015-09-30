package block;

import java.util.ResourceBundle;

public class HexagonLocation extends Location{

	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
	
	public HexagonLocation(int r, int c) {
		super(r, c);
	}
	
	@Override
	public Location getAdjacentLocation(int direction) {
		int adjustedDirection = (direction + Integer.parseInt(myResources.getString("HalfRight")) / 2)
				% Integer.parseInt(myResources.getString("FullCircle"));
        if (adjustedDirection < 0)
            adjustedDirection += Integer.parseInt(myResources.getString("FullCircle"));
        adjustedDirection = (adjustedDirection / Integer.parseInt(myResources.getString("HalfRight")) 
        		* Integer.parseInt(myResources.getString("HalfRight")));
        int dc = 0;
        int dr = 0;
        
        if (adjustedDirection == Integer.parseInt(myResources.getString("North"))) 
        	dr = -2;
        else if (adjustedDirection == Integer.parseInt(myResources.getString("NorthEast"))) {
        	dr = -1;
        	dc = 1;
        }
        else if (adjustedDirection == Integer.parseInt(myResources.getString("SouthEast"))) {
        	dr = 1;
        	dc = 1;
        }
        else if (adjustedDirection == Integer.parseInt(myResources.getString("South"))) 
        	dr = 2;
        else if (adjustedDirection == Integer.parseInt(myResources.getString("SouthWest"))) {
        	dr = 1;
        	dc = -1;
        }
        else if (adjustedDirection == Integer.parseInt(myResources.getString("NorthWest"))) {
        	dr = -1;
        	dc = -1;
        }
        
        return new Location(getRow() + dr, getCol() + dc);
	}

}
