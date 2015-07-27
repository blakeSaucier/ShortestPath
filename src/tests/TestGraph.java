package tests;

import algorithm.Djikstra;
import graph.Graph;
import graphics.UIFrame;

public class TestGraph {
	
	public static final int INITIAL_VERTICES_COUNT = 3;
	
	public static void main(String[] args) {
		Graph graph = Graph.makeConnectedGraph(INITIAL_VERTICES_COUNT);
		new UIFrame(graph);
		
		Djikstra djikstra = new Djikstra(graph);
		djikstra.execute(graph.getVertices().get(0));
	}
}
