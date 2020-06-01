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
		// You can change these if you don't like the size!
		size(640, 360);
	}
	
	// Do any one-time initialization here, like initializing fields
	public void setup()
	{
		this.delay = 0;
		this.angle = 450;
		this.stepSize = (float) 0.025;
	}
	
	//gives random num from 0-255
	public int randomNum()
	{
		int num = 0;
		num  = (int)(Math.random() * 256);
		//System.out.println(num);
		return num;
	}
	
	
	// This gets called over and over again, once for each animation frame
	public void draw() 
	{
		float x = g.width / 2;
		float y = g.height / 2;
		int num = randomNum();
		
		
		if(num == 1)
		{ 
			
		}
		// Typically, you'll do something like this to clear the
		// screen before drawing your frame.  Feel free to change
		// the color.
		g.background(255 /* red */ , 255 /* green */, 255 /* blue */);

		// Then call methods on g to draw stuff.  This is just an example,
		// feel free to remove.  See the links at the top of this file
		// for documentation on the drawing methods you can call on g
		
		
		
		g.pushMatrix();
		g.translate(x, y);
		for (float step = 0; step <= 200; step += stepSize)
		{
			// Rotate what we're about to draw by one more angle subdivision
			g.rotate(angle);

			// Each square drawn with a random color
			g.stroke((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
			
			// Finally, draw the square.  Since we moved 0,0 to be the
			// center of the window,
			g.rect(
					-step,		// upper-left x
					-step,		// upper-left y
					step * 2, 	// width
					step * 2 	// height
					);
		}
		//sets stroke speed 
		if(delay == 10)
		{
			g.stroke(randomNum(),randomNum(),randomNum());
			delay = 0;
			System.out.println("w");
		}
		else
		{
			delay++;
		}
		g.rect(150, 150, 324, 124);
	}
}
