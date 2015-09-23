package block;

import javafx.scene.paint.Color;

public class FoodBlock extends Block{

	private Color blockColor = Color.MAGENTA;
	public FoodBlock(){
		super();
	}

	public Color getColor() {
		return blockColor;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}
}
