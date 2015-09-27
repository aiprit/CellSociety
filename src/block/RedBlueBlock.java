package block;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rob on 9/24/15.
 */
abstract public class RedBlueBlock extends Block{
    protected static double happyPercentage;

    abstract public Color getStandardBlockColor();

    public RedBlueBlock(double percentage) {
        super();
        happyPercentage = percentage;
    }

    public void act() {
        boolean happy = happy();
        if (!happy) {
            tryMove();
        }
    }

    private boolean happy() {
        List<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
        boolean happy = false;
        int index = 0;
        double sameType = 0;
        while (index < neighbors.size()) {
            Block typeOfBlock = getGrid().get(neighbors.get(index));
            if (sameBlockCheck(typeOfBlock)) {
                sameType+=1;
            }
            index++;
        }
        double samePercentage;
        if (!(neighbors.size() == 0)) {
            samePercentage = sameType / neighbors.size();
            if (samePercentage >= happyPercentage ) {
                happy = true;
            }
        }
        return happy;
    }


    abstract public boolean sameBlockCheck(Block typeOfBlock);

    abstract public char getChar();

    public void tryMove() {
        List<Location> openSpots = getGrid().getAllEmptyLocations();
        if(openSpots.size() > 0){
            Collections.shuffle(openSpots);
            moveTo(openSpots.get(0));
        }
    }
}



