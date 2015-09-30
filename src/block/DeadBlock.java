package block;

import javafx.scene.paint.Color;

public class DeadBlock extends AliveDeadBlock {
	
	public Color getStandardDeadBlockColor() {
		return Color.DARKSLATEGRAY;
	}

	public DeadBlock() {
		super();
		setColor(getStandardDeadBlockColor());
	}
	
	public char getChar() {
		return 'D';
	}
}
