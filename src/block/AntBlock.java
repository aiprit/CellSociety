package block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import grid.Grid;
import javafx.scene.paint.Color;

public class AntBlock extends GroundBlock {
	private boolean hasFood = false;
	private double antLifeTime;
	private Location locate;
	private Location locate1;
	public AntBlock(double food, double home,double max,double decrease,double diffusion,double life) {
		super(food, home,max,decrease,diffusion);
		setColor(getColor());
		antLifeTime =life;
	}


	public Color getColor() {
		return Color.BLACK;
	}

	public void act() {
		if(antLifeTime>0){
			if (hasFood) {
				goToNest();
			}
			else {
				findFood();
			}

			diffuseanddecrease();
			antLifeTime--;
		}
		else{

			Location loc = getLocation();
			removeSelfFromGrid();
			GroundBlock g = new GroundBlock(foodPheremones,homePheremones,maxPheremoneValue,decreaseRate,diffusionRate);
			g.putSelfInGrid(getGrid(),loc);
			diffuseanddecrease();
		}
	}

	private void goToNest() {
		List<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block possibleAnt = getGrid().get(adjacentSpots.get(i));
			if (possibleAnt instanceof AntBlock	|| possibleAnt instanceof FoodBlock) {
				adjacentSpots.remove(i);
			}
			else if( possibleAnt instanceof NestBlock){
				hasFood = false;
				adjacentSpots.remove(i);
			}
		}
		thinkAction(adjacentSpots);
	}

	private void findFood(){
		List<Location> adjacentSpots = getGrid().getValidAdjacentLocations(getLocation());
		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block possibleAnt = getGrid().get(adjacentSpots.get(i));
			if (possibleAnt instanceof AntBlock || possibleAnt instanceof NestBlock) {
				adjacentSpots.remove(i);
			}
			else if ( possibleAnt instanceof FoodBlock){
				hasFood = true;
				adjacentSpots.remove(i);
			}
		}
		thinkAction(adjacentSpots);
	}
	private void thinkAction(List<Location> adjacentSpots){
		List<Double> ph;
		List<Integer> samemax =new ArrayList<Integer>();
		ph = new ArrayList<>();
		for (int j = 0; j< adjacentSpots.size();j++) {
			Block ground = getGrid().get(adjacentSpots.get(j));
			if(ground instanceof GroundBlock){
				GroundBlock ground1 = (GroundBlock) ground;

				ph.add(ground1.getFoodPheremones());
			}
		}
		if(ph.size() ==0)
			return;
		double max = Collections.max(ph);
		for(int l = 0; l < ph.size(); l++){
			if(max == ph.get(l))
				samemax.add(l);
		}
		Collections.shuffle(samemax);
		locate = adjacentSpots.get(samemax.get(0));
		locate1 = location;
		char a =getGrid().get(locate).getChar();
		if(a=='H'||a=='F'){
			return;
		}
		moveTo(locate);
		if(hasFood){
			GroundBlock g = new GroundBlock(foodPheremones,homePheremones,maxPheremoneValue,decreaseRate,diffusionRate);
			g.putSelfInGrid(getGrid(),locate1);
		}
		else{
			GroundBlock g = new GroundBlock(foodPheremones,homePheremones,maxPheremoneValue,decreaseRate,diffusionRate);
			g.putSelfInGrid(getGrid(),locate1);
		}
	}




	public char getChar(){
		return 'A';
	}
}
