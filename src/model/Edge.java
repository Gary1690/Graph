package model;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Edge extends Line2D {

	private Ellipse2D source;
	private Ellipse2D destination;
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private Color color = Color.BLUE;
	private boolean isShowingConected = false;
	

	public Edge(Ellipse2D source ,Ellipse2D destination) {
		super();
		this.source = source;
		this.destination = destination;
		this.x1 = source.getX()+7.5;
		this.y1 = source.getY()+7.5;
		this.x2 = destination.getX()+7.5;
		this.y2 = destination.getY()+7.5;
	}

	public Ellipse2D getSource() {
		return source;
	}

	public void setSource(Ellipse2D source) {
		this.source = source;
	}

	public Ellipse2D getDestination() {
		return destination;
	}

	public void setDestination(Ellipse2D destination) {
		this.destination = destination;
	}

	public boolean isMyVertex(Ellipse2D vertex) {
		if(source.equals(vertex)) {
			return true;
		}
		if(destination.equals(vertex)) {
			return true;
		}
		return false;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void resetColor() {
		this.color = Color.BLUE;
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return x1;
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return y1;
	}

	@Override
	public Point2D getP1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return x2;
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return y2;
	}

	@Override
	public Point2D getP2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub

	}

	public boolean isShowingConected() {
		return isShowingConected;
	}

	public void setShowingConected(boolean isShowingConected) {
		this.isShowingConected = isShowingConected;
	}
	
	public boolean containsVertex(Ellipse2D vertex1, Ellipse2D vertex2) {
		if(source.equals(vertex1) || source.equals(vertex2)) {
			return true;
		}
		if(destination.equals(vertex1) || destination.equals(vertex2)) {
			return true;
		}
		return false;
	}

}
