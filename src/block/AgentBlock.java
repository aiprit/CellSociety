package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import grid.Grid;
import javafx.scene.paint.Color;

public class AgentBlock extends SugarBlock{
	private ResourceBundle myResources;
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
			for(int i=0;i<compass.size();i++){
				arr[i]=compass.get(i);
			}
			Checkvision(compass,arr,maxsugar);
		while(loopnum<vision){
			if(arr[0]!=null){
			if(getGrid().isValid(arr[0].getAdjacentLocation((int)myResources.getObject("North"))))
				arr[0] = arr[0].getAdjacentLocation((int)myResources.getObject("North"));}
			if(arr[1]!=null){
			if(getGrid().isValid(arr[1].getAdjacentLocation((int)myResources.getObject("East"))))
				arr[1] = arr[1].getAdjacentLocation((int)myResources.getObject("East"));}
			if(arr[2]!=null){
			if(getGrid().isValid(arr[2].getAdjacentLocation((int)myResources.getObject("South"))))
				arr[2] = arr[2].getAdjacentLocation((int)myResources.getObject("South"));
			}
			if(arr[3]!=null){
			if(getGrid().isValid(arr[3].getAdjacentLocation((int)myResources.getObject("West")))){
				arr[3] = arr[3].getAdjacentLocation((int)myResources.getObject("West"));
			}}
				Checkvision(compass,arr,maxsugar);
				loopnum++;
			}
		moveAgent(max);
		max = null;
		}

	public Color getColor(){
		return (Color)myResources.getObject("AgentColor");
	}
}
