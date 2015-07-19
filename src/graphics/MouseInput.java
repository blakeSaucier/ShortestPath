package graphics;

import graph.Graph;
import graph.Vertex;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MouseInput extends MouseAdapter {

	private Graph graph;
	private JFrame frame;

	private Vertex selectedVertex = null;

	public MouseInput(Graph graph, JFrame frame) {
		this.graph = graph;
		this.frame = frame;
	}
	
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		selectVertex(e.getPoint());
		frame.paint(frame.getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		frame.paint(frame.getGraphics());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (selectedVertex != null) {
			selectedVertex.setX(e.getX());
			selectedVertex.setY(e.getY());
		}
	}

	private void selectVertex(Point point) {
		for (Vertex vertex : graph.getVertices()) {
			if (isContact(point, vertex)) {
				this.selectedVertex = vertex;
				return;
			}
		}
		this.selectedVertex = null;
	}

	private boolean isContact(Point point, Vertex vertex) {
		return ((Math.abs(point.getX() - vertex.getX()) < 10) && (Math
				.abs(point.getY() - vertex.getY()) < 10));
	}
}
