package block;

import javafx.scene.paint.Color;

public class FishBlock extends Block {
	private static int fishBreedTime = 4;
	private int turnsUntilCanBreed;
	private Color blockColor = Color.GREEN;

	public static void setfishBreedTime(int newfishBreedTime){
		fishBreedTime = newfishBreedTime;
	}

	@Override
	public Color getColor() {
		return blockColor;
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

	public void removeSelfFromGrid(){
		super.removeSelfFromGrid();
	}

	public boolean isEdible(){
		return true;
	}
}

