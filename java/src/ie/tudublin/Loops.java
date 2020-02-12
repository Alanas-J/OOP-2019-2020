package ie.tudublin;

import java.io.LineNumberInputStream;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(HSB);


	}

	
	public void coolLines(){
		for(int i = 0; i < 500; i= i+ 10){

			line(x1,y1,x2,y2);

			line(i, 0, 500-i,500);

		}
	}

	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		background(0);	
		
		coolLines();
	
	}
}
