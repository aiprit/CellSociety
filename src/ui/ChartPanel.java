package ui;


import javafx.scene.Group;
import javafx.scene.Scene;
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
    private Canvas Canvas;
    private GraphicsContext Background;
    private double Yone, Ytwo;
    private LinkedList<Double> elements1, elements2;
    private Iterator iterator;
    private double counter1, counter2;
    private ResourceBundle myResources;

    public ChartPanel(){
        Canvas = new Canvas((int) myResources.getObject("GridWidth"),(int) myResources.getObject("GridHeight"));
        Background = Canvas.getGraphicsContext2D();
        Background.setFill((Color) myResources.getObject("BackgroundColor"));
        Background.fillRect(0, 0, Canvas.getWidth(), Canvas.getHeight());

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
        line_handler(elements1, (Color)myResources.getObject("GraphColorOne"), counter1);
        line_handler(elements2, (Color)myResources.getObject("GraphColorTwo"),counter2);
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
            Ytwo = 100.0 - (double) iterator.next();
            if(color.equals((Color)myResources.getObject("GraphColorOne"))){
                //System.out.println(Ytwo);
            }

            draw_line(thing,Ytwo);

            thing +=2;
            counter++;
        }
        if(counter>300){
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
