package graph;

public class Edge {
	
	private int weight;
	private Vertex v1;
	private Vertex v2;
	
	public Edge(int weight, Vertex v1, Vertex v2) {
		this.weight = weight;
		this.v1 = v1;
		this.v2 = v2;
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
	
	@Override
	public String toString() {
		return v1 + "<-- " + weight + " -->" + v2;
	}
}
