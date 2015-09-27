package block;
import java.util.List;

public abstract class AliveDeadBlock extends Block{

	public AliveDeadBlock() {
		super();
	}

	public void act() {
		if (live(false)) {
			removeSelfFromGrid();
			AliveBlock newAliveBlock = new AliveBlock();
			newAliveBlock.putSelfInGrid(getGrid(), getLocation());
		}
		else if (!live(true)){
			removeSelfFromGrid();
			DeadBlock newDeadBlock = new DeadBlock();
			newDeadBlock.putSelfInGrid(getGrid(), getLocation());
		}
	}

	private boolean live(boolean alive) {
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
		if (alive) {
			if (numOfAlive == 2 || numOfAlive == 3) {
				stayAlive = true;
			}
		}
		else {
			if (numOfAlive == 3)
				stayAlive = true;
		}
		return stayAlive;
	}
}
