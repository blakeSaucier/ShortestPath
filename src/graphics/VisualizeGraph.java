package graphics;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class VisualizeGraph extends Frame {

	private static final long serialVersionUID = 1L;
	private Graph graph;
	private Random random;

	public VisualizeGraph(Graph graph) {
		super("Java 2D Example01");
		this.graph = graph;
		random = new Random();
		setSize(800, 600);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		for(Vertex vertex: graph.getVertices()) {
			int x = random.nextInt(this.getWidth() - 200) + 100;
			int y = random.nextInt(this.getHeight()- 200) + 100;
			vertex.setX(x);
			vertex.setY(y);
			g.setColor(Color.BLUE);
			g.fillOval(x - 10, y - 10, 20, 20);
			g.setColor(Color.DARK_GRAY);
			g.drawString(vertex.toString(), x -10 , y - 12);
		}
		g.setColor(Color.BLACK);
		for (Edge edge: graph.getEdges()) {
			g.drawLine(edge.getV1().getX(), edge.getV1().gety(), edge.getV2().getX(), edge.getV2().gety());
		}
		
	}
}