package graph;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	
	public Graph() {
		super();
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	public void setVertices(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
	}
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public boolean containsVertex(Vertex v) {
		boolean ret = false;
		for (Vertex w: vertices) {
			if (w.equals(v)) {
				ret = true;
			}
		}
		return ret;
	}
	
	public boolean containsEdge(Vertex v1, Vertex v2) {
		boolean ret = false;
		for (Edge e: edges) {
			if (e.getV1().equals(v1) && e.getV2().equals(v2) || e.getV1().equals(v2) && e.getV2().equals(v1)) {
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	public void addEdge(Edge e) {
		if (!containsEdge(e.getV1(), e.getV2())) {
			edges.add(e);
			if (!containsVertex(e.getV1()))
				vertices.add(e.getV1());
			if (!containsVertex(e.getV2()))
				vertices.add(e.getV2());
		}
	}
	
	public Graph maximumSpanningTree() {
		Graph graph = new Graph();
		// Create fully connected graph
		for (Vertex v: vertices) {
			for (Vertex w: vertices) {
				if (!v.equals(w)) {
					graph.addEdge(new Edge(v, w));
					break;
				}
			}
		}
		
		//Weigh each edge
		//Remove all edges that aren't the highest weight connecting to a given vertex
		
		return graph;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result
				+ ((vertices == null) ? 0 : vertices.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (vertices == null) {
			if (other.vertices != null)
				return false;
		} else if (!vertices.equals(other.vertices))
			return false;
		return true;
	}
	
}
