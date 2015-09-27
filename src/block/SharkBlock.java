package block;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class SharkBlock extends Block {
    private ResourceBundle myResources;
    private static int sharkBreedTime = 20;
    private static int sharkStarveTime=4;
    private Random rand = new Random();
    private int turnsSinceLastAte;
    private int turnsUntilCanBreed;
    private int myBreedTime;
    private int myStarveTime;


    public static void setBreedTime(int newBreedTime){
        sharkBreedTime = newBreedTime;
    }

    public static void setStarveTime(int newStarveTime){
        sharkStarveTime = newStarveTime;
    }

    public static int getStarveTime() {
        return sharkStarveTime;
    }

    public static int getBreedTime() {
        return sharkBreedTime;
    }

    @Override
    public Color getColor() {
        return (Color)myResources.getObject("SharkColor");
    }

    public SharkBlock(){
        super();
        turnsSinceLastAte = 0;
        turnsUntilCanBreed = sharkBreedTime;
        setColor(getColor());
        myBreedTime = sharkBreedTime + rand.nextInt(10);
        myStarveTime = sharkStarveTime + rand.nextInt(5);
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
            List<Location> openSpots = getGrid().getEmptyAdjacentLocations(getLocation());
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
            result = false;
        }
        return result;
    }

    private boolean ate(){
        List<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
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