package ui;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simulation.AbstractSimulation;

class GridPanel{


	private  static final int GridWidth = 600;
	private  static final int GridHeight = 600;
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

	public GridPanel(AbstractSimulation sim){

		Canvas = new Canvas(GridWidth,GridHeight);
		Background = Canvas.getGraphicsContext2D();
		theWorld = sim;
		cellWidth = (double)GridWidth / theWorld.getNumCols();
		cellHeight = (double) GridHeight / theWorld.getNumRows();
		render();

	}

	/*public void reset(int rows, int cols, double fractstate1, double fractstate2, double prob){
        //theWorld = new SpreadingFireSim(rows, cols,fractstate1,fractstate2,0.5);
        render();
    }*/


	public void update(){
		theWorld.step();
		resetcount();
		render();
	}

	private void render() {
		rectangle();
			//triangle();
		//hexagon();
<<<<<<< HEAD
		rectangle();
		//System.out.println(sum1);
		//System.out.println(sum2);
=======
		
>>>>>>> origin/master
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
						if (c%2==0){
							if (r % 2 == 0) {
								filltriangle(r,c,col,a);
							}
							else {
								fillflippedtriangle(r,c,col,a);
							}
						}
						else {
							if (r%2==0) {
								fillflippedtriangle(r,c,col,a);
							}
							else {
								filltriangle(r,c,col,a);
							}
						}
						a+=0.5;
					}
				}

			}

			private void filltriangle(int r,int c,Color col,double a){
				if(col != theWorld.getEmptyColor()){
					Background.setFill(col);
					countnumbers(col);
					Background.fillPolygon(new double[] {(c-a+1)*cellWidth-cellWidth, (c-a+1)*cellWidth-cellWidth/2, (c-a+1)*cellWidth},
							new double[] {(r)*cellHeight, (r)*cellHeight-cellHeight, (r)*cellHeight}, 3); //upright
					//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
				}
				else{
					Background.setFill(theWorld.getEmptyColor());;
					Background.fillPolygon(new double[] {(c-a+1)*cellWidth-cellWidth, (c-a+1)*cellWidth-cellWidth/2, (c-a+1)*cellWidth},
							new double[] {(r)*cellHeight, (r)*cellHeight-cellHeight, (r)*cellHeight}, 3);//upright
					//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
				}
			}

			private void fillflippedtriangle(int r,int c,Color col,double a){
				if(col != theWorld.getEmptyColor()){
					Background.setFill(col);
					countnumbers(col);
					Background.fillPolygon(new double[] {(c-a+1)*cellWidth-cellWidth, (c-a+1)*cellWidth-cellWidth/2, (c-a+1)*cellWidth},
							new double[] {(r)*cellHeight-cellHeight, (r)*cellHeight, (r)*cellHeight-cellHeight}, 3); //upright
					//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
				}
				else{
					Background.setFill(theWorld.getEmptyColor());;
					Background.fillPolygon(new double[] {(c-a+1)*cellWidth-cellWidth, (c-a+1)*cellWidth-cellWidth/2, (c-a+1)*cellWidth},
							new double[] {(r)*cellHeight-cellHeight, (r)*cellHeight, (r)*cellHeight-cellHeight}, 3);//upright
					//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
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
		}