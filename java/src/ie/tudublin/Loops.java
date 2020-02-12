package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
	


	}

	
	public void keyPressed()
	{

	}	


	public void draw()
	{	
		background(0);	
		for(int i = 0;i<500; i = i+5){

			stroke(i%255);

			line(i, 0, i, 500);

		}
	
	}
}
