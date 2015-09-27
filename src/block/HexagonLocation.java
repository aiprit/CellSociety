package block;

public class HexagonLocation extends Location{

	public HexagonLocation(int r, int c) {
		super(r, c);
	}
	
	@Override
	public Location getAdjacentLocation(int direction) {
		int adjustedDirection = (direction + HALF_RIGHT / 2) % FULL_CIRCLE;
        if (adjustedDirection < 0)
            adjustedDirection += FULL_CIRCLE;
        adjustedDirection = (adjustedDirection / HALF_RIGHT) * HALF_RIGHT;
        int dc = 0;
        int dr = 0;
        
        if (adjustedDirection == NORTH) 
        	dr = -2;
        else if (adjustedDirection == NORTHEAST) {
        	dr = -1;
        	dc = 1;
        }
        else if (adjustedDirection == SOUTHEAST) {
        	dr = 1;
        	dc = 1;
        }
        else if (adjustedDirection == SOUTH) 
        	dr = 2;
        else if (adjustedDirection == SOUTHWEST) {
        	dr = 1;
        	dc = -1;
        }
        else if (adjustedDirection == NORTHWEST) {
        	dr = -1;
        	dc = -1;
        }
        
        return new Location(getRow() + dr, getCol() + dc);
	}

}
