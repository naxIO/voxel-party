package main;

/** 
 * Launcher for Nexus
 * 
 * @author Lane Aasen <laneaasen@gmail.com>
 * 
 */

import mvc.Controller;
import mvc.Model;
import mvc.View;
import objects.Grid;
import objects.Block;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {
	public static final int WIDTH = 1366;
	public static final int HEIGHT = 768;
	
    public static void main(String[] argv) {
        try {
        	// initialize lwjgl
        	Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        	Display.setTitle("Nexus");
        	Display.create();
        	Keyboard.create();
        	Mouse.create();
	    
        	// start the mvc framework
        	Model world = new Model();
            View view = new View(world);
            @SuppressWarnings("unused")
            Controller conroller = new Controller(world);
            
            // populate the world
            world.grids.add(new Grid(10.0f, 1.0f, 0.0f, 1.0f));
            world.grids.add(new Grid(10.0f, 10.0f, 0.0f, 3.0f));
            
            world.blocks.add(new Block(new Point(0.0f, 0.0f, 0.0f), new Point(1.0f, 1.0f, 1.0f)));
            
            view.init();
        	
        } catch (LWJGLException e) {
        	e.printStackTrace();
        	System.exit(0);
        }
    }
}