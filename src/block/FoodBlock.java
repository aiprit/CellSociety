package block;

import javafx.scene.paint.Color;

public class FoodBlock extends Block{

	public FoodBlock(){
		super();
	}

	public Color getColor() {
		return Color.MAGENTA;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	}
	public char getChar(){
        return 'F';
    }
}
