package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    int x;
    int y;
    float yvel;
    float gravity;

    int pipeX;
    int topPipeHeight;
    int pipeGap;
    int bottomPipeHeight;
    
    PImage Bird;
    PImage topPipe;
    PImage bottomPipe;
    
    boolean gamestart = true;

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
    	resetPipes();
    	pipeGap = 200;
    	
    	Bird = loadImage("images/bird.png");
    	Bird.resize(60, 60);
    	topPipe = loadImage("images/topPipe.png");
    	topPipe.resize(100, topPipeHeight);
    	bottomPipe = loadImage("images/bottomPipe.png");
    	bottomPipe.resize(100, bottomPipeHeight);
    	
    	x = 50;
    	gravity = 0.4f;
    }

    @Override
    public void draw() {
    	if (gamestart)
    	{
    		background(0, 200, 255);
        	topPipe.resize(100, topPipeHeight);
        	bottomPipe.resize(100, bottomPipeHeight);
            image(topPipe, pipeX, 0);
            image(bottomPipe, pipeX, topPipeHeight + pipeGap);
        	image(Bird, x, y);
        	
        	
        	
            yvel += gravity;
        	y += yvel;
        	
        	if (y > HEIGHT) {
        		gamestart = false;
        	}
        	
        	pipeX -= 5;
        	if (pipeX < -100) {
        		resetPipes();
        	}
        	
        	if (intersectsPipes()) {
        		gamestart = false;
        	}
    	}
    }
    
    public void mousePressed() {
		yvel = -8;
	}
    
    public void resetPipes() {
		pipeX = WIDTH;
    	topPipeHeight = (int) random(100, 400);
    	bottomPipeHeight = HEIGHT - topPipeHeight - pipeGap;
    }
    
    boolean intersectsPipes() { 
        if (y + 25 < topPipeHeight && x > pipeX && x < (pipeX+100)){
           return true; }
       else if (y + 25>bottomPipeHeight && x > pipeX && x < (pipeX+100)) {
           return true; }
       else { return false; }
}

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
