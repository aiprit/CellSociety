package cellsociety_team10;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class BlueBlock extends Block {
	private static double happyPercentage;
	private Color blockColor = Color.BLUE;
	
	@Override
	public Color getColor() {
		return blockColor;
	}
	
	public BlueBlock(double percentage) {
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
		int sameType = 0;
		while (index < neighbors.size()) {
			Block typeOfBlock = getGrid().get(neighbors.get(index));
			if (typeOfBlock instanceof BlueBlock) {
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
		return 'B';
	}
}
