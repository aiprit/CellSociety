package simulation;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import block.Block;

import block.FoodBlock;
import block.GroundBlock;
import block.Location;
import block.NestBlock;

import javafx.scene.paint.Color;
import parameter.Parameters;

public class ForagingAntsSim extends AbstractSimulation{

    private ResourceBundle myResources;
	private double max;
	private double diffusion;
	private double decrease;
	public ForagingAntsSim(Parameters parameter) {
		super(parameter);
		reset( parameter.get_param_map().get("ant_life"),1);
		max = parameter.get_param_map().get("max_pheremones");
		diffusion = parameter.get_param_map().get("diffusion_rate");
		decrease = parameter.get_param_map().get("decrease_rate");
	}

	@Override
	public void populateWorld(double life, double fraction2) {
		Random r = new Random();
		int row1 = r.nextInt(getNumRows());
		int col1 = r.nextInt(getNumCols());
		int row2 = r.nextInt(getNumRows());
		int col2 = r.nextInt(getNumCols());

		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumCols(); j++) {
				if (i==row1 && j == col1) {
					new NestBlock(life).putSelfInGrid(theWorld, new Location(i,j));
				}
				else if (i == row2 && j == col2) {
					new FoodBlock().putSelfInGrid(theWorld, new Location(i,j));
				}
				else {
					new GroundBlock(0,0,max,decrease,diffusion).putSelfInGrid(theWorld, new Location(i,j));
				}
			}
		}
	}

	public Color getEmptyColor() {
		return (Color)myResources.getObject("EmptyAntColor");
	}

	@Override
	public Block chooseBlock(boolean placeBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void step() {
		List<Location> occupiedLocations = theWorld.getOccupiedLocations();
		Collections.shuffle(occupiedLocations);
		ArrayList<Location> list = new ArrayList<Location>();
		for(Location loc : occupiedLocations){
			Block a = theWorld.get(loc);
			// in case eaten
			if(a.getChar() == 'A'||a.getChar() == 'H')
				list.add(loc);

		}
		for (Location loca: list) {
			Block a = theWorld.get(loca);
			a.act();
		}
		occupiedLocations = theWorld.getOccupiedLocations();
		list = new ArrayList<Location>();
		for(Location loc : occupiedLocations){
			Block a = theWorld.get(loc);
			if(a.getChar() == 'G'){
				list.add(loc);
			}
		}
		for (Location loca: list) {
			Block a = theWorld.get(loca);
			a.act();
		}
	}
	@Override
	public void populateDefinite(int num1, int num2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void populateIndefinite(int num1, int num2) {
		// TODO Auto-generated method stub

	}

}
