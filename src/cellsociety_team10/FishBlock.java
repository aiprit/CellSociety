package cellsociety_team10;

import javafx.scene.paint.Color;

public class FishBlock extends Block {
	private static int breedTime = 4;
	private int turnsUntilCanBreed;

	public static void setBreedTime(int newBreedTime){
		breedTime = newBreedTime;
	}

	public static Color getStandardFishColor() {
		return Color.GREEN;
	}

	public static int getBreedTime() {
		return breedTime;
	}

	public FishBlock(){
		super();
		setColor(getStandardFishColor());
		turnsUntilCanBreed = breedTime + (int) (Math.random() * 3);
	}

	public void act(){
		turnsUntilCanBreed--;
		Location oldLocation = getLocation();
		tryMove();
		if(turnsUntilCanBreed <= 0){
			FishBlock newFish = new FishBlock();
			newFish.putSelfInGrid(getGrid(), oldLocation);
			turnsUntilCanBreed = breedTime;
		}
	}


	public char getChar(){
		return 'F';
	}

	public void removeSelfFromGrid(){
		super.removeSelfFromGrid();
	}

	public boolean isEdible(){
		return true;
	}
}

