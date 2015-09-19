package cellsociety_team10;

import javafx.scene.paint.Color;

public class FlammableBlock extends Block{
	public FlammableBlock(){
		super();
	}
	 public char getChar(){
	        return 'T';
	    }
	 @Override
	  public Color getColor() {
	        return Color.GREEN;
	    }
}
