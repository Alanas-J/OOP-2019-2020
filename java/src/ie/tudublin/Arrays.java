package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		
	}

	String seasons[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
	int rainfall[]={10,30,200,9,23,124,346,675,54,46,67,67};


	float offset = 0;

	
	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		background(0);
		float space = 25;
		float xPos = space;
		float barLength = (width - (2*space))/seasons.length;
		int maxHeight = 0;
		
		for (int i = 0 ; i < seasons.length; i++)
			if(maxHeight < rainfall[i])
				maxHeight = rainfall[i];

		for (int i = 0 ; i < seasons.length; i++){

			fill((i*20)%255,255,255);
			stroke(0);

			rect(xPos,400,barLength,-((height-(100+space)) //-rainfall[i]);

			xPos = xPos+barLength;
		}

			
		colorMode(HSB);	
	}
}
