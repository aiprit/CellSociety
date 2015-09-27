package ui;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simulation.AbstractSimulation;

class GridPanel{


	private  static final int GridWidth = 550;
	private  static final int GridHeight =550;
	private Canvas Canvas;
	private Group Root = new Group();
	private GraphicsContext Background;
	private AbstractSimulation theWorld;
	private Scene myScene;
	private double cellWidth;
	private double cellHeight;
	private int sum1;
	private int sum2;
	private Color  col1;
	private Color  col2;
	private String shittyVariable;

	public GridPanel(AbstractSimulation sim){

		Canvas = new Canvas(GridWidth,GridHeight);
		Background = Canvas.getGraphicsContext2D();
		theWorld = sim;
		cellWidth = (double)GridWidth / theWorld.getNumCols();
		cellHeight = (double) GridHeight / theWorld.getNumRows();
		render();

	}


	public void update(){
		theWorld.step();
		resetcount();
		render();
	}

	private void render() {
		Background.setFill(Color.BLACK);
		if(shittyVariable== null || shittyVariable.equals("Rectangle")){
			Background.fillRect(0,0,GridWidth,GridHeight);
			rectangle();
		}
		else if(shittyVariable.equals("Triangle")){

			Background.fillRect(0,0,GridWidth,GridHeight);
			triangle();
		}
		else if(shittyVariable.equals("Hexagon")){
			Background.fillRect(0,0,GridWidth,GridHeight);
			hexagon();
		}


	}
	private void resetcount(){
		sum1 = 0;
		sum2 = 0;
	}
	private void countnumbers(Color c){
		if(col1 == c){
			sum1 +=1;
		}
		if(col2 == c){
			sum2 +=1;
		}

		if(col1 == null){
			col1 = c;
			sum1 = 1;
		}
		if(col2 == null && col1!=c){
			col2 = c;
			sum2 = 1;
		}



	}
	private void hexagon(){
		for(int r = 0; r < theWorld.getNumRows(); r++){
			for(int c = 0; c < theWorld.getNumCols(); c++){
				Color col = theWorld.getColor(r, c);
				if (r % 2 == 0) {
					fillhexagon(r,c,col);
				}
				else{
					fillhexagon(r,c,col);
				}
			}
		}
	}




	private void rectangle(){
		for(int r = 0; r < theWorld.getNumRows(); r++){
			for(int c = 0; c < theWorld.getNumCols(); c++){
				Color col = theWorld.getColor(r, c);
				if (col != theWorld.getEmptyColor()) {
					Background.setFill(col);
					countnumbers(col);
					Background.fillRect(r*cellHeight+cellHeight/2, c*cellWidth+cellWidth/2, cellWidth, cellHeight);
				}
				else {
					Background.setFill(theWorld.getEmptyColor());
					Background.fillRect(r*cellHeight+cellHeight/2, c*cellWidth+cellWidth/2, cellWidth, cellHeight);
				}
			}
		}
	}
	private void triangle(){
		for(int r = 0; r < theWorld.getNumRows(); r++){
			double a = 0;
			for(int c = 0; c < theWorld.getNumCols(); c++){
				Color col = theWorld.getColor(r, c);
				if (c % 2 == r%2){
					filltriangle(r,c,col,a);
				} else {
					filltriangle(r,c,col,a);
				}
				a+=0.5;
			}
		}

	}

	private void filltriangle(int r,int c,Color col,double a){
		int i = Math.abs(c%2 -r%2);
		if(col != theWorld.getEmptyColor()){
			Background.setFill(col);
			countnumbers(col);
			Background.fillPolygon(new double[] {(c-a+1)*cellWidth-cellWidth, (c-a+1)*cellWidth-cellWidth/2, (c-a+1)*cellWidth},
					new double[] {(r)*cellHeight-i*cellHeight, (r)*cellHeight-cellHeight+i*cellHeight, (r)*cellHeight-i*cellHeight}, 3);

		}
		else{
			Background.setFill(theWorld.getEmptyColor());;
			Background.fillPolygon(new double[] {(c-a+1)*cellWidth-cellWidth, (c-a+1)*cellWidth-cellWidth/2, (c-a+1)*cellWidth},
					new double[] {(r)*cellHeight-i*cellHeight, (r)*cellHeight-cellHeight+i*cellHeight, (r)*cellHeight-i*cellHeight}, 3);

		}
	}
	private void fillhexagon(int r,int c, Color col){
		int mod = r%2;
		if (col != theWorld.getEmptyColor()) {
			Background.setFill(col);
			countnumbers(col);
			Background.fillPolygon(
					new double[] {(r)*cellWidth*6/8, (r*cellWidth*6/8+cellWidth/4), ((r)*cellWidth*6/8+cellWidth*3/4)
							, (r*cellWidth*6/8+cellWidth), ((r)*cellWidth*6/8+cellWidth*3/4),(r*cellWidth*6/8+cellWidth/4)},
					new double[] {(c)*cellHeight+cellHeight/2+mod*cellHeight/2, (c)*cellHeight+mod*cellHeight/2, (c)*cellHeight+mod*cellHeight/2
							, (c)*cellHeight+cellHeight/2+mod*cellHeight/2,(c)*cellHeight+cellHeight+mod*cellHeight/2,(c)*cellHeight+cellHeight+mod*cellHeight/2}, 6);
		}
		else{
			Background.setFill(theWorld.getEmptyColor());
			Background.fillPolygon(
					new double[] {(r)*cellWidth*6/8, (r*cellWidth*6/8+cellWidth/4), ((r)*cellWidth*6/8+cellWidth*3/4)
							, (r*cellWidth*6/8+cellWidth), ((r)*cellWidth*6/8+cellWidth*3/4),(r*cellWidth*6/8+cellWidth/4)},
					new double[] {(c)*cellHeight+cellHeight/2+mod*cellHeight/2, (c)*cellHeight+mod*cellHeight/2, (c)*cellHeight+mod*cellHeight/2
							, (c)*cellHeight+cellHeight/2+mod*cellHeight/2,(c)*cellHeight+cellHeight+mod*cellHeight/2,(c)*cellHeight+cellHeight+mod*cellHeight/2}, 6);
		}
	}
	public Canvas getCanvas(){
		return Canvas;
	}

	public AbstractSimulation getWorld(){
		return theWorld;
	}
	public int getSum1(){
		return sum1;
	}
	public int getSum2(){
		return sum2;
	}
	public int getRows(){
		return theWorld.getNumRows();
	}
	public void setShapes(String str){
		shittyVariable = str;
		render();
	}

}