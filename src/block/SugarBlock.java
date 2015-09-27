package block;

import javafx.scene.paint.Color;

public class SugarBlock extends Block{
	protected double sugarLvl;
	protected double maxSugar =4;
	Color blockColor;
	public SugarBlock(double sugarl){
		super();
		sugarLvl = sugarl;

	}
	public Color getColor() {
		if(sugarLvl >= maxSugar*2/3){
			blockColor = Color.DARKORANGE;
		}
		if(sugarLvl <= maxSugar*2/3 && sugarLvl >= maxSugar/3){
			blockColor=  Color.ORANGE;
		}
		if(sugarLvl>0 && sugarLvl < maxSugar/3){
			blockColor = Color.MOCCASIN;
		}
		if(sugarLvl==0)
			blockColor = Color.WHITE;
			return blockColor;
	}
	@Override
	public void act() {

	}
	public double getSugar(){
		return sugarLvl;
	}
}
