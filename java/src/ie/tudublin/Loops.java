package ie.tudublin;

import java.beans.XMLDecoder;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public void settings()
	{
		size(800, 800);
		
	}

	public void setup() 
	{
		colorMode(HSB,1000);
		pixelDensity(1);
	
	}

	
	public void keyPressed()
	{

	}	


	public void draw()
	{	
		
		background(0);
		
		

		// establish a range of values on complex plane
		// different range will allow us to zoom in and out

		// it all starts with the width try higher or lower values
		float w = 3;
		float h = 3;

		float xmin = -w/1.4f;
		float ymin = -h/2;

		loadPixels();

		int maxiterations = 100;

		float xmax = xmin + w;

		float ymax = ymin + h;


		//calculate ammoutn we increment x,y for each pixel.
		float dx = (xmax - xmin) / (width);
		float dy = (ymax - ymin) / (height);


		// start y
		float y = ymin;
		for (int j = 0; j<height; j++){

			//start x
			float x = xmin;
			for ( int i = 0; i < width; i++){

				float a = x;
				float b = y;
				int n = 0;
				while(n < maxiterations){ // max iterations

					float aa = a*a;
					float bb = b*b;
					float twoab = 2.0f * a * b;


					a = aa - bb + x;
					b = twoab + y;
					if(aa*aa + bb*bb > 1000.0f){
						break;
					}
					//if(aa*aa + bb*bb < 0.01f){
					//	break;
					//}

					n++;
				}
				if( n == 100){
					pixels[j+i*width] = color(0);
				}
				else{
					pixels[j+i*width] = color(  ((((int)(sqrt(n)*1000)+inc)%1000)) ,700,1000);
				}
				x += dx;
			}
			y += dy;

			
		}
		updatePixels();
		inc+= 10;
		text(inc,20,20);
	}
	int inc;
}
