package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int ID;
	public static int vertexCount = 0;
	private List<Vertex> adjacentVertices;
	
	// used for drawing vertices, not needed for Djikstra's
	private int x;
	private int y;
	
	public Vertex() {
		vertexCount++;
		this.ID = vertexCount;
		adjacentVertices = new ArrayList<Vertex>();
	}
	
	public int getId() {
		return this.ID;
	}
	
	public void registerAdjacency(Vertex vertex) {
		this.adjacentVertices.add(vertex);
	}
	
	public void deregisterAdjacency(Vertex vertex) {
		adjacentVertices.remove(vertex);
	}
	
	///////////////////////////////////////////////////
	// X and Y coordinates are for graph visualization
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public List<Vertex> getAdjacencies() {
		return this.adjacentVertices;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "ID: " + ID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Vertex arg = (Vertex) obj;
		return arg.ID == this.ID;
	}
}
