import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL;

public class Main implements Runnable{
 
	private int width = 800, height = 600;
	private Thread thread;
	public long window;
	
	private boolean isRunning;
	
	public void start(){
		isRunning = true;
		thread = new Thread(this, "First Person Shooter v0.01");
		thread.start();
	}
	
	public void init(){
		
		// runs glfwInit and if it returns false
		// then we print out our error
		if(glfwInit() != GL_TRUE){
			System.err.println("GLFW Initialization Failed!");
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		
		window = glfwCreateWindow(width, height, "FPS", NULL, NULL);
		
		glfwSetWindowPos(window, 100, 100);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		
		GL.createCapabilities();
		
		
		
	}
	
	public void update() {
		glfwPollEvents();
	}
	
	public void render() {		
		glfwSwapBuffers(window);
	}
	
	public void run() {
		init();
		while(isRunning){
			update();
			render();
			
			if(glfwWindowShouldClose(window) == GL_TRUE){
				isRunning = false;
			}
		}
	}

	public static void main(String[] args) {
	    Main game = new Main();
	    game.start();
	}
 
}