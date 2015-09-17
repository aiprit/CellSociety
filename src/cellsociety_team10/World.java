package cellsociety_team10;


import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

public class World {
    
    
    private Grid<Animal> theWorld;
    private static Color oceanColor;
    
    static {
        oceanColor = new Color(50, 50, 255);
    }
    
    public static Color getOceanColor() {
        return oceanColor;
    }
    
    public World(int rows, int cols, double fractionFish, double fractionSharks){
        theWorld = new WrappedBoundedGrid<Animal>(rows, cols);
        reset(fractionFish, fractionSharks);
    }
    
    
    /**
     * Reset the world. All old fish and sharks are removed and
     * the world is repoluated with the given percentages of fish and sharks.
     * If fractionFish + fractionSharks > 1 the fractions are scaled down.
     * @param fractionFish The fraction of the world initially populated by Fish.
     * @param fractionSharks The fraction of the world initially populated by Sharks.
     */
    public void reset(double fractionFish, double fractionSharks){
        ArrayList<Location> occupiedCells = theWorld.getOccupiedLocations();
        for(Location loc : occupiedCells){
            theWorld.get(loc).removeSelfFromGrid();
        }
        Shark.resetNumSharks();
        Fish.resetNumFish();
        populateWorld(fractionFish, fractionSharks);
    }
    
    private void populateWorld(double fractionFish, double fractionSharks){
        double totalFractionCreatures = fractionFish + fractionSharks;
        if(totalFractionCreatures > 1) {
            // too many creatures. scale each
            fractionFish = fractionFish / totalFractionCreatures;
            fractionSharks= fractionSharks / totalFractionCreatures;
        }
        int numFish = (int) (fractionFish * getNumSpots());
        int numSharks = (int) (fractionSharks * getNumSpots());
        if(numFish + numSharks < getNumSpots() / 2)
            populateDefinite(numFish, numSharks);
        else
            populateIndefinite(numFish, numSharks);
    }

    private void populateIndefinite(int numFish, int numSharks) {
        ArrayList<Location> locs = new ArrayList<Location>();
        for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++)
            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++)
                locs.add(new Location(r, c));
        Collections.shuffle(locs);
        for(int i = 0; i < numFish; i++)
            new Fish().putSelfInGrid(theWorld, locs.get(i));
        for(int i = numFish, limit = numFish + numSharks; i < limit; i++)
            new Shark().putSelfInGrid(theWorld, locs.get(i));
    }

    private void populateDefinite(int numFish, int numSharks) {
        loopToPlace(numFish, true); 
        loopToPlace(numSharks, false);
    }
    
    private void loopToPlace(int num, boolean placeFish){
        int placed = 0;
        Random r = new Random();
        ArrayList<Location> locsUsed = new ArrayList<Location>();
        while(placed < num){
            int row = r.nextInt(theWorld.getNumRows());
            int col = r.nextInt(theWorld.getNumCols());
            Location loc = new Location(row, col);
            if(theWorld.get(loc) == null){
                placed++;
                Animal result = placeFish ? new Fish() : new Shark();
                result.putSelfInGrid(theWorld, loc);
                locsUsed.add(loc);
            }
        } 
    }
    
    /**
     * Perform one step of the simulation.
     */
    public void step(){
        ArrayList<Location> occupiedLocations = theWorld.getOccupiedLocations();
        Collections.shuffle(occupiedLocations);
        for(Location loc : occupiedLocations){
            Animal a = theWorld.get(loc);
            // in case eaten
            if(a != null)
                a.act();
        }
    }
    
    /**
     * Return the number of fish in the simulation.
     * @return The current number of fish in the simulation.
     */
    public int getNumFish(){
        return Fish.getNumFish();
    }

    /**
     * Return the number of sharks in the simulation.
     * @return The current number of sharks in the simulation.
     */
    public int getNumSharks(){
        return Shark.getNumSharks();
    }
    
    /**
     * Return the color of the Animal at the
     * specified cell.
     * row must be greater than or
     * equal to 0 and
     * less than numRows() and col must be greater 
     * than or equal to 0 and 
     * less than numCols().
     * @param row the row value
     * @param col the column value
     * @return The color of the cell in the simulation. open ocean (unoccupied cells) are blue.
     */
    public Color getColor(int row, int col){
        Animal a = theWorld.get(new Location(row, col));
        if(a == null)
            return oceanColor;
        else
            return a.getColor();
    }
    
    /**
     * Get the number of rows in this world.
     * @return the number of rows in this world.
     */
    public int getNumRows(){
        return theWorld.getNumRows();
    }

    /**
     * Get the number of columns in this world.
     * @return the number of columns in this world.
     */
    public int getNumCols(){
        return theWorld.getNumCols();
    }
    
    public String toString(){
        StringBuilder b = new StringBuilder();
        for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++){
            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++){
                Animal a = theWorld.get(new Location(r, c));
                if(a == null)
                    b.append('.');
                else
                    b.append( a.getChar() );
            }
            b.append('\n');
        }
        return b.toString();
    }
    
    /**
     * Get the total number of cells in this world.
     * @return The total number of cells in this world.
     */
    public int getNumSpots(){
        return theWorld.getNumRows() * theWorld.getNumCols();
    }
    
}
