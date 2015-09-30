package block;


import java.util.List;

import javafx.scene.paint.Color;

public class GroundBlock extends Block {
	protected double foodPheremones;
	protected double homePheremones;
	protected double maxPheremoneValue;
	protected double decreaseRate;
	protected double diffusionRate;

	public GroundBlock(double food, double home,double max, double decrease,double diffusion) {
		super();
		setColor(getColor());
		foodPheremones =  food;
		homePheremones = home;
		maxPheremoneValue = max;
		decreaseRate = decrease;
		diffusionRate = diffusion;
	}
	public double[] getStaticValues(){
		return new double[]{maxPheremoneValue,decreaseRate,diffusionRate};
	}

	public double getFoodPheremones() {
		return foodPheremones;
	}

	public double getHomePheremones() {
		return homePheremones;
	}

	public Color getColor() {
		return Color.BROWN;
	}

	public void addPheremones(double home, double food){
		homePheremones += home;
		foodPheremones += food;

	}

	public void diffuse(){
		List<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		for(Location loc: adjacentSpots){
			Block g = getGrid().get(loc);
			if(g instanceof GroundBlock){
				GroundBlock ground = (GroundBlock) g;
				ground.addPheremones(homePheremones*diffusionRate,foodPheremones*diffusionRate);

			}
		}
	}
	public void act() {
		diffuseanddecrease();
	}
	public void diffuseanddecrease(){
		diffuse();
		if (foodPheremones > 0) {
			foodPheremones *= decreaseRate;
		}
		if (homePheremones > 0) {
			homePheremones *= decreaseRate;
		}
	}
	public char getChar(){
		return 'G';
	}
}
