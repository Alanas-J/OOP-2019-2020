package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
    // Arraylist can grow and shrink
    // Generic
    ArrayList<Star> stars = new ArrayList<Star>(); 

    public void settings()
    {
        size(800, 800);

    }

    public void setup()
    {
        loadData();
        printStars();
        
    }

    public void loadData()
    {
        Table t = loadTable("HabHYG15ly.csv", "header");
        for(TableRow tr:t.rows())
        {
            Star s = new Star(tr);
            stars.add(s);
        }
    }

    public void printStars()
    {
        for(Star s:stars)
        {
            println(s);
        }
    }

    int inc = 0;
    public void draw()
    {
       
        inc++;
        resetMatrix();
        translate(width/2,height/2);
        scale(.5f);
        translate((inc*10)%400,0);

        rotate((float)inc/20);
    

        

        background(0);
    

        for( int i = -5 ; i <= 5 ; i++){

            
            stroke(255);
            float temp = map(i,-5 , 5, height/2, -height/2);



            text(i+"",-20-width/2,temp);
            text(-i+"",temp,-20-height/2);


            line(temp,height/2,temp,-height/2);
            line(height/2,temp,-height/2,temp);

        }

        for(Star s : stars){

            stroke(0,255,0);
            float multiplier = 400/5;

            //-5, 5 to 400 -400

            circle(s.getxG()*multiplier,-s.getyG()*multiplier,10);

        }

    }

    // hint sheet on brightspace
}
