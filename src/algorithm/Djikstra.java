package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import graph.Graph;
import graph.Vertex;

public class Djikstra {
	
	private Graph graph;
	
	private Map<Vertex, Integer> distances;
	private Set<Vertex> unDecided;
	public Djikstra(Graph graph) {
		this.graph = graph;
	}
	
	public void execute(Vertex start) {
		System.out.println("Running djikstra's");
		distances = new HashMap<Vertex, Integer>();
		unDecided = new HashSet<Vertex>();
		
		initializeDistances();
		distances.put(start, 0);
		unDecided.add(start);
		while (unDecided.size() > 0) {
			Vertex nextMinimum = smallestUndecided();
			exploreAdjacent(nextMinimum);
		}
	}
	
	private void exploreAdjacent(Vertex vertex) {
		int currentDistance = distances.get(vertex);
		for (Vertex adjacent: vertex.getAdjacencies()) {
			int weight = graph.getEdge(vertex, adjacent).getWeight();
			if ((weight + currentDistance) < distances.get(adjacent) ) {
				distances.put(adjacent, weight + currentDistance);
			}
			unDecided.add(adjacent);
		}
	}
	
	private void initializeDistances() {
		for(Vertex vertex: graph.getVertices()) {
			distances.put(vertex, Integer.MAX_VALUE);
		}
	}
	
	private Vertex smallestUndecided() {
		Vertex minimumDistance = null;
		Integer min = Integer.MAX_VALUE;
		for (Vertex v: unDecided) {
			Integer distance = distances.get(v);
			if (distance < min) {
				minimumDistance = v;
			}
		}
		unDecided.remove(minimumDistance);
		return minimumDistance;
	}
}
