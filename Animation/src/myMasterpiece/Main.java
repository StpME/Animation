package myMasterpiece;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import java.awt.Color;

// Simplified docs: https://processing.org/reference/
// JavaDocs: http://processing.github.io/processing-javadocs/core/

public class Main extends PApplet
{
	// Declare any private fields you need to help keep track of
	// stuff while your masterpiece animates itself
	private int delay;
	private int angle;
	private float stepSize;
	private int delay2;
	private boolean bounce;
	public static void main(String[] args) 
	{
		
		// This string MUST match your package and class name
		PApplet.main("myMasterpiece.Main");

		// DO NOT ADD ANYTHING ELSE TO THIS MAIN METHOD
		//
		// Instead, the following methods are called, in this order:
		//
		// settings -- this determines the size of the window
		//
		// setup -- any initialization should be put here
		//
		// draw (repeatedly) -- this is called over and over again
		//						in a loop.  Each call is a like a single
		//						frame in the animation.
	}

	// This method determines the size of the window and does nothing else 
	public void settings() 
	{
		// These numbers decide how big the window is.
		// You can change these if you don't like the size
		size(1080, 720);
		
	}
	
	// Do any one-time initialization here, like initializing fields
	public void setup()
	{
		this.delay = 0;
		this.delay2=0;
		this.angle = 75;
		this.stepSize = (float) 0.150;
		g.fill = false;
		this.bounce = false;
	}
	
	//gives random num from 0-255
	public int randomNum()
	{
		int num = 0;
		num  = (int)(Math.random() * 150);
		//System.out.println(num);
		return num;
	}
	public int simpleNum()
	{
		int num = 1;
		num  = (int)(Math.random() * 4);
		System.out.println(num);
		return num;
	}
	
	public void randomColorScheme(int value)
	{
		if(value == 0)
		{
			g.stroke(0,0,0);
		}
		else if(value==1)
		{
			g.stroke(0,0,randomNum());
		}
		else if (value==2)
		{
			g.stroke(0,randomNum(),0);
		}
		else if (value==3)
		{
			g.stroke(randomNum(),0,0);
		}
	}
	
	
	// This gets called over and over again, once for each animation frame
	public void draw() 
	{
		float x = g.width / 2;
		float y = g.height / 2;
		int num = randomNum();
		
		// Typically, you'll do something like this to clear the
		// screen before drawing your frame.  Feel free to change
		// the color.
		g.background(245  , 245 , 245 );

		// Then call methods on g to draw stuff.  This is just an example,
		// feel free to remove.  See the links at the top of this file
		// for documentation on the drawing methods you can call on g
		
		
		
		//g.pushMatrix();
		g.translate(x, y);
		for (float step = 0; step <=150; step += stepSize)
		{
			// Rotate what we're about to draw by one more angle subdivision
			
			
			// Each square drawn with a random color (use for testing only)
			//g.stroke((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
			
			// Finally, draw the square.
			g.rect(
					step,		// upper-left x
					step,		// upper-left y
					step * 2, 	// width
					step * 2 	// height
					);
			//sets stroke speed 
			if(delay == 2500)
			{
				
				//System.out.println("w" + delay);
				delay = 0;
				
				if(angle!=1000)
				{
					angle+=1;
				}
				else
				{
					angle-=500;
				}
				
			}
			else
			{
				g.rotate(angle);
				delay++;
				//System.out.println("L" + delay);
			}
			
			//g.rotate(angle);
			
			//less bright colors
			if(delay2 == 5000)
			{
				randomColorScheme(simpleNum());
				delay2=0;
			}
			else
			{
				delay2++;
			}
		}
		
		if (bounce)
		{
			stepSize += 0.01;
		}
		else
		{
			stepSize -= 0.01;
		}
		
		// This decides if we need to bounce.  Once stepSize
		// has gotten small enough or large enough, flip stepUp
		if (stepSize < 0.1|| stepSize > 5)
		{
			bounce = !bounce;
		}
		g.pushMatrix();
		g.popMatrix();
	}
}
