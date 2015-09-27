package block;

import javafx.scene.paint.Color;

public class SugarBlock extends Block{
	protected double sugarLvl;
	protected double maxSugar;
	Color blockColor;
	public SugarBlock(double sugarl,double max){
		super();
		sugarLvl = sugarl;
		maxSugar = max;

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
