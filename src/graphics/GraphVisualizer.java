package graphics;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GraphVisualizer extends Frame{

	private static final int SCREEN_PADDING = 100;
	private static final int GRID_SIZE = 100;
	private static final long serialVersionUID = 1L;
	private Graph graph;
	private Random random;
	private final Button button;

	public GraphVisualizer(Graph graph) {
		super("Java 2D Example01");
		this.graph = graph;
		random = new Random();
		button = new Button("Reset vertex positions");
		setupButton();
		this.setLayout(new FlowLayout());
		
		setSize(1200, 800);
		setVisible(true);
		setBackground(Color.GRAY);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		generateVertexPoints();
		
	}

	private void setupButton() {
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateVertexPoints();
				update(getGraphics());
			}
		});
		this.add(button);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
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
	}
	
	private void generateVertexPoints() {
		for(Vertex vertex: graph.getVertices()) {
			int x = randomXCoord();
			int y = randomYCoord();
			vertex.setX(x);
			vertex.setY(y);
		}
	}
	
	private int randomXCoord() {
		int screenWidth = this.getWidth() - SCREEN_PADDING;
		int positions = screenWidth / GRID_SIZE;
		return (random.nextInt(positions) * GRID_SIZE) + SCREEN_PADDING;
	}
	
	private int randomYCoord() {
		int screenHeight = this.getHeight() - SCREEN_PADDING;
		int positions = screenHeight / GRID_SIZE;
		return (random.nextInt(positions) * GRID_SIZE) + SCREEN_PADDING;
	}
}