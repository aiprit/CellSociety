package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import grid.Grid;
import javafx.scene.paint.Color;

public class AgentBlock extends SugarBlock{
	private Color blockColor = Color.RED;
	private double bloodSugar;
	private double vision;
	private double metabolism;
	private double sugarGrowth;
	private Location max;

	public AgentBlock(double sugar, double sugarhi,double growth,double blood, int meta, int vis){
		super(sugar,sugarhi,growth);
		bloodSugar = blood;
		metabolism = meta;
		vision = vis;
		sugarGrowth=growth;
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
			SugarBlock sugar = new SugarBlock(sugarLvl,maxSugar,sugarGrowth);
			sugar.putSelfInGrid(getGrid(),getLocation());
			return false;
		}
		else{
			return true;
		}
	}

	public void moveAgent(Location newLocation){
		Location loc = getLocation();
		SugarBlock sugar= (SugarBlock) getGrid().get(newLocation);
		bloodSugar +=sugar.getSugar();
		moveTo(newLocation);
		SugarBlock sug = new SugarBlock(sugarLvl,maxSugar,sugarGrowth);
		sug.putSelfInGrid(getGrid(),loc);

	}

	public void Checkvision(List<Location> lst,Location[] arr, double maxsugar){
		for(Location place:lst){
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
		max = new Location(0,0);
		double maxsugar =0;
		Location[] arr = new Location[4];
		int[] dir = new int[]{Location.NORTH,Location.EAST,Location.SOUTH,Location.WEST};
		for(int i=0;i<compass.size();i++){
			arr[i]=compass.get(i);
		}
		Checkvision(compass,arr,maxsugar);
		while(loopnum<vision){
			for(int j=0;j<dir.length;j++){
				if(arr[j]!=null){
					if(getGrid().isValid(arr[j].getAdjacentLocation(dir[j])))
						arr[j] = arr[j].getAdjacentLocation(dir[j]);
				}
			}
			Checkvision(compass,arr,maxsugar);
			loopnum++;
		}
		moveAgent(max);
		max = null;
	}

	public Color getColor(){
		return blockColor;
	}
}
