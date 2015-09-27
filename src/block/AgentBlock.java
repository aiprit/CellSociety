package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgentBlock extends SugarBlock{

	private double bloodSugar;
	private double vision;
	private double metabolism;

	public AgentBlock(double sugar, double sugarhi,double max, double meta, double vision){
		super(sugar,sugarhi);
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
			SugarBlock sugar = new SugarBlock(sugarLvl,maxSugar);
			sugar.putSelfInGrid(getGrid(),getLocation());
			return false;
		}
		else{
			return true;
		}
	}

	public void moveAgent(Location newLocation){
		Location loc = getLocation();
		moveTo(newLocation);
		SugarBlock sug = new SugarBlock(sugarLvl,maxSugar);
		sug.putSelfInGrid(getGrid(),getLocation());

	}

	public void Checkvision(Location[] arr, double maxsugar, Location max){
		for(Location place:arr){
			Block block = getGrid().get(place);
			if(block instanceof SugarBlock){
				SugarBlock sugarblock = (SugarBlock) block;
				if(sugarblock.getSugar()>maxsugar){
					maxsugar = sugarblock.getSugar();
					max = sugarblock.getLocation();
				}
			}
		}
	}
		public void moveSugar(){
			List<Location> compass = getGrid().getValidCompassLocations(getLocation());
			int loopnum = 1;
			Location max = new Location(0,0);
			double maxsugar =0;
			Location[] arr = new Location[4];
			Checkvision(arr,maxsugar,max);
		while(loopnum<vision){
				arr[0] = arr[0].getAdjacentLocation(Location.NORTH);
				arr[1] = arr[1].getAdjacentLocation(Location.EAST);
				arr[2] = arr[2].getAdjacentLocation(Location.SOUTH);
				arr[3] = arr[3].getAdjacentLocation(Location.WEST);
				Checkvision(arr,maxsugar,max);
				loopnum++;
			}
		moveAgent(max);
		}

}
