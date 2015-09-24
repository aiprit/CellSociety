package block;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;

public class RedBlock extends Block {
	private static double happyPercentage;

	public static Color getStandardRedBlockColor() {
		return Color.RED;
	}

	public RedBlock(double percentage) {
		super();
		setColor(getStandardRedBlockColor());
		happyPercentage = percentage;
	}

	public void act() {
		boolean happy = happy();
		if (!happy) {
			tryMove();
		}
	}

	private boolean happy() {
		ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		boolean happy = false;
		int index = 0;
		double sameType = 0;
		while (index < neighbors.size()) {
			Block typeOfBlock = getGrid().get(neighbors.get(index));
			if (typeOfBlock instanceof RedBlock) {
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
	public char getChar() {
		return 'R';
	}
	public void tryMove() {
		ArrayList<Location> openSpots = getGrid().getAllEmptyLocations();
		if(openSpots.size() > 0){
			Collections.shuffle(openSpots);
			moveTo(openSpots.get(0));
		}
	}
}
