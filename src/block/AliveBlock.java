package block;

import grid.Grid;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

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
			Grid<Block> g_blocks = getGrid();
			removeSelfFromGrid();
			DeadBlock newDeadBlock = new DeadBlock();
			newDeadBlock.putSelfInGrid(g_blocks, loc);
		}
	}
	
	public boolean stayAlive() {
		List<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
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
