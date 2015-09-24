package block;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;

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
		return typeOfBlock instanceof RedBlock;
	}

	public char getChar() {
		return 'B';
	}

}
