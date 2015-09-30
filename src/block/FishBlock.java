package block;

import javafx.scene.paint.Color;

public class FishBlock extends Block {
	private static int fishBreedTime;
	private int turnsUntilCanBreed;

	public static void setfishBreedTime(int newfishBreedTime){
		fishBreedTime = newfishBreedTime;
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}

	public static int getfishBreedTime() {
		return fishBreedTime;
	}

	public FishBlock(){
		super();
		setColor(getColor());
		turnsUntilCanBreed = fishBreedTime + (int) (Math.random() * 3);
	}

	public void act(){
		turnsUntilCanBreed--;
		Location oldLocation = getLocation();
		tryMove();
		if(turnsUntilCanBreed <= 0){
			FishBlock newFish = new FishBlock();
			newFish.putSelfInGrid(getGrid(), oldLocation);

			turnsUntilCanBreed = fishBreedTime;
		}
	}


	public char getChar(){
		return 'F';
	}

	public boolean isEdible(){
		return true;
	}
}

