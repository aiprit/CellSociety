package cellsociety_team10;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;

public class BurningBlock extends Block{
	private double probCatch; 

	public BurningBlock(double prob){
		super();
		probCatch = prob;
	}

	public void act(){
		Random r = new Random();
		ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		for(int i=0;i<neighbors.size();i++){
			Block burn = getGrid().get(neighbors.get(i));
			if(burn.getChar()=='T'){
				if(r.nextDouble()> probCatch)
					burn = new BurningBlock(probCatch);
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
