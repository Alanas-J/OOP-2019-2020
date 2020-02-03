package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
	}

	public float iteration = 1;
	public int i = 0;
	public int eye = 0;
	public void draw() {
		i = (i+10)%255;
		eye = (i+1)%100;


		background(i, 0, 255);
		stroke(255, 0, 0);
		fill(0, 255, 255);
		circle(250, 300, 400);
		fill(10, 255, 255,10);
		triangle(250, 50, 50, 450, 450, 450); // vertices	

		ellipse(250, 250, 200, mouseX%100);
		fill(255, 255, 0);
			// x1, y1, x2, y2
		point(50, 50); // x, y
		 // cx, cy, w, h
		fill(0, 255, 0);
		ellipse(250, 250, 50, mouseX%50);
		
		iteration = 1;
		drawYoke(500,250,1);

	}	
	
	public void drawYoke(float x5,float y5, float it){

		stroke(255, 250, 250);
		fill(255, 255, 0);
		line(x5,y5,(x5+1)*it,(y5-50)/it*2);

		if(it < 10){
			drawYoke((x5+1)*it,(y5-50)/it*2,it+1);		
		}
		iteration++;
	}

	int x = 0; // 4 bytes
	
	/*
	public void draw()
	{	
		
		background(0);
		noStroke();
		fill(255);
		ellipse(x, mouseY, 50, 50);		
		x ++;
	}
	*/
}
