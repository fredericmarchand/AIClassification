package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Graph {
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	
	public Graph() {
		super();
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public Graph(Graph g) {
		super();
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		vertices.addAll(g.getVertices());
		edges.addAll(g.getEdges());
	}
	
	public Graph(Graph g, Edge e) {
		super();
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		vertices.addAll(g.getVertices());
		edges.addAll(g.getEdges());
		this.addEdge(e);
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
	
	public Vertex getVertexByID(int id) {
		for (Vertex v: vertices) {
			if (v.getId() == id)
				return v;
		}
		return null;
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
	
	public HashSet<Integer> vertexConnections(Vertex v) {
		HashSet<Integer> ids = new HashSet<Integer>();
		
		for (Edge e: edges) {
			if (e.getV1().equals(v))
				ids.add(e.getV2().getId());
			else if (e.getV2().equals(v))
				ids.add(e.getV1().getId());
		}
		return ids;
	}
	
	public boolean parentInCommon(Vertex v1, Vertex v2) {
		boolean ret = false;
		HashSet<Integer> v1cons = this.vertexConnections(v1);
		HashSet<Integer> v2cons = this.vertexConnections(v2);
		
		for (Integer i: v1cons) {
			for (Integer j: v2cons) {
				if (i.equals(j)) {
					ret = true;
					break;
				}
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
		Graph graph = new Graph(this);
		Graph mst = new Graph();
		
		// Create fully connected graph
		//for (Vertex v: vertices) {
		//	for (Vertex w: vertices) {
		//		if (!v.equals(w)) {
		//			graph.addEdge(new Edge(v, w));
		//		}
		//	}
		//}
		
		
		
		//Weigh each edge
		//simulation
		//Random r = new Random();
		//for (Edge e: graph.getEdges()) {
		//	e.setWeight(r.nextDouble());
		//}
		
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
				Graph temp = new Graph(mst, e);
				if (!mst.containsEdge(e) && !temp.isCyclic(this.vertices.size())) {	
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
	
	private boolean[] visited;
	private boolean isCyclicUtil(Vertex v, Vertex parent)
	{
	    // Mark the current node as visited
	    visited[v.getId()] = true;
	 
	    // Recur for all the vertices adjacent to this vertex
	    HashSet<Integer> cons = vertexConnections(v);
	    for (Integer i: cons)
	    {
	        // If an adjacent is not visited, then recur for that adjacent
	        if (!visited[i])
	        {
	           if (isCyclicUtil(getVertexByID(i), v))
	              return true;
	        }
	 
	        // If an adjacent is visited and not parent of current vertex,
	        // then there is a cycle.
	        else if (getVertexByID(i) != parent)
	           return true;
	    }
	    return false;
	}
	 
	// Returns true if the graph contains a cycle, else false.
	public boolean isCyclic(int size)
	{
	    // Mark all the vertices as not visited and not part of recursion
	    // stack
	    visited = new boolean[size];
	    for (int i = 0; i < size; i++)
	        visited[i] = false;
	 
	    // Call the recursive helper function to detect cycle in different
	    // DFS trees
	    for (Vertex v: vertices)
	        if (!visited[v.getId()]) // Don't recur for u if it is already visited
	          if (isCyclicUtil(v, null))
	             return true;
	 
	    return false;
	}
	
	@Override
	public String toString() {
		String value = "";
		for (Edge e: edges) {
			value += "(" + e.getV1().getId() + "," + e.getV2().getId() + "): " + e.getWeight() + "\n";
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
		Vertex v1 = new Vertex(0);
		Vertex v2 = new Vertex(1);
		Vertex v3 = new Vertex(2);
		Vertex v4 = new Vertex(3);
		Vertex v5 = new Vertex(4);
		Vertex v6 = new Vertex(5);
		g.addEdge(new Edge(v1, v2));
		g.addEdge(new Edge(v1, v3));
		g.addEdge(new Edge(v2, v4));
		g.addEdge(new Edge(v3, v5));
		g.addEdge(new Edge(v3, v6));
				
		Graph mst = g.maximumSpanningTree();
		System.out.println(mst.toString());
		System.out.println(mst.isCyclic(g.getVertices().size()));
	}
	
}
