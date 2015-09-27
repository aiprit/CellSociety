package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.paint.Color;

public class NestBlock extends Block {

	private Color blockColor = Color.WHITE;

	public NestBlock(){
		super();
		setColor(getColor());

	}

	public Color getColor() {
		return blockColor;
	}

	public void act() {
		List<Location> neighbors = getGrid().getValidAdjacentLocations(getLocation());
		Collections.shuffle(neighbors);
		for (int i = 0; i < neighbors.size(); i++) {
			Block possibleAnt = getGrid().get(neighbors.get(i));
			if (possibleAnt instanceof AntBlock	|| possibleAnt instanceof FoodBlock ||
					possibleAnt instanceof NestBlock) {
				continue;
			}
			if (possibleAnt instanceof GroundBlock){
				GroundBlock ground = (GroundBlock) getGrid().get(neighbors.get(i));
				double homePh = ground.getHomePheremones();
				double foodPh = ground.getFoodPheremones();
				AntBlock ant = new AntBlock(foodPh, homePh);
				possibleAnt.removeSelfFromGrid();
				ant.putSelfInGrid(getGrid(),neighbors.get(i));
				break;
			}
		}

	}
	public char getChar(){
        return 'H';
    }
}
