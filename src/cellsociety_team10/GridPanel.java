package cellsociety_team10;



import javafx.scene.paint.Color;
import javafx.geometry.Dimension2D;
import java.awt.Graphics;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import java.awt.Image;

import javax.swing.JPanel;

class GridPanel extends JPanel{
<<<<<<< HEAD
    
    
	   
    public  int GridWidth = 400;
    public  int GridHeight = 400;
    private Canvas Canvas;
    private Group Root = new Group();
    private GraphicsContext Background;
    private AbstractSimulation theWorld;
    private Scene myScene;
    private double cellWidth;
    private double cellHeight;

    public GridPanel(int width, int height, AbstractSimulation sim){
        GridWidth = width;
        GridHeight = height;
        Canvas = new Canvas(GridWidth,GridHeight);
        Background = Canvas.getGraphicsContext2D();
        theWorld = sim;
        myScene = new Scene(Root,GridWidth,GridHeight);
        cellWidth = (double)GridWidth / theWorld.getNumCols();
        cellHeight = (double) GridHeight / theWorld.getNumRows();
        render();
    }

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
        for(int r = 0; r < theWorld.getNumRows(); r++){
            for(int c = 0; c < theWorld.getNumCols(); c++){
                Color col = theWorld.getColor(r, c);
                if(col != theWorld.getEmptyColor()){
                	Background.setFill(col);
                	Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
                }
                else{
                	Background.setFill(theWorld.getEmptyColor());;
                	Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
                }
            }
        }

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
=======



	public  int GridWidth = 600;
	public  int GridHeight = 600;
	private Canvas canvas;
	private Group Root = new Group();
	private GraphicsContext Background;
	private AbstractSimulation theWorld;
	private Scene myScene;
	private double cellWidth;
	private double cellHeight;
	

	public GridPanel(int rows, int cols,int width, int height,double fract1,double fract2, double prob){
		GridWidth = width;
		GridHeight = height;
		canvas = new Canvas(GridWidth,GridHeight);
		Background = canvas.getGraphicsContext2D();
		theWorld = new SpreadingFireSim(rows, cols,fract1,fract2,0.5);
		myScene = new Scene(Root,GridWidth,GridHeight);
		cellWidth = (double)GridWidth / theWorld.getNumCols();
		cellHeight = (double) GridHeight / theWorld.getNumRows();
		reset(rows,cols,fract1,fract2,prob);
		Root.getChildren().add(canvas);
		myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
	}

	public void reset(int rows, int cols, double fractstate1, double fractstate2, double prob){
		theWorld = new SpreadingFireSim(rows, cols,fractstate1,fractstate2,0.5);
		render();
	}
	
	public void handleKeyInput (KeyCode code) {
		switch (code) {
		case SPACE:
			update();
			break;
			default:
		}
	}

	public void update(){
		theWorld.step();
		render();
	}

	private void render() {    
 		Background.clearRect(GridWidth/2,GridHeight/2,GridWidth,GridHeight);
		for(int r = 0; r < theWorld.getNumRows(); r++){
			for(int c = 0; c < theWorld.getNumCols(); c++){
				Color col = theWorld.getColor(r, c);
				if(col != theWorld.getEmptyColor()){
					Background.setFill(col);
					Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
				}
				else{
					Background.setFill(theWorld.getEmptyColor());;
					Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
				}
			}
		}

	}


	public Scene getScene(){
		return myScene;
	}

	public AbstractSimulation getWorld(){
		return theWorld;
	}
>>>>>>> master
}