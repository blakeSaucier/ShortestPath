package tests;
import algorithm.Djikstra;
import graph.Graph;
import graphics.GraphVisualizer;

public class TestGraph {
	
	public static final int VERTICES = 12;
	
	public static void main(String[] args) {
		Graph graph = Graph.makeGraph(VERTICES);
		new GraphVisualizer(graph);
		Djikstra djikstra = new Djikstra(graph);
		djikstra.execute();
	}
}
