package block;

import javafx.scene.paint.Color;
import java.util.ArrayList;

<<<<<<< HEAD
public class RedBlock extends Block {
	private static double happyPercentage;
	private Color blockColor = Color.RED;

	@Override
	public Color getColor() {
		return blockColor;
	}

	public RedBlock(double percentage) {
		super();
		setColor(getColor());
		happyPercentage = percentage;
	}
=======
public class RedBlock extends RedBlueBlock {


	@Override
	public Color getStandardBlockColor() {
		return Color.RED;
	}

	public RedBlock(double percentage) {
		super(percentage);
		setColor(getStandardBlockColor());
>>>>>>> robs_branch

	}



	@Override
	public boolean sameBlockCheck(Block typeOfBlock) {
		return typeOfBlock instanceof RedBlock;
	}


	@Override
	public char getChar() {
		return 'R';
	}
<<<<<<< HEAD
=======

>>>>>>> robs_branch
}
