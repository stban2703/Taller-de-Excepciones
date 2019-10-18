package model;

public class Shape {
	private float posX;
	private float posY;
	private int r;
	private int g;
	private int b;
	private boolean selected;
	private String nameColor;

	public Shape(float posX, float posY, int r, int g, int b, boolean selected, String nameColor) {
		this.posX = posX;
		this.posY = posY;
		this.r = r;
		this.g = g;
		this.b = b;
		this.selected = selected;
		this.nameColor = nameColor;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getNameColor() {
		return nameColor;
	}

	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}
}