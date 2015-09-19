package cellsociety_team10;

import javafx.scene.paint.Color;

public class Flammable extends Block{
	public Flammable(){
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
