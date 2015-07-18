package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graphics.VisualizeGraph;

public class TestGraph {
	
	
	public static void main(String[] args) {
		Graph graph = createGraph();
		new VisualizeGraph(graph);
		
	}

	private static Graph createGraph() {
		Random rand = new Random();
		
		List<Vertex> vertices = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();

		Vertex first = new Vertex();
		Vertex second = new Vertex();
		vertices.add(first);
		vertices.add(second);
		edges.add(new Edge(1, first, second));
		
		for (int i = 0; i < 20; i++) {
			Vertex v2 = new Vertex();
			vertices.add(v2);
			int randomVertex = rand.nextInt(vertices.size() - 1);
			Edge edge = new Edge(1, vertices.get(randomVertex), v2);
			edges.add(edge);
		}
		return new Graph(vertices, edges);
	}
}
