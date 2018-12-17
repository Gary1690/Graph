package model;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Vertex extends Ellipse2D {
	
	public Vertex(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		this.width = 15;
		this.height = 15;
	}

	private double x;
	private double y;
	private double width;
	private double height;
	private Color color = Color.RED;
	private boolean isDelete= false;
	
	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		
		return y;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFrame(double x, double y, double w, double h) {
		// TODO Auto-generated method stub

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void resetColor() {
		this.color = Color.RED;
	}
}
