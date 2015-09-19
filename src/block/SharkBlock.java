package block;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SharkBlock extends Block {
    private static int sharkBreedTime = 20;
    private static int sharkStarveTime = 5;
    private static Random rand = new Random();
    private int turnsSinceLastAte;
    private int turnsUntilCanBreed;
    private int myBreedTime;
    private int myStarveTime;
    private Color blockColor = Color.ORANGE;

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
        return blockColor;
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
            result = false;
        }
        return result;
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