package cellsociety_team10;



import javafx.scene.paint.Color;
import javafx.geometry.Dimension2D;
import java.awt.Graphics;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import java.awt.Image;

import javax.swing.JPanel;

class GridPanel extends JPanel{
    
    
	   
    public  int GridWidth = 600;
    public  int GridHeight = 600;
    private Canvas Canvas;
    private Group Root = new Group();
    private GraphicsContext Background;
    private AbstractSimulation theWorld;
    private Scene myScene;
    private double cellWidth;
    private double cellHeight;

    public GridPanel(int rows, int cols,int width, int height,double fract1,double fract2, double prob){
        GridWidth = width;
        GridHeight = height;
        Canvas = new Canvas(GridWidth,GridHeight);
        Background = Canvas.getGraphicsContext2D();
        theWorld = new PredatorPreySim(rows, cols,fract1,fract2);
        myScene = new Scene(Root,GridWidth,GridHeight);
        cellWidth = (double)GridWidth / theWorld.getNumCols();
        cellHeight = (double) GridHeight / theWorld.getNumRows(); 
    }
    
    public void reset(int rows, int cols, double fractstate1, double fractstate2, double prob){
        theWorld = new PredatorPreySim(rows, cols,fractstate1,fractstate2);
        render();
    }
    
    
    public void update(){
        theWorld.step();
        render();
    }
    
    private void render() {    
        for(int r = 0; r < theWorld.getNumRows(); r++){
            for(int c = 0; c < theWorld.getNumCols(); c++){
                Color col = theWorld.getColor(r, c);
                if(col != theWorld.getEmptyColor()){
                	Background.setFill(col);;
                	Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
                }
                else{
                	Background.setFill(theWorld.getEmptyColor());;
                	Background.fillRect(r*cellHeight-cellHeight/2, c*cellWidth-cellWidth/2, cellWidth, cellHeight);
                }
            }
        }
        Root.getChildren().add(Canvas);
    }

  
    public Scene getScene(){
    	return myScene;
    }
    
    public AbstractSimulation getWorld(){
        return theWorld;
    }
}