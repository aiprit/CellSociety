package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgentBlock extends SugarBlock{

	private double bloodSugar;
	private double vision;
	private double metabolism;

	public AgentBlock(double sugar, double sugarhi,double max, double meta, double vision){
		super(sugar);
		maxSugar = max;
	}
	@Override
	public void act() {

		//if(burnSugar()){
		//	moveSugar();
		//}
	}

//	public boolean burnSugar(){
//		bloodSugar -= metabolism;
//		if( bloodSugar <0){
//			removeSelfFromGrid();
//			grid.put(location,new SugarBlock(sugarLvl));
//			return false;
//		}
//		else{
//			return true;
//		}
//	}

//	public void moveAgent(Location newLocation){
//		moveTo(newLocation);
//		grid.put(location, new SugarBlock(sugarLvl));
//
//	}



	public void moveSugar(){
		/*	Location
			int loopnum = 1;
			while(loopnum<vision){
				north = 
			}
		}
		moveAgent(loc); */
	}
}
