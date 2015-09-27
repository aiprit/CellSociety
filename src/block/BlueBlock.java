package block;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class BlueBlock extends RedBlueBlock {



	@Override
	public Color getStandardBlockColor() {
		return Color.BLUE;
	}

	public BlueBlock(double percentage) {
<<<<<<< HEAD
		super();
		setColor(getColor());
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
			if (typeOfBlock instanceof BlueBlock) {
				sameType+=1;
			}
			index++;
		}
		double samePercentage;
		if (!(neighbors.size() == 0)) {
			samePercentage =  sameType / neighbors.size();
			if (samePercentage >= happyPercentage ) {
				happy = true;
			}
		}
		return happy;
=======
		super(percentage);
		setColor(getStandardBlockColor());

	}

	@Override
	public boolean sameBlockCheck(Block typeOfBlock) {
		return typeOfBlock instanceof RedBlock;
>>>>>>> robs_branch
	}

	public char getChar() {
		return 'B';
	}
<<<<<<< HEAD
=======

>>>>>>> robs_branch
}
