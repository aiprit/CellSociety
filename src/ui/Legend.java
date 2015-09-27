package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import parameter.Parameters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Rob on 9/27/15.
 */
public class Legend {

        private javafx.scene.canvas.Canvas Canvas;
        private GraphicsContext Background;
        private double Yone, Ytwo;
        private LinkedList<Double> elements1, elements2;
        private double counter1, counter2;
        private ResourceBundle myResources;


        public Legend(String blue, String orange){
            Canvas = new Canvas((int)myResources.getObject("LegendWidth"),(int)myResources.getObject("LegendHeight"));
            Background = Canvas.getGraphicsContext2D();
            Background.setFill((Color)myResources.getObject("BackgroundColor"));
            Background.fillRect(0, 0, Canvas.getWidth(), Canvas.getHeight());
            square_color();
            legend_names(blue,orange);

        }



        public Canvas get_legend(){
            return Canvas;
        }

        public void legend_names(String thing1, String thing2){
            Background.strokeText("Graph Key", 40, 20);
            if(thing1.equals("")){
                thing1="NA";
            }
            if(thing2.equals("")){
                thing2="NA";
            }
            Background.strokeText(thing1, 50, 60);
            Background.strokeText(thing2,50,120);

        }

        private void square_color(){
            Background.setFill((Color)myResources.getObject("GraphColorOne"));
            Background.fillRect(10, 50, 30, 30);
            Background.setFill((Color)myResources.getObject("GraphColorTwo"));
            Background.fillRect(10, 100, 30, 30);
        }










    }

