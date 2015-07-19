package graphics;

import graph.Graph;

import javax.swing.JFrame;

public class UIFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public UIFrame(Graph graph) {
		super("Graph Visualizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setVisible(true);
		add(new GraphVisualizer(graph));
	}
}
