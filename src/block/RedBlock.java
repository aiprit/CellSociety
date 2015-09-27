package block;

import javafx.scene.paint.Color;
import java.util.ArrayList;


public class RedBlock extends RedBlueBlock {


	@Override
	public Color getStandardBlockColor() {
		return Color.RED;
	}

	public RedBlock(double percentage) {
		super(percentage);
		setColor(getStandardBlockColor());

	}



	@Override
	public boolean sameBlockCheck(Block typeOfBlock) {
		return typeOfBlock instanceof RedBlock;
	}


	@Override
	public char getChar() {
		return 'R';
	}

}
