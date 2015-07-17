package graph;

public class Vertex {

	private int ID;
	private String name;
	public static int vertexCount = 0;
	
	public Vertex() {
		vertexCount++;
		this.ID = vertexCount;
	}
	
	public Vertex(String name) {
		this();
		this.name = name;
	}
	
	public int getId() {
		return this.ID;
	}
	
	public String getName() {
		if (name == null) {
			return "ID: " + ID;
		}
		return name + ", ID: " + ID;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
