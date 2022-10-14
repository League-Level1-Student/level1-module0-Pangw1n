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
    int score = 0;

    int pipeX;
    int topPipeHeight;
    int pipeGap;
    int bottomPipeHeight;
	int bottomPipePosition;
    
    PImage Bird;
    PImage topPipe;
    PImage bottomPipe;
    
    boolean gamestart = true;
    
    boolean canGetPoint = true;

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
    		bottomPipePosition = topPipeHeight + pipeGap;
        	topPipe.resize(100, topPipeHeight);
        	bottomPipe.resize(100, bottomPipeHeight);
            image(topPipe, pipeX, 0);
            image(bottomPipe, pipeX, bottomPipePosition);
        	image(Bird, x, y);
        	
        	textSize(50);
        	text(score, 0,50);
        	
            yvel += gravity;
        	y += yvel;
        	pipeX -= 5;
        	
        	if (y > HEIGHT) {
        		gamestart = false;
        	}
        	
        	if (pipeX < -100) {
        		resetPipes();
        		canGetPoint = true;
        	}
        	
        	if (intersectsPipes()) {
        		gamestart = false;
        	}
        	
        	if (pipeX + 100 < x && canGetPoint) {
        		score ++;
        		canGetPoint = false;
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
        if (y + 30  < topPipeHeight && x + 30 > pipeX && x + 30 < (pipeX+100)){
           return true; }
       else if (y + 30 > bottomPipePosition && x + 30 > pipeX && x + 30 < (pipeX+100)) {
           return true; }
       else { return false; }
}

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
