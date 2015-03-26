package graph;

import java.util.ArrayList;
import java.util.Random;

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
	
	public boolean containsEdge(Edge edge) {
		boolean ret = false;
		for (Edge e: edges) {
			if (e.getV1().equals(edge.getV1()) && e.getV2().equals(edge.getV2()) || e.getV1().equals(edge.getV2()) && e.getV2().equals(edge.getV1())) {
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
		Graph mst = new Graph();
		
		// Create fully connected graph
		for (Vertex v: vertices) {
			for (Vertex w: vertices) {
				if (!v.equals(w)) {
					graph.addEdge(new Edge(v, w));
				}
			}
		}
		
		//Weigh each edge
		//simulation
		Random r = new Random();
		for (Edge e: graph.getEdges()) {
			e.setWeight(r.nextDouble());
		}
		
		//Remove all edges that aren't the highest weight connecting to a given vertex
		Edge maxWeightEdge = null;
		for (Edge e: graph.getEdges()) {
			if (maxWeightEdge == null)
				maxWeightEdge = e;
			else if (maxWeightEdge.getWeight() < e.getWeight())
				maxWeightEdge = e;
		}
		mst.addEdge(maxWeightEdge);

		int index = 0;
		while (index++ < vertices.size()) {
			maxWeightEdge = null;
		
			for (Edge e: graph.getEdges()) {
	
				if (!(mst.containsVertex(e.getV1()) && mst.containsVertex(e.getV2()))) {	
					if (maxWeightEdge == null) {
						maxWeightEdge = e;
					}
					else if (maxWeightEdge.getWeight() < e.getWeight()) {
						maxWeightEdge = e;
					}
				}
			}
			if (maxWeightEdge != null) {
				mst.addEdge(maxWeightEdge);
			}
		}
		
		while (mst.getEdges().size() < vertices.size()-1) {
			maxWeightEdge = null;
		
			for (Edge e: graph.getEdges()) {
	
				if (!mst.containsEdge(e)) {	
					if (maxWeightEdge == null) {
						maxWeightEdge = e;
					}
					else if (maxWeightEdge.getWeight() < e.getWeight()) {
						maxWeightEdge = e;
					}
				}
			}
			if (maxWeightEdge != null) {
				mst.addEdge(maxWeightEdge);
			}
		}
		
		return mst;
	}
	
	@Override
	public String toString() {
		String value = "";
		for (Edge e: edges) {
			value += "(" + e.getV1().getId() + "," + e.getV2().getId() + ")\n";
		}
		return value;
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
	
	public static void main (String[] args) {
		Graph g = new Graph();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		g.addEdge(new Edge(v1, v2));
		g.addEdge(new Edge(v1, v3));
		g.addEdge(new Edge(v2, v4));
		g.addEdge(new Edge(v3, v5));
		g.addEdge(new Edge(v3, v6));
				
		Graph mst = g.maximumSpanningTree();
		System.out.println(mst.toString());
	}
	
}
