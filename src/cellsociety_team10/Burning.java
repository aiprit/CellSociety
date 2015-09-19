package cellsociety_team10;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;

public class Burning extends Block{
	private double probCatch; 
	
	public Burning(double prob){
		probCatch = prob;
	}
	
	 public void act(){
		 	Random r = new Random();
		 	ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		 	for(int i=0;i<neighbors.size();i++){
		 		Block burn = getGrid().get(neighbors.get(i));
		 		if(burn.getChar()=='T'){
		 			if(r.nextDouble()> probCatch)
		 			burn = new Burning(probCatch);
		 		}
		 	}
		 	 removeSelfFromGrid();
	    }
	 public char getChar(){
	        return 'B';
	    }
	 
	 @Override
	  public Color getColor() {
	        return Color.RED;
	    }
}
