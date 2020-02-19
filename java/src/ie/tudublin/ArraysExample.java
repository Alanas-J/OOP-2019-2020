package ie.tudublin;

import java.util.Arrays; 
import java.util.Collections; 

import processing.core.PApplet;

public class ArraysExample extends PApplet
{	

	//float[] rainFall = new float[12]; 
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public void settings()
	{
		size(600, 600);
		
	}

	public void setup() 
	{
		for(int i = 0 ; i < rainFall.length; i ++)
		{
			println(months[i] + "\t" + rainFall[i]);
		}

		for(float f:rainFall)
		{
			println(f);
		}

		for(String s:months)
		{
			println(s);
		}

		int minIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		}
		println(months[minIndex] + " had the minimum rainfall of " + rainFall[minIndex]);
		
		
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}
		println(months[maxIndex] + " had the maximum rainfall of " + rainFall[maxIndex]);

		// You can also calculate the minimum and max of an arry this way:
		// Note the array is of type Float not float
		// Float are objects float is a primitive type
		Float[] floatArray = {10.0f, 5.0f, 20.0f};
		float min = Collections.min(Arrays.asList(floatArray)); 
        float max = Collections.max(Arrays.asList(floatArray));
	}

	void drawBarChart()
	{
		float w = width / (float) rainFall.length;
		float cGap = 255 / (float) rainFall.length;
		noStroke();
		colorMode(RGB);
		for(int i = 0 ; i < rainFall.length ; i ++)
		{
			float x = i * w;
			fill(i * cGap, 255, 255);
			rect(x, height, w, -rainFall[i]);
		}
	}

	public void keyPressed()
	{
		if (key == ' ')
		{
			background(0);
		}
	}	

	public void draw()
	{	
		copy(0, 0,	width, height, 10, 20, width, height);
		fill(0,80);
		square(0,0,height);
		fill(255);
		colorMode(HSB);	

		drawGraph();
		//drawBarChart();
	}

	boolean flip = true;
	int rgb = 0;
	int maxIndex = 0;
	int cushion = 60;
	void drawGraph(){

		
		if(flip){
			cushion++;
			if(cushion > 200){
				flip = false;
			}
		}
		else{
			cushion--;

			if(cushion < 40){
				flip = true;
			}
		}



		stroke(185);
		line(cushion, cushion, cushion, height-cushion);
		line(cushion, height-cushion, width-cushion, height-cushion);


		float currentPoint;
		float prevPoint;
		for(int i = 0 ; i < rainFall.length; i++){

	
			float x = map(i,0, rainFall.length-1,cushion,width-cushion);		
			stroke(255);
			line(x, height-cushion+3, x, height-cushion-3);

			if(i > 0){
				rgb = rgb + 25;
				stroke(rgb%255,255,255);

				currentPoint = map(rainFall[i], 0, rainFall[maxIndex], height-cushion, cushion);
				prevPoint = map(rainFall[i-1], 0, rainFall[maxIndex], height-cushion, cushion);

				line(x, currentPoint, map(i-1,0, rainFall.length-1,cushion,width-cushion), prevPoint);	
			}

			textAlign(CENTER);
			text(months[i],x, height-cushion+20);

		}

		int ySteps = (int) (rainFall[maxIndex] / 10);
		ySteps++;

		for(int i = 0; i <= ySteps; i++ ){
			
			float y = map(i,0, ySteps, height-cushion, cushion);
			
			stroke(255);
			line(cushion+3, height-y, cushion-3, height-y);

			String s = ""+(i*10);
			textAlign(RIGHT,CENTER);
			text(s, cushion-10, y);

		}


	}
}
