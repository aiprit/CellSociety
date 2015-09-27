package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.paint.Color;

public class AntBlock extends GroundBlock {
	private Color blockColor = Color.BLACK;
	private boolean hasFood = false;
	private int antLifeTime = 30;

	public AntBlock(double food, double home) {
		super(food, home);
		setColor(getColor());


	}

	public double getFoodPheremones() {
		return foodPheremones;
	}

	public double getHomePheremones() {
		return homePheremones;
	}

	public Color getColor() {
		return blockColor;
	}

	public void act() {
		if(antLifeTime>0){
			if (hasFood) {
				goToNest();
			}
			else {
				findFood();
			}
			diffuse();
			if (foodPheremones > 0) {
				foodPheremones *= decreaseRate;
			}
			if (homePheremones > 0) {
				homePheremones *= decreaseRate;
			}
			antLifeTime--;
		}
		removeSelfFromGrid();
	}

	private void goToNest() {
		List<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		ArrayList<Double> ph = new ArrayList<Double>();
		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block possibleAnt = getGrid().get(adjacentSpots.get(i));
			if (possibleAnt instanceof AntBlock	|| possibleAnt instanceof FoodBlock) {
				adjacentSpots.remove(i);
			}
			else if( possibleAnt instanceof NestBlock){
				hasFood = false;
			}
		}
		for (int j = 0; j< adjacentSpots.size();j++) {
			GroundBlock ground = (GroundBlock) getGrid().get(adjacentSpots.get(j));
			ph.add(ground.getHomePheremones());
		}
		double max = Collections.max(ph);
		int maxIndex = ph.indexOf(max);
		moveAnts(adjacentSpots.get(maxIndex));

	}

	private void findFood(){

		List<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		List<Double> ph;

		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block possibleAnt = getGrid().get(adjacentSpots.get(i));
			if (possibleAnt instanceof AntBlock || possibleAnt instanceof NestBlock) {
				adjacentSpots.remove(i);
			}
			else if ( possibleAnt instanceof FoodBlock){
				hasFood = true;
			}
		}
		ph = new ArrayList<>();
		for (int j = 0; j< adjacentSpots.size();j++) {
			GroundBlock ground = (GroundBlock) getGrid().get(adjacentSpots.get(j));
			ph.add(ground.getFoodPheremones());
		}
		double max = Collections.max(ph);
		int maxIndex = ph.indexOf(max);
		moveAnts(adjacentSpots.get(maxIndex));

	}
	public void moveAnts(Location newLocation){
		moveTo(newLocation);
		if(hasFood){
			grid.put(location, new GroundBlock(maxPheremoneValue,homePheremones));
		}
		else{
			grid.put(location, new GroundBlock(foodPheremones,maxPheremoneValue));

		}

	}
}
