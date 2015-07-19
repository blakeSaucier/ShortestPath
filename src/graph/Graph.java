package graph;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
	
	private List<Vertex> vertices;
	private List<Edge> edges;
	
	public Graph(List<Vertex> vertices, List<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public List<Vertex> getVertices() {
		return this.vertices;
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	//////////////////////////////////////////////////////////////
	// Static factory convenience methods
	
	public static Graph makeGraph(int numVertices) {
		if (numVertices < 1) {
			throw new IllegalArgumentException("Must contain 1 or more vertices");
		}
		
		Random rand = new Random();
		List<Vertex> vertices = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();

		Vertex first = new Vertex();
		vertices.add(first);
		
		for (int i = 1; i < numVertices; i++) {
			Vertex v2 = new Vertex();
			vertices.add(v2);
			
			int randomVertexIndex = vertices.size() > 1 ? rand.nextInt(vertices.size() - 1) : 0; 

			Edge edge = new Edge(i, vertices.get(randomVertexIndex), v2);
			edge.setColor(Graph.randomColor(rand));
			edges.add(edge);
		}
		return new Graph(vertices, edges);
	}
	
	private static Color randomColor(Random random) {
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		return new Color(r, g, b);
	}
}
