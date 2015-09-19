package cellsociety_team10;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;

public class FireBlock extends Block{
	private double probCatch; 
	private Color blockColor = Color.RED;

	public FireBlock(double prob){
		super();
		probCatch = prob;
	}

	public void act(){
		Random r = new Random();
		ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
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
		return blockColor;
	}
}
