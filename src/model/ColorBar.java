package model;

public class ColorBar {
	private int r;
	private int g;
	private int b;
	private float posX;
	private float posY;
	private float h;
	private float w;
	private String nameColor;

	public ColorBar(int r, int g, int b, float posX, float posY, float h, float w, String nameColor) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.posX = posX;
		this.posY = posY;
		this.h = h;
		this.w = w;
		this.nameColor = nameColor;
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

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public String getNameColor() {
		return nameColor;
	}

	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}
}