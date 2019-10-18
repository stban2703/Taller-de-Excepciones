package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

public class Logic {
	private Shape square;
	private Shape circle;
	private ArrayList<ColorBar> colorBars;
	private String message;
	private int messageRed;
	private int messageGreen;
	private PApplet app;

	public Logic(PApplet app) {
		colorBars = new ArrayList<ColorBar>();
		square = new Shape(250, app.height / 2 - 50, 255, 255, 255, false, "Vacío");
		circle = new Shape(700, app.height / 2, 255, 255, 255, false, "Vacío");
		colorBars.add(new ColorBar(255, 0, 0, 100, 700, 50, 50, "Rojo"));
		colorBars.add(new ColorBar(0, 255, 0, 150, 700, 50, 50, "Verde"));
		colorBars.add(new ColorBar(0, 0, 255, 200, 700, 50, 50, "Azul"));
		colorBars.add(new ColorBar(255, 255, 0, 250, 700, 50, 50, "Amarillo"));
		colorBars.add(new ColorBar(255, 0, 255, 300, 700, 50, 50, "Magenta"));
		colorBars.add(new ColorBar(0, 255, 255, 350, 700, 50, 50, "Cian"));
		colorBars.add(new ColorBar(239, 127, 26, 400, 700, 50, 50, "Naranja"));
		colorBars.add(new ColorBar(155, 1, 55, 450, 700, 50, 50, "Vino tinto"));
		colorBars.add(new ColorBar(85, 35, 100, 500, 700, 50, 50, "Morado"));
		colorBars.add(new ColorBar(20, 55, 0, 550, 700, 50, 50, "Verde oscuro"));
		message = "";
		messageRed = 255;
		messageGreen = 0;
		this.app = app;
	}

	public void paintShape() {
		app.stroke(0);
		app.strokeWeight(5);
		boolean selectSquare = this.square.isSelected();
		if (selectSquare) {
			app.stroke(255, 100, 100);
		} else {
			app.stroke(0);
		}
		app.rectMode(PConstants.CORNER);
		app.fill(square.getR(), square.getG(), square.getB());
		app.rect(this.square.getPosX(), this.square.getPosY(), 100, 100);

		app.stroke(0);
		app.strokeWeight(5);
		boolean selectCircle = this.circle.isSelected();
		if (selectCircle) {
			app.stroke(255, 100, 00);
		} else {
			app.stroke(0);
		}
		app.fill(circle.getR(), circle.getG(), circle.getB());
		app.ellipse(this.circle.getPosX(), this.circle.getPosY(), 100, 100);
	}

	public void paintBarColor() {
		for (int i = 0; i < colorBars.size(); i++) {
			float posX = colorBars.get(i).getPosX();
			float posY = colorBars.get(i).getPosY();
			float w = colorBars.get(i).getW();
			float h = colorBars.get(i).getH();
			int r = colorBars.get(i).getR();
			int g = colorBars.get(i).getG();
			int b = colorBars.get(i).getB();
			app.fill(r, g, b);
			app.noStroke();
			app.rectMode(PConstants.CORNER);
			app.rect(posX, posY, w, h);

			app.fill(255);
			app.textSize(20);
			app.noStroke();
			app.text("Haz clic en una figura y luego en un color para cambiar.", app.width / 2 - 130, 670);
		}
	}

	public void selectShape() {
		float squareX = this.square.getPosX();
		float squareY = this.square.getPosY();

		float circleX = this.circle.getPosX();
		float circleY = this.circle.getPosY();

		if (app.mouseX > squareX && app.mouseX < squareX + 100 && app.mouseY > squareY && app.mouseY < squareY + 100) {
			this.square.setSelected(true);
			this.circle.setSelected(false);
		} else if (app.mouseX > circleX - 50 && app.mouseX < circleX + 50 && app.mouseY > circleY - 50
				&& app.mouseY < circleY + 50) {
			this.square.setSelected(false);
			this.circle.setSelected(true);
		}
	}

	public void changeColor() {
		boolean selectSquare = this.square.isSelected();
		boolean selectCircle = this.circle.isSelected();
		for (int i = 0; i < colorBars.size(); i++) {
			float colorX = colorBars.get(i).getPosX();
			float colorY = colorBars.get(i).getPosY();
			float h = colorBars.get(i).getH();
			float w = colorBars.get(i).getW();
			int barRed = colorBars.get(i).getR();
			int barGreen = colorBars.get(i).getG();
			int barBlue = colorBars.get(i).getB();
			String nombre = colorBars.get(i).getNameColor();

			if (app.mouseX > colorX && app.mouseX < colorX + w && app.mouseY > colorY && app.mouseY < colorY + h
					&& selectSquare) {
				this.square.setR(barRed);
				this.square.setG(barGreen);
				this.square.setB(barBlue);
				this.square.setNameColor(nombre);
			}

			if (app.mouseX > colorX && app.mouseX < colorX + w && app.mouseY > colorY && app.mouseY < colorY + h
					&& selectCircle) {
				this.circle.setR(barRed);
				this.circle.setG(barGreen);
				this.circle.setB(barBlue);
				this.circle.setNameColor(nombre);
			}
		}
	}

	public void paintButtons() {
		app.stroke(0);
		app.strokeWeight(1);
		app.fill(0, 255, 0);
		app.rect(app.width / 2 - 50, 200, 100, 40);
		app.fill(0);
		app.textAlign(PConstants.CENTER, PConstants.CENTER);
		app.textSize(18);
		app.text("Comparar", app.width / 2, 220);

		app.fill(90, 90, 140);
		app.rect(app.width / 2 - 50, 250, 100, 40);
		app.fill(0);
		app.textAlign(PConstants.CENTER, PConstants.CENTER);
		app.textSize(18);
		app.text("Limpiar", app.width / 2, 270);

	}

	public void clearButton() {
		if (app.mouseX > app.width / 2 - 50 && app.mouseX < app.width / 2 + 50 && app.mouseY > 250
				&& app.mouseY < 290) {

			this.square.setSelected(false);
			this.circle.setSelected(false);

			this.square.setR(255);
			this.square.setG(255);
			this.square.setB(255);

			this.circle.setR(255);
			this.circle.setG(255);
			this.circle.setB(255);

			this.square.setNameColor("Vacío");
			this.circle.setNameColor("Vacío");

			this.message = "";
		}
	}

	public void paintColorNullMessage() {
		try {
			nullColor();
		} catch (Exception e) {
			app.fill(255, 0, 0);
			app.textSize(30);
			app.text(e.getMessage(), app.width / 2, 100);
		}
	}

	public void paintValidateColorMessage() {
		app.textSize(30);
		app.fill(messageRed, messageGreen, 0);
		app.text(this.message, app.width / 2, 100);
	}

	public void nullColor() throws ColorNullException {
		String colorSquare = this.square.getNameColor();
		String colorCircle = this.circle.getNameColor();
		if (colorSquare == "Vacío" || colorCircle == "Vacío") {
			throw new ColorNullException("Una o ambas figuras no tienen color");
		} else {

		}
	}

	public void compareColor() throws ColorException {
		String colorSquare = this.square.getNameColor();
		String colorCircle = this.circle.getNameColor();

		if (app.mouseX > app.width / 2 - 50 && app.mouseX < app.width / 2 + 50 && app.mouseY > 200 && app.mouseY < 240
				&& app.mousePressed) {
			if (colorSquare != colorCircle && colorSquare != "Vacío" && colorCircle != "Vacío") {
				messageRed = 255;
				messageGreen = 0;
				throw new ColorException(colorSquare + " no coincide con " + colorCircle);
			} else if (colorSquare == colorCircle && colorSquare != "Vacío" && colorCircle != "Vacío") {
				messageRed = 0;
				messageGreen = 255;
				throw new ColorException(colorSquare + " coincide con " + colorCircle);
			}
		}
	}

	public void generateMessage() {
		try {
			compareColor();
		} catch (Exception e) {
			this.message = e.getMessage();
		}
	}
}