package block;

import javafx.scene.paint.Color;

public class SugarBlock extends Block{

	private double sugarLvl;
	private double maxSugar;
	Color blockColor;
	public SugarBlock(double sugarl, double sugarhi){
		super();
		sugarLvl = sugarl;
		maxSugar = sugarhi;
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
