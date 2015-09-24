// NEED TO FIX THE RADIAL MOVEMENT OF SIGNALS **************************


package block;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class SignalBlock extends Block {

	private Color blockColor = Color.WHITE;
	private double maxSignalStrength = 100;
	private double signalStrength = 0;
	private double decreaseRate = 0.9;
	private int direction = Location.NORTH;

	public SignalBlock(double signal, int dir) {
		super();
		setColor(getColor());
		signalStrength = signal;
		direction = dir;
	}

	public Color getColor() {
		return blockColor;
	}

	public double getSignalStrength() {
		return signalStrength;
	}


	public void act() {	
		Location loc = getLocation();
		moveSignals(loc);
	}

	private void moveSignals(Location loc) {
		SignalBlock signalSource = (SignalBlock) getGrid().get(location);
		int dir = signalSource.getDirection();
		Location newLocation = loc.getAdjacentLocation(dir);
		Block neighbor = getGrid().get(newLocation);
		if (neighbor instanceof SlimeBlock) {
			return;
		}
		else {
			moveTo(newLocation);
		}
	}
	
}
