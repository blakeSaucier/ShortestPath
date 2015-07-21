package graph;

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
	
	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
	
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public void increaseEdgeDensity() {
		for(int i = 0; i < this.vertices.size(); i++) {
			int randomV1 = randomVertexIndex(vertices);
			int randomV2 = randomVertexIndex(vertices);
			if (randomV1 != randomV2) {
				Edge edge = Edge.makeEdge(vertices.get(randomV1), vertices.get(randomV2));
				if (isEdgeUnique(edges, edge)) {
					edges.add(edge);
				} else {
					edge.deregisterAdjacencies();
				}
			}
		}
	}
	
	public void addVertexAndEdge(Vertex v, Edge e) {
		this.vertices.add(v);
		this.edges.add(e);
	}
	
	public static int randomVertexIndex(List<Vertex> vertices) {
		Random rand = new Random();
		return vertices.size() > 1 ? rand.nextInt(vertices.size()) : 0; 
	}
		
	//////////////////////////////////////////////////////////////
	// Static factory convenience methods
	
	public static Graph makeConnectedGraph(int numVertices) {
		if (numVertices < 1) {
			throw new IllegalArgumentException("Must contain 1 or more vertices");
		}
		
		List<Vertex> vertices = new ArrayList<Vertex>(numVertices);
		List<Edge> edges = new ArrayList<Edge>();

		Vertex first = new Vertex();
		vertices.add(first);
		
		//Add vertices and edges to form a connected graph
		for (int i = 1; i < numVertices; i++) {
			Vertex v2 = new Vertex();
			vertices.add(v2);
			
			int randomVertexIndex = randomVertexIndex(vertices);
			while (vertices.get(randomVertexIndex).getId() == v2.getId()) {
				randomVertexIndex = randomVertexIndex(vertices);
			}
			Edge edge = Edge.makeEdge(vertices.get(randomVertexIndex), v2);
			edges.add(edge);
		}
		return new Graph(vertices, edges);
	}
		
	private static boolean isEdgeUnique(List<Edge> edges, Edge edge) {
		for (Edge e: edges) {
			if (e.equals(edge)) {
				return false;
			}
		}
		return true;
	}
}
