package _01_methods._1_houses;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	Robot robot = new Robot(850,500);
	public void run() {
		// Check the recipe to find out what code to put here\
		robot.setSpeed(100);
		robot.setPenWidth(3);
		robot.penDown();
		robot.turn(-90);
		for (int i = 0; i < 10; i++) {
			drawgrass();
			
			int housetype = new Random().nextInt(2);
			int height = new Random().nextInt(190)+60;
			
			int red = new Random().nextInt(255);
			int green = new Random().nextInt(255);
			int blue = new Random().nextInt(255);
			
			if (housetype == 0) {
				drawHouse(height,red,green,blue);
			}
			else {
				drawPeakedHouse(height,red,green,blue);
			}
		}
	}
	private void drawHouse(int height, int r, int g, int b)
	{
		//int height = 100;
		//if (size == "small") {
		//	height = 60;
		//}
		//else if (size == "medium") {
		//	height = 120;
		//}
		//else if (size == "large") {
		//	height = 250;
		//}
		robot.setPenColor(r,g,b);
		robot.turn(90);
		robot.move(height);
		robot.turn(-90);
		robot.move(50);
		robot.turn(-90);
		robot.move(height);
		robot.turn(90);
	}
	private void drawPeakedHouse(int height, int r, int g, int b)
	{
		robot.setPenColor(r,g,b);
		robot.turn(90);
		robot.move(height);
		robot.turn(-45);
		robot.move(35);
		robot.turn(-90);
		robot.move(35);
		robot.turn(-45);
		robot.move(height);
		robot.turn(90);
	}
	private void drawgrass()
	{
		robot.setPenColor(0, 100 , 0);
		robot.move(30);
	}
}
