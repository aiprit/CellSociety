package ui;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rob on 9/26/15.
 */
public class ChartPanel {
    private  static final int GridWidth = 700;
    private  static final int GridHeight = 200;
    private Canvas Canvas;
    private GraphicsContext Background;
    private double Xone, Yone, Xtwo, Ytwo;
    private LinkedList<Double> elements;
    private Iterator backwards_iterator;
    private double counter;


    public ChartPanel(){
        Canvas = new Canvas(GridWidth,GridHeight);
        Background = Canvas.getGraphicsContext2D();
        Background.setFill(Color.WHITE);
        Background.setStroke(Color.BLUE);
        Background.setLineWidth(5);
        counter = 0;
        elements = new LinkedList<Double>();

        //render();




    }

    public void chart_handler(double d){
        add_to_list(d);
        line_handler();
    }


    private void line_handler(){
        backwards_iterator = elements.descendingIterator();
        int thing = 100;
        if(counter ==0){
            Ytwo = 0;
        }

        while(backwards_iterator.hasNext()){
            Yone= Ytwo;
            Ytwo = (double)backwards_iterator.next();
            draw_line(thing-1,Yone,thing,Ytwo);
            thing -=2;
            counter++;
        }
        if(counter>100){
            elements.removeFirst();
        }


    }



    private void add_to_list(double yvalue){
        elements.add(yvalue);
    }



    private void draw_line(double x1, double y1,double x2, double y2) {
        Background.strokeLine(x1, y1, x2, y2);

    }









}
