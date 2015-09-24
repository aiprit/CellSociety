package block;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.paint.Color;

public class SlimeBlock extends Block {

	private Color blockColor = Color.GREEN;
	private int numSlimes = 0;
	private double threshold = 0.3;
	private double maxSignalStrength = 100;

	public SlimeBlock() {
		super();
		setColor(getColor());
	}

	public Color getColor() {
		return blockColor;
	}

	public int getNumSlimes() {
		return numSlimes;
	}

	public void resetNumSlimes() {
		numSlimes = 0;
	}

	public void act() {
		goToSignal(threshold);
		sendSignals();
	}

	private void sendSignals() {
		ArrayList<Location> adjacentSpots = getGrid().getEmptyAdjacentLocations(getLocation());
		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block signal = (SignalBlock) getGrid().get(adjacentSpots.get(i));
			int dir = signal.getDirection();
			signal = new SignalBlock(maxSignalStrength, dir);
			signal.putSelfInGrid(getGrid(), adjacentSpots.get(i));
		}
	}

	private void goToSignal(double threshold) {
		ArrayList<Location> adjacentSpots = getGrid().getOccupiedAdjacentLocations(getLocation());
		ArrayList<Double> signals = new ArrayList<Double>();
		for (int i = 0; i < adjacentSpots.size(); i++) {
			Block signal = getGrid().get(adjacentSpots.get(i));
			if (signal instanceof SlimeBlock) {
				adjacentSpots.remove(i);
			}
		}
		for (int j = 0; j< adjacentSpots.size();j++) {
			SignalBlock strength = (SignalBlock) getGrid().get(adjacentSpots.get(j));
			signals.add(strength.getSignalStrength());
		}
		double max = Collections.max(signals);
		if (max >= threshold) {
			int maxIndex = signals.indexOf(max);
			moveTo(adjacentSpots.get(maxIndex));
		}
		else {
			tryMove();
		}
	}
}
