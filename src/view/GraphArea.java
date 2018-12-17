package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Utility.Status;
import Utility.StatusObserver;
import model.Edge;
import model.Vertex;

public class GraphArea extends JPanel implements  MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Ellipse2D> vertices;
	private ArrayList<Line2D> edges;
	//Only for the purpose of drawing the edges;
	private Ellipse2D startingVertex;
	public GraphArea() {
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(189, 0, 562, 591);
		this.setLayout(null);
		this.addMouseListener(this);
		vertices = new ArrayList<Ellipse2D>();
		edges = new ArrayList<Line2D>();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(StatusObserver.getStatus().getCurrentStatus() == Status.AddVertex) {
			Ellipse2D v = new Vertex( e.getX(), e.getY());
			vertices.add(v);
			this.repaint();
		}
		if(StatusObserver.getStatus().getCurrentStatus() == Status.RemoveVertex){
			Ellipse2D vertex = findVertex(e.getX(), e.getY());
			if(vertex != null) {
				/*ArrayList<Line2D> edgesToRemove = new ArrayList<Line2D>();
				for(Line2D edge : edges) {
					boolean isANode = ((Edge)edge).isMyVertex(vertex);
					if(isANode) {
						edgesToRemove.add(edge);
					}
				}
				edges.removeAll(edgesToRemove);
				vertices.remove(vertex);*/
				((Vertex) vertex).setDelete(true);
				((Vertex) vertex).setColor(Color.GREEN);
				this.repaint();
			}
			
		}
		if(StatusObserver.getStatus().getCurrentStatus() == Status.AddEdge) {
			Ellipse2D vertex = findVertex(e.getX(), e.getY());
			if(vertices.size() < 2 ) {
				javax.swing.JOptionPane.showMessageDialog(null,"There should be at least 2 vertices to draw an edge");
			}
			else if(vertex != null) {
				if(startingVertex != null) {
					if(startingVertex.equals(vertex)) {
						javax.swing.JOptionPane.showMessageDialog(null,"You must choose a different vertex");
					}
					else {
						Line2D edge = new Edge((Vertex) startingVertex,(Vertex) vertex);
						this.edges.add(edge);
						((Vertex)startingVertex).resetColor();
						startingVertex  = null;
						this.repaint();
					}
				}else {
					startingVertex = vertex;
					((Vertex)startingVertex).setColor(Color.GREEN);
					this.repaint();
				}
			}
		}
		if(StatusObserver.getStatus().getCurrentStatus() == Status.RemoveEdge) {
			Line2D edge = findEdge(e.getX(),e.getY());
			if(edge != null) {
				edges.remove(edge);
				this.repaint();
			}
			
			
		}
		
		
	}
	
	public void AddAllEdges() {
		resetEdges();
		for(int i = 0; i<vertices.size();i++) {
			if(((Vertex)vertices.get(i)).isDelete()) {
				continue;
			}
			for(int j = i+1; j<vertices.size();j++) {
				if(((Vertex)vertices.get(j)).isDelete()) {
					continue;
				}
				Line2D edge = new Edge(vertices.get(i),vertices.get(j));
				this.edges.add(edge);
			}
		}
		this.repaint();
	}
	
	public void showCutVertices() {
		repaint();
	}
	public Ellipse2D findVertex (double x,double y) {
		boolean isAVertex = false;
		for(Ellipse2D v : vertices) {
			isAVertex = v.contains(x,y) && !((Vertex)v).isDelete();
			if(isAVertex == true) {
				return v;
			}
		}
		return null;
	}
	public Line2D findEdge (double x,double y) {
		boolean isAnEdge = false;
		for(Line2D e : edges) {
			isAnEdge = e.intersectsLine(x-5, y-5,x+5,y+5);
			if(isAnEdge == true) {
				return e;
			}
		}
		return null;
	}
	public void paintComponent(Graphics g ) {
		super.paintComponent(g);
		if(vertices.size() > 0){
			for(Ellipse2D v : vertices  ) {
				if(((Vertex)v).isDelete() && !StatusObserver.getStatus().isShowCutVerticesIsOn()) {
					continue;
				}
				g.setColor(((Vertex)v).getColor());
				((Graphics2D) g).fill(v);
			}
		}
		if(edges.size() > 0){
			for(Line2D e : edges  ) {
				g.setColor(((Edge)e).getColor());
				Graphics2D g2 = ((Graphics2D) g);
				g2.setStroke(new BasicStroke(5));
				g2.draw(e);
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void resetEdges() {
		for(Line2D e : edges) {
			((Edge)e).resetColor();
			((Edge)e).setShowingConected(false);
		}
	}
	
	public void showConectedComponents() {
		resetEdges();
		Color [] colors = {Color.YELLOW,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK};
		for(int i = 0; i<edges.size();i++) {
			makeConection(edges.get(i),colors[i%colors.length]);
		}
		repaint();
	}	
	public void makeConection(Line2D edge, Color color) {
		
		if(((Edge) edge).isShowingConected()) {
			color = ((Edge) edge).getColor();
		}
		Object[] conected = edges.stream().filter(x -> ((Edge)x).containsVertex(((Edge)edge).getSource(),((Edge)edge).getDestination())).toArray();
		for(Object o : conected) {
			((Edge)o).setColor(color);
			((Edge)o).setShowingConected(true);
		}
	}
}
