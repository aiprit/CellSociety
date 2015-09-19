package cellsociety_team10;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SharkBlock extends Block {
    private static int standardBreedTime = 20;
    private static int standardStarveTime = 5;
    private static int numSharks = 0;
    private static Random rand = new Random();
    private int turnsSinceLastAte;
    private int turnsUntilCanBreed;
    private int myBreedTime;
    private int myStarveTime;
  
    public static int getNumSharks(){
        return numSharks;
    }
    
    public static void resetNumSharks(){
        numSharks = 0;
    }
    
    public static void setBreedTime(int newBreedTime){
        standardBreedTime = newBreedTime;
    }
    
    public static void setStarveTime(int newStarveTime){
        standardStarveTime = newStarveTime;
    }
    
    public static int getStarveTime() {
        return standardStarveTime;
    }
   
    public static int getBreedTime() {
        return standardBreedTime;
    }
  
    public static Color getStandardSharkColor() {
        return Color.ORANGE;
    }
    
    public SharkBlock(){
        super();
        turnsSinceLastAte = 0;
        turnsUntilCanBreed = standardBreedTime;
        setColor(getStandardSharkColor());
        myBreedTime = standardBreedTime + rand.nextInt(10);
        myStarveTime = standardStarveTime + rand.nextInt(5);
        numSharks++;
    }
    
    public void act(){
        // update turns alive and turns since last ate
        turnsUntilCanBreed--;
        turnsSinceLastAte++;
        
        boolean stillAlive = iDidNotStarve();
        
        if( stillAlive && !ate() )  
            tryMove();
        if(stillAlive)
            attemptToBreed();
    }
    
    private void attemptToBreed(){
        if(turnsUntilCanBreed <= 0){
            ArrayList<Location> openSpots = getGrid().getEmptyAdjacentLocations(getLocation());
            if(openSpots.size() > 0){
                Collections.shuffle(openSpots);
                SharkBlock newShark = new SharkBlock();
                newShark.putSelfInGrid(getGrid(), openSpots.get(0));
                turnsUntilCanBreed = myBreedTime;
            }  
        }
    }
    
    private boolean iDidNotStarve(){
        boolean result = true;
        if(turnsSinceLastAte == myStarveTime){
            removeSelfFromGrid();
            numSharks--;
            result = false;
        }    
        return result;
    }
    
    private void tryMove(){
        ArrayList<Location> openSpots = getGrid().getEmptyAdjacentLocations(getLocation());
        if(openSpots.size() > 0){
            Collections.shuffle(openSpots);
            moveTo(openSpots.get(0)); 
        }
    }
            
    private boolean ate(){
        ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
        Collections.shuffle(neighbors);
        boolean eaten = false;
        int index = 0;
        while(!eaten && index < neighbors.size()){
            Block possibleFood = getGrid().get(neighbors.get(index));
            if( possibleFood instanceof FishBlock){
                eaten = true;
                turnsSinceLastAte = 0;
                possibleFood.removeSelfFromGrid();
            }
            index++;
        }
        return eaten;
    }
     
    public char getChar(){
        return 'S';
    }
}