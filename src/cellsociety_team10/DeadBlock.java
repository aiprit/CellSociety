package cellsociety_team10;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class DeadBlock extends Block {
	
	public static Color getStandardDeadBlockColor() {
		return Color.DARKSLATEGRAY;
	}
	
	public DeadBlock() {
		super();
		setColor(getStandardDeadBlockColor());
	}
	
	public void act() {
		boolean becomeAlive = becomeAlive();
		Location loc = getLocation();
		if (becomeAlive) {
			removeSelfFromGrid();
			AliveBlock newAliveBlock = new AliveBlock();
			newAliveBlock.putSelfInGrid(getGrid(), loc);
		}
	}
	
	public boolean becomeAlive() {
		ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		boolean becomeAlive = false;
		int numOfAlive = 0;
		int index = 0;
		while (index < neighbors.size()) {
			Block typeOfBlock = getGrid().get(neighbors.get(index));
			if (typeOfBlock instanceof AliveBlock) {
				numOfAlive +=1;
			}
			index++;
		}
		if (numOfAlive == 3) {
			becomeAlive = true;
		}
		return becomeAlive;
	}
	
	public char getChar() {
		return 'D';
	}
}
