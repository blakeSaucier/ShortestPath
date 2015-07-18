package tests;
import graph.Graph;
import graphics.GraphVisualizer;

public class TestGraph {
	
	
	public static void main(String[] args) {
		Graph graph = Graph.createGraph(6);
		new GraphVisualizer(graph);
	}
}
