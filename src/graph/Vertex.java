package graph;

public class Vertex {

	private int ID;
	public static int vertexCount = 0;
	
	// used for drawing vertices, not needed for Djikstra's
	private int x;
	private int y;
	
	public Vertex() {
		vertexCount++;
		this.ID = vertexCount;
	}
	
	public int getId() {
		return this.ID;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
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
}
