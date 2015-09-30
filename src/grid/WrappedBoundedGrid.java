package grid;

import block.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WrappedBoundedGrid<E> extends BoundedGrid<E> {
	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
    public WrappedBoundedGrid(int rows, int cols){
        super(rows, cols);
    }
    
    public List<Location> getValidAdjacentLocations(Location loc)
    {
        List<Location> locs = new ArrayList<Location>();
        int d = Integer.parseInt(myResources.getString("North"));
        for (int i = 0, limit = Integer.parseInt(myResources.getString("FullCircle")) 
        		/ Integer.parseInt(myResources.getString("HalfRight")); i < limit; i++) {
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
            d = d + Integer.parseInt(myResources.getString("HalfRight"));
        }
        return locs;
    }
}
