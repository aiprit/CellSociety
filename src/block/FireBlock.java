package block;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FireBlock extends Block {
	private double probCatch;

	public FireBlock(double prob){
		super();
		probCatch = prob;
	}

	public void act(){
		Random r = new Random();
		List<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		for(int i=0;i<neighbors.size();i++){
			Block burn = getGrid().get(neighbors.get(i));
			if(burn.getChar()=='T'){
				if(r.nextDouble()>= probCatch) {
					burn.removeSelfFromGrid();
					burn = new FireBlock(probCatch);
					burn.putSelfInGrid(getGrid(), neighbors.get(i));
				}
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
