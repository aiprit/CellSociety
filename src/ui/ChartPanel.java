package ui;



import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Rob on 9/26/15.
 */


public class ChartPanel {
	private ResourceBundle myResources = ResourceBundle.getBundle("resources/english");
    private Canvas Canvas;
    private GraphicsContext Background;
    private double Yone, Ytwo;
    private LinkedList<Double> elements1, elements2;
    private Iterator iterator;
    private double counter1, counter2;
    private double rows;

    public ChartPanel(int row){
        Canvas = new Canvas(Integer.parseInt(myResources.getString("ChartWidth")),Integer.parseInt(myResources.getString("ChartHeight")));
        Background = Canvas.getGraphicsContext2D();
        Background.setFill(Color.WHITE);
        Background.fillRect(0, 0, Canvas.getWidth(), Canvas.getHeight());
        rows = row;
        counter1 = 0;
        counter2 = 0;
        elements1 = new LinkedList<Double>();
        elements2 = new LinkedList<Double>();

        //render();

    }

    public Canvas get_canvas(){
        return Canvas;
    }

    public void chart_handler(double sum1, double sum2){

        add_to_list(sum1, elements1);
        add_to_list(sum2, elements2);
        Background.setFill(Color.WHITE);
        Background.fillRect(0, 0, Canvas.getWidth(), Canvas.getHeight());
        line_handler(elements1, Color.BLUE, counter1);
        line_handler(elements2, Color.ORANGE,counter2);
    }

    private void line_handler(LinkedList elements, Color color, double counter){

        iterator = elements.listIterator();
        int thing = 0;
        if(counter ==0){
            Ytwo = 100;
        }

        Background.setFill(color);

        Background.setLineWidth(5);

        while(iterator.hasNext()){
            Yone= Ytwo;
            Ytwo = (double)iterator.next();
            Ytwo = Integer.parseInt(myResources.getString("ChartHeight"))*0.7-Ytwo*Integer.parseInt(myResources.getString("ChartHeight"))*0.7/(rows*rows);
            if(color.equals(Color.BLUE)){
                //System.out.println(Ytwo);
            }

            draw_line(thing,Ytwo);

            thing +=2;
            counter++;
        }
        if(counter>250){
            elements.removeFirst();
        }

    }

    private void add_to_list(double yvalue, List elements){
        elements.add(yvalue);
    }

    private void draw_line(double x1, double y1) {
        Background.fillOval(x1, y1, 5, 5);
    }









}
