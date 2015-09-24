package block;

import java.util.ArrayList;
import java.util.Collections;

public class AgentBlock extends Block{
	private double sugarLvl;
	private double maxSugar;
	private double bloodSugar;
	private double vision;
	private double metabolism;

	public AgentBlock(double max, double meta, double vision){
		super();
		maxSugar = max;
	}
	@Override
	public void act() {

		if(burnSugar()){
			moveSugar();
		}
	}

	public boolean burnSugar(){
		bloodSugar -= metabolism;
		if( bloodSugar <0){
			removeSelfFromGrid();
			grid.put(location,new SugarBlock(sugarLvl,maxSugar));
			return false;
		}
		else{
			return true;
		}
	}

	public void moveAgent(Location newLocation){
		if (grid == null)
			throw new IllegalStateException("This Block is not in a grid.");
		if (grid.get(location) != this)
			throw new IllegalStateException(
					"The grid contains a different Block at location "
							+ location + ".");
		if (!grid.isValid(newLocation))
			throw new IllegalArgumentException("Location " + newLocation
					+ " is not valid.");

		if (newLocation.equals(location))
			return;
		grid.remove(location);

		grid.put(location, new SugarBlock(sugarLvl,maxSugar));

		Block other = grid.get(newLocation);
		if (other != null)
			other.removeSelfFromGrid();
		location = newLocation;
		grid.put(location, this);
	}



	public void moveSugar(){
		ArrayList<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		double max=0;
		Location loc=null;
		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block blocks = getGrid().get(adjacentSpots.get(i));
			if (blocks instanceof SugarBlock) {
				SugarBlock bl  =(SugarBlock) blocks;
				if(max < bl.getSugar()){
					max =  bl.getSugar();
					loc=adjacentSpots.get(i);
				}

			}
		}
		moveAgent(loc);
	}
}
