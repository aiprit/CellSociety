package cellsociety_team10;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.paint.Color;

public class FishBlock extends Block {
	private static int breedTime = 4;
    private static int numFish = 0;
    private int turnsUntilCanBreed;
   
    public static void setBreedTime(int newBreedTime){
        breedTime = newBreedTime;
    }
    
    public static int getNumFish(){
        return numFish;
    }
   
    public static void resetNumFish(){
        numFish = 0;
    }   
    
    public static Color getStandardFishColor() {
        return Color.GREEN;
    }
    
    public static int getBreedTime() {
        return breedTime;
    }
    
    public FishBlock(){
        super();
        setColor(getStandardFishColor());
        turnsUntilCanBreed = breedTime + (int) (Math.random() * 3);
        numFish++;
    }
    
    public void act(){
        turnsUntilCanBreed--;
        ArrayList<Location> openSpots = getGrid().getEmptyAdjacentLocations(getLocation());
        if(openSpots.size() > 0){
            Location oldLocation = getLocation();
            Collections.shuffle(openSpots);
            moveTo(openSpots.get(0));
            if(turnsUntilCanBreed <= 0){
                FishBlock newFish = new FishBlock();
                newFish.putSelfInGrid(getGrid(), oldLocation);
                turnsUntilCanBreed = breedTime;
            }
        }
    }
    
    public char getChar(){
        return 'F';
    }
    
    public void removeSelfFromGrid(){
        super.removeSelfFromGrid();
        numFish--;
    }
    
    public boolean isEdible(){
        return true;
    }
}

