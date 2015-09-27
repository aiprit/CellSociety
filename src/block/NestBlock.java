package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.paint.Color;

public class NestBlock extends Block {
	private double lifetime;
	private Color blockColor = Color.WHITE;

	public NestBlock(double life){
		super();
		setColor(getColor());
		lifetime = life;
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
				double[] list= ground.getStaticValues();
				AntBlock ant = new AntBlock(foodPh, homePh,list[0],list[1],list[1+1],lifetime);
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
