package block;

import javafx.scene.paint.Color;

public class TreeBlock extends Block {
	private Color blockColor = Color.GREEN;

	public TreeBlock(){
		super();
	}

	public char getChar(){
		return 'T';
	}
	
	@Override
	public Color getColor() {
		return blockColor;
	}

	public void act(){
		
	}
}
