package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import parameter.Parameters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rob on 9/27/15.
 */
public class Legend {



        private  static final int GridWidth = 150;
        private  static final int GridHeight = 150;
        private javafx.scene.canvas.Canvas Canvas;
        private GraphicsContext Background;
        private double Yone, Ytwo;
        private LinkedList<Double> elements1, elements2;
        private double counter1, counter2;


        public Legend(String blue, String orange){
            Canvas = new Canvas(GridWidth,GridHeight);
            Background = Canvas.getGraphicsContext2D();
            Background.setFill(Color.WHITE);
            Background.fillRect(0, 0, Canvas.getWidth(), Canvas.getHeight());
            square_color();
            legend_names(blue,orange);

        }



        public Canvas get_legend(){
            return Canvas;
        }

        public void legend_names(String thing1, String thing2){
            Background.strokeText("Lower Graph Key", 25, 20);
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
            Background.setFill(Color.BLUE);
            Background.fillRect(10, 50, 30, 30);
            Background.setFill(Color.ORANGE);
            Background.fillRect(10, 100, 30, 30);
        }










    }

