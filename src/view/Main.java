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
		background(80, 80, 80);
		logic.paintShape();
		logic.paintBarColor();
		logic.paintButtons();
		logic.paintColorNullMessage();
		logic.paintValidateColorMessage();
	}

	public void mousePressed() {
		logic.selectShape();
		logic.changeColor();
		logic.clearButton();
		logic.generateMessage();
	}
}