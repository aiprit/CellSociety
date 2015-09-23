package block;

import java.util.ArrayList;
import java.util.Collections;

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
		ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		Collections.shuffle(neighbors);
		for (int i = 0; i < neighbors.size(); i++) {
			Block possibleAnt = getGrid().get(neighbors.get(i));
			if (possibleAnt instanceof AntBlock	|| possibleAnt instanceof FoodBlock ||
					possibleAnt instanceof NestBlock) {
				continue;
			}
			else {
				GroundBlock ground = (GroundBlock) getGrid().get(neighbors.get(i));
				double homePh = ground.getHomePheremones();
				double foodPh = ground.getFoodPheremones();
				AntBlock ant = new AntBlock(foodPh, homePh);
				ant.moveAnts(neighbors.get(i), false);
				break;
			}
		}

	}
}
