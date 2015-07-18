package tests;
import graph.Graph;
import graphics.GraphVisualizer;

public class TestGraph {
	
	
	public static void main(String[] args) {
		Graph graph = Graph.createGraph(50);
		new GraphVisualizer(graph);
	}
}
