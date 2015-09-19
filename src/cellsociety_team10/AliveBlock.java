package cellsociety_team10;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class AliveBlock extends Block {
	
	public static Color getStandardAliveBlockColor() {
		return Color.MEDIUMSLATEBLUE;
	}
	
	public AliveBlock() {
		super();
		setColor(getStandardAliveBlockColor());
	}
	
	public void act() {
		boolean stayAlive = stayAlive();
		Location loc = getLocation();
		if (!stayAlive) {
			removeSelfFromGrid();
			DeadBlock newDeadBlock = new DeadBlock();
			newDeadBlock.putSelfInGrid(getGrid(), loc);
		}
	}
	
	public boolean stayAlive() {
		ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		boolean stayAlive = false;
		int numOfAlive = 0;
		int index = 0;
		while (index < neighbors.size()) {
			Block typeOfBlock = getGrid().get(neighbors.get(index));
			if (typeOfBlock instanceof AliveBlock) {
				numOfAlive += 1;
			}
			index++;
		}
		if (numOfAlive == 2 || numOfAlive == 3) {
			stayAlive = true;
		}
		return stayAlive;
	}
	
	public char getChar() {
		return 'A';
	}
}
