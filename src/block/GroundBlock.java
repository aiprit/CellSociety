package block;


import java.util.List;

import javafx.scene.paint.Color;

public class GroundBlock extends Block {
	protected double foodPheremones = 0;
	protected double homePheremones = 0;
	protected double maxPheremoneValue = 100;
	protected double decreaseRate = 0.9;
	protected double diffusionRate = 0.01;
	private Color blockColor = Color.BROWN;

	public GroundBlock(double food, double home) {
		super();
		setColor(getColor());
		foodPheremones =  food;
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

	public void addPheremones(double home, double food){
			homePheremones += home;
			foodPheremones += food;

	}
	/*
	public void diffuse(){
		List<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		for(Location loc: adjacentSpots){
			GroundBlock ground = (GroundBlock) getGrid().get(loc);
			ground.addPheremones(homePheremones*diffusionRate,foodPheremones*diffusionRate);
		}
	}
	*/
	public void act() {
		//diffuse();
		if (foodPheremones > 0) {
			foodPheremones *= decreaseRate;
		}
		if (homePheremones > 0) {
			homePheremones *= decreaseRate;
		}
	}

}
