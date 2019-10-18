package view;

import model.Logic;
import processing.core.PApplet;

public class Main extends PApplet {

	private static Logic logic;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(1000, 800);
	}

	public void setup() {
		background(80, 80, 80);
		logic = new Logic(this);
	}

	public void draw() {
		//background(80, 80, 80);
		logic.paintShape();
		logic.paintBarColor();
		logic.paintButtons();
	}

	public void mousePressed() {
		logic.selectShape();
		logic.changeColor();
		logic.clearButton();
		try {
			logic.compareColor();
		} catch (Exception e) {
			background(80, 80, 80);
			fill(255, 0, 0);
			textSize(30);
			text(e.getMessage(), width / 2, 100);
		}
	}
}
