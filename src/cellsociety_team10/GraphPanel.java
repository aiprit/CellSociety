package cellsociety_team10;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GraphPanel extends JPanel{

    // CS324e students: Add instance variables and constants
    // as appropriate.
    private final int HEIGHT = 150;
    
    private Image doubleBufferImage;
    private Rectangle2D.Double background;
    
    private ArrayList<Integer> numFish;
    private ArrayList<Integer> numSharks;
    private World theWorld;
    
    public  GraphPanel(World w){
        setBackground(Color.GRAY); // so we can see if render not correct
        Dimension dim = new Dimension(200, HEIGHT); // must change hard coded width
        setPreferredSize(dim);
        
        background = new Rectangle2D.Double(0, 0, 200, 300); // need to change hard coded values
        
        theWorld = w;
        numSharks = new ArrayList<Integer>();
        numFish = new ArrayList<Integer>();
        
        // CS324e students, you must complete this constructor
    }

    
    public void update(){
       
        // CS324e students, you must complete this method
    }
    
    private void render() {
        Graphics2D dbg;
        
        if(doubleBufferImage == null) {
            doubleBufferImage = createImage((int) background.width, (int) background.height);
        }
        dbg = (Graphics2D) doubleBufferImage.getGraphics();
        
        // background:
        dbg.setColor(Color.WHITE);
        dbg.fill(background);
        
        // CS324e students, you must complete this method
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(doubleBufferImage == null)
            render();
        g.drawImage(doubleBufferImage, 0, 0, null);
    }
    
    // CS324e students: Add methods here as necessary
}
