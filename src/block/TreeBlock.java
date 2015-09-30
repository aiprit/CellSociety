package block;

import javafx.scene.paint.Color;

public class TreeBlock extends Block {

	public TreeBlock(){
		super();
	}

	public char getChar(){
		return 'T';
	}
	
	@Override
	public Color getColor() {
		return Color.GREEN;
	}

	public void act(){
		
	}
}
