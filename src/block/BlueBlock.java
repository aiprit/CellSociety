package block;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlueBlock extends RedBlueBlock {



	@Override
	public Color getStandardBlockColor() {
		return Color.BLUE;
	}

	public BlueBlock(double percentage) {
		super(percentage);
		setColor(getStandardBlockColor());
	}



	@Override
	public boolean sameBlockCheck(Block typeOfBlock) {
		return typeOfBlock instanceof BlueBlock;
	}

	public char getChar() {
		return 'B';
	}

	public void tryMove() {
				List<Location> openSpots = getGrid().getAllEmptyLocations();
				if(openSpots.size() > 0){
					Collections.shuffle(openSpots);
					moveTo(openSpots.get(0));
				}

}

}
