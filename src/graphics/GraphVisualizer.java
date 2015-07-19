package graphics;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import tests.TestGraph;

public class GraphVisualizer extends JPanel{

	private static final int SCREEN_PADDING = 100;
	private static final int GRID_SIZE = 100;
	private static final long serialVersionUID = 1L;
	
	private Graph graph;
	private Random random;
	private Button repositionVerticesButton;
	private Button regenerateGraphButton;
	private Button addDensityButton;
	private MouseInput input;

	public GraphVisualizer(Graph graph) {
		this.graph = graph;
		init();
	}
	
	private void init() {
		random = new Random();
		setSize(1200, 800);
		input = new MouseInput(graph, this);
		addMouseListener(input);
		addMouseMotionListener(input);
		repositionVerticesButton = new Button("Reset vertex positions");
		regenerateGraphButton = new Button("Regenerate Graph");
		addDensityButton = new Button("Increase Edge Density");
		setupButtons();
		this.setLayout(new FlowLayout());
		generateVertexPoints();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.setStroke(new BasicStroke(3));
		g2d.setFont(new Font("SanSerif",Font.BOLD, 20));
		for (Edge edge: graph.getEdges()) {
			g2d.setColor(edge.getColor());
			g2d.drawLine(edge.getV1().getX(), edge.getV1().getY(), edge.getV2().getX(), edge.getV2().getY());
			int middleX = edge.getV1().getX() + ((edge.getV2().getX() - edge.getV1().getX()) / 2);
			int middleY = edge.getV1().getY() + ((edge.getV2().getY() - edge.getV1().getY()) / 2);
			g2d.drawString(Integer.toString(edge.getWeight()), middleX + 5, middleY - 5);
		}
		
		for(Vertex vertex: graph.getVertices()) {
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.fillOval(vertex.getX() - 10, vertex.getY() - 10, 20, 20);
			g2d.setColor(Color.DARK_GRAY);
			g2d.drawString(vertex.toString(), vertex.getX() -10 , vertex.getY() - 12);
		}
		g2d.dispose();
	}
	
	private void setupButtons() {
		repositionVerticesButton.setFocusable(false);
		regenerateGraphButton.setFocusable(false);
		addDensityButton.setFocusable(false);
		repositionVerticesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateVertexPoints();
				paint(getGraphics());
			}
		});
		regenerateGraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateNewGraph();
				generateVertexPoints();
				paint(getGraphics());
			}
		});
		addDensityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graph.addDensity();
				paint(getGraphics());
			}
		});
		this.add(repositionVerticesButton);
		this.add(regenerateGraphButton);
		this.add(addDensityButton);
	}
	
	private void generateVertexPoints() {
		List<VertexCoordinate> coordinates = getAllPossibleCoordinates();
		for(Vertex vertex: graph.getVertices()) {
			VertexCoordinate coord = pickRandomCoordinate(coordinates);
			int x = coord.x;
			int y = coord.y;
			vertex.setX(x);
			vertex.setY(y);
		}
	}
	
	private VertexCoordinate pickRandomCoordinate(List<VertexCoordinate> coordinates) {
		return coordinates.remove(random.nextInt(coordinates.size() - 1));
	}
	
	private List<VertexCoordinate> getAllPossibleCoordinates() {
		List<VertexCoordinate> coordinates = new ArrayList<VertexCoordinate>();
		int numColumns = (this.getWidth() - SCREEN_PADDING) / GRID_SIZE;
		int numRows = (this.getHeight() - SCREEN_PADDING) / GRID_SIZE;
		for (int column = 0; column < numColumns; column++) {
			for (int row = 0; row < numRows; row++) {
				int x = column * GRID_SIZE + SCREEN_PADDING;
				int y = row * GRID_SIZE + SCREEN_PADDING;
				coordinates.add(new VertexCoordinate(x, y));
			}
		}
		return coordinates;
	}
	
	private void generateNewGraph() {
		Graph tempGraph = Graph.makeGraph(TestGraph.VERTICES);
		this.graph.setVertices(tempGraph.getVertices());
		this.graph.setEdges(tempGraph.getEdges());
	}
	
	////////////////////////////////////////////////////////////
	// private class for handling locations of the vertices
	
	private class VertexCoordinate {
		int x;
		int y;
		
		public VertexCoordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};
}