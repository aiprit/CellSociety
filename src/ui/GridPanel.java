package ui;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import simulation.AbstractSimulation;

import javax.swing.*;

class GridPanel extends JPanel{


	private  static final int GridWidth = 600;
	private  static final int GridHeight = 600;
	private Canvas Canvas;
	private Group Root = new Group();
	private GraphicsContext Background;
	private AbstractSimulation theWorld;
	private Scene myScene;
	private double cellWidth;
	private double cellHeight;
	private int sides;


	public GridPanel(AbstractSimulation sim){

		Canvas = new Canvas(GridWidth,GridHeight);
		Background = Canvas.getGraphicsContext2D();
		theWorld = sim;
		myScene = new Scene(Root,GridWidth,GridHeight);
		cellWidth = (double)GridWidth / theWorld.getNumCols();
		cellHeight = (double) GridHeight / theWorld.getNumRows();
		render();
		Root.getChildren().add(Canvas);

	}

	/*public void reset(int rows, int cols, double fractstate1, double fractstate2, double prob){
        //theWorld = new SpreadingFireSim(rows, cols,fractstate1,fractstate2,0.5);
        render();
    }*/


	public void update(){
		theWorld.step();
		render();
	}

	private void render() {
		int a = 0;
		for(int r = 0; r < theWorld.getNumRows(); r++){
			for(int c = 0; c < theWorld.getNumCols(); c++){
				Color col = theWorld.getColor(r, c);
				if (col != theWorld.getEmptyColor()) {
					Background.setFill(col);
					Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
				}
				else {
					Background.setFill(theWorld.getEmptyColor());
					Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
				}
			}
		}
				
				
				/*
				if (r%2==0){    
					if(col != theWorld.getEmptyColor()){
						Background.setFill(col);
						Background.fillPolygon(new double[] {c*cellWidth-cellWidth, c*cellWidth-cellWidth/2, c*cellWidth}, 
								new double[] {(r-a)*cellHeight, (r-a)*cellHeight-cellHeight, (r-a)*cellHeight}, 3); //upright
								//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
					}
					else{
						Background.setFill(theWorld.getEmptyColor());;
						Background.fillPolygon(new double[] {c*cellWidth-cellWidth, c*cellWidth-cellWidth/2, c*cellWidth}, 
								new double[] {(r-a)*cellHeight, (r-a)*cellHeight-cellHeight, (r-a)*cellHeight}, 3);//upright
								//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
					}
				}
				else {
					if(col != theWorld.getEmptyColor()){
						Background.setFill(col);
						Background.fillPolygon(new double[] {(c-1)*cellWidth-cellWidth/2, (c-1)*cellWidth, (c-1)*cellWidth+cellWidth/2}, 
								new double[] {(r-1-a)*cellHeight-cellHeight, (r-1-a)*cellHeight, (r-1-a)*cellHeight-cellHeight}, 3);//inverted
								//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
					}
					else{
						Background.setFill(theWorld.getEmptyColor());;
						Background.fillPolygon(new double[] {(c-1)*cellWidth-cellWidth/2, (c-1)*cellWidth, (c-1)*cellWidth+cellWidth/2}, 
								new double[] {(r-1-a)*cellHeight-cellHeight, (r-1-a)*cellHeight, (r-1-a)*cellHeight-cellHeight}, 3);//inverted
								//Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
					}
				}
			}
			if (r%2==1)
				a++;
		}
	*/
		
		
		
	}

	public Canvas getCanvas(){
		return Canvas;
	}


	public Scene getScene(){
		return myScene;
	}

	public AbstractSimulation getWorld(){
		return theWorld;
	}

}