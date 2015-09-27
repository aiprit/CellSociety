package block;

import java.util.ResourceBundle;

import javafx.scene.paint.Color;

public class TreeBlock extends Block {
	private ResourceBundle myResources;

	public TreeBlock(){
		super();
	}

	public char getChar(){
		return 'T';
	}
	
	@Override
	public Color getColor() {
		return (Color)myResources.getObject("TreeColor");
	}

	public void act(){
		
	}
}
