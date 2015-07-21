package graph;

import java.awt.Color;
import java.util.Random;

public class Edge {
	
	private int weight;
	private Vertex v1;
	private Vertex v2;
	
	// For visualizing graph
	private Color color;
	
	public Edge(int weight, Vertex v1, Vertex v2) {
		this.weight = weight;
		this.v1 = v1;
		this.v2 = v2;
		registerAdjacencies();
	}
	
	private void registerAdjacencies() {
		v1.registerAdjacency(v2);
		v2.registerAdjacency(v1);
	}
	
	public void deregisterAdjacencies() {
		v1.deregisterAdjacency(v2);
		v2.deregisterAdjacency(v1);
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public Vertex getV1() {
		return this.v1;
	}
	
	public Vertex getV2() {
		return this.v2;
	}
	
	public Color getColor() {
		if (this.color == null) {
			return Color.BLUE;
		}
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public static Edge makeEdge(Vertex v1, Vertex v2) {
		Random rand = new Random();
		Edge result = new Edge(rand.nextInt(15) + 1, v1, v2);
		result.setColor(Edge.randomColor());
		return result;
	}
	
	private static Color randomColor() {
		Random random = new Random();
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		return new Color(r, g, b);
	}
	
	
	@Override
	public String toString() {
		return v1 + " <-- " + weight + " --> " + v2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Edge arg = (Edge) obj;
		return ( (arg.getV1().equals(this.v1) && arg.getV2().equals(this.v2)) ||
				( arg.getV1().equals(this.v2) && arg.getV2().equals(this.v1)));
	}
}
