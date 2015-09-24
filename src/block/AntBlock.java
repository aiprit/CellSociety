package block;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.paint.Color;

public class AntBlock extends Block {
	private Color blockColor = Color.BLACK;
	private int numAnts = 0;
	private boolean hasFood = false;
	private int antLifeTime = 30;
	private int turnsSinceLastAte;
	private double foodPheremones;
	private double homePheremones;
	private double decreaseRate = 0.9;
	private double maxPheremoneValue = 100;

	public AntBlock(double food, double home) {
		super();
		setColor(getColor());
		foodPheremones = food;
		homePheremones = home;

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

	public int getNumAnts() {
		return numAnts;
	}

	public void resetNumAnts() {
		numAnts = 0;
	}

	public void act() {
		if (hasFood) {
			goToNest();
		}
		else {
			findFood();
		}
		if (foodPheremones > 0) {
			foodPheremones *= decreaseRate;
		}
		if (homePheremones > 0) {
			homePheremones *= decreaseRate;
		}
	}

	private void goToNest() {
		ArrayList<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
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
		moveTo(adjacentSpots.get(maxIndex));

	}

	private void findFood(){
		ArrayList<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		ArrayList<Double> ph;
		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block possibleAnt = getGrid().get(adjacentSpots.get(i));
			if (possibleAnt instanceof AntBlock || possibleAnt instanceof NestBlock) {
				adjacentSpots.remove(i);
			}
			else if ( possibleAnt instanceof FoodBlock){
				hasFood = true;
			}
		}
		ph = new ArrayList<Double>();
		for (int j = 0; j< adjacentSpots.size();j++) {
			 GroundBlock ground = (GroundBlock) getGrid().get(adjacentSpots.get(j));
			 ph.add(ground.getFoodPheremones());
		}
		double max = Collections.max(ph);
		int maxIndex = ph.indexOf(max);
		moveTo(adjacentSpots.get(maxIndex));

	}
	public void moveAnts(Location newLocation, boolean hasFood){
		if (grid == null)
			throw new IllegalStateException("This Block is not in a grid.");
		if (grid.get(location) != this)
			throw new IllegalStateException(
					"The grid contains a different Block at location "
							+ location + ".");
		if (!grid.isValid(newLocation))
			throw new IllegalArgumentException("Location " + newLocation
					+ " is not valid.");

		if (newLocation.equals(location))
			return;
		grid.remove(location);
		if(hasFood){
			grid.put(location, new GroundBlock(maxPheremoneValue,homePheremones));
		}
		else{
			grid.put(location, new GroundBlock(foodPheremones,maxPheremoneValue));

		}
		Block other = grid.get(newLocation);
		if (other != null)
			other.removeSelfFromGrid();
		location = newLocation;
		grid.put(location, this);
	}
}
