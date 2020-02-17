package ie.tudublin;

//import java.io.LineNumberInputStream;

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
		stroke(baseColor%255,255,255);
		for(int i = 0; i <= 500; i= i+ 20){

			line(0, i, 500,500-i);

			line(i, 0, 500-i,500);

		}
	}

	
	public void circlesDraw(){
		
		baseColor=baseColor+10; // rate of colour change
		noStroke();
		int x = 0;
		int circleRadius = 25;

		for (int xPos = circleRadius; xPos<width; xPos=xPos+(2*circleRadius)){
			
			
			for (int yPos = circleRadius; yPos<height; yPos=yPos+(2*circleRadius)){
				
				x = (255*(yPos+xPos-25))/(height+width);

				fill((x+baseColor)%255,255,255);
				circle((float)xPos, (float)yPos, 50);
			}
			
		}
		
	}
	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	

	int baseColor = 0;
	public void draw()
	{	
		background(100);	
		

		circlesDraw();
		//coolLines();
		//drawGrid();
	
		
	}

	void drawGrid(){

		//10 squares;
		stroke(100,255,255);
		fill(0);

		for(int i = 0; i <= 10; i++){

			String t = ""+(i-5);

			text(t,45+40*i,40);
			text(t,40,45+40*i);

			if(i==10)
				break;
			for(int j = 0; j < 10; j++){

				square(50+(40*i), 50+(40*j), 40);

			}

		}

	}

}
