package block;

import javafx.scene.paint.Color;

public class GroundBlock extends Block {
	private double foodPheremones = 0;
	private double homePheremones = 0;
	private double maxPheremoneValue = 100;
	private double decreaseRate = 0.9;
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

	public void act() {
		if (foodPheremones > 0) {
			foodPheremones *= decreaseRate;
		}
		if (homePheremones > 0) {
			homePheremones *= decreaseRate;
		}
	}

}
