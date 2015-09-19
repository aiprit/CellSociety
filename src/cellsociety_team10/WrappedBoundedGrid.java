package cellsociety_team10;

import java.util.ArrayList;

public class WrappedBoundedGrid<E> extends BoundedGrid<E> {
    public WrappedBoundedGrid(int rows, int cols){
        super(rows, cols);
    }
    
    public ArrayList<Location> getValidAdjacentLocations(Location loc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int d = Location.NORTH;
        for (int i = 0, limit = Location.FULL_CIRCLE / Location.HALF_RIGHT; i < limit; i++) {
            Location neighborLoc = loc.getAdjacentLocation(d);
            if (!isValid(neighborLoc)){
                // perform wrap around
                int row = neighborLoc.getRow();
                int adjustedRow = (row == - 1) ? getNumRows()- 1:
                    (row == getNumRows()) ? 0 : row;
                int col = neighborLoc.getCol();
                int adjustedCol= (col == - 1) ? getNumCols() - 1:
                    (col == getNumCols()) ? 0 : col; 
                neighborLoc = new Location(adjustedRow, adjustedCol);
                
            }
            locs.add(neighborLoc);
            d = d + Location.HALF_RIGHT;
        }
        return locs;
    }
}
