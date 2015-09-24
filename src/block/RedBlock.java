package block;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class RedBlock extends Block {
	private static double happyPercentage;
	private Color blockColor = Color.RED;

	@Override
	public Color getColor() {
		return blockColor;
	}

	public RedBlock(double percentage) {
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
}
