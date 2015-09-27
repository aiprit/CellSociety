package block;
import javafx.scene.paint.Color;

public class AliveBlock extends AliveDeadBlock {

	public static Color getStandardAliveBlockColor() {
		return Color.MEDIUMSLATEBLUE;
	}

	public AliveBlock() {
		super();
		setColor(getStandardAliveBlockColor());
	}

	public char getChar() {
		return 'A';
	}
}
