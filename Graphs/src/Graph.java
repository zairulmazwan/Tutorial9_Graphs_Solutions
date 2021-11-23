import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph {
	
	private Map<Vertex, List<Vertex>> adjVertices;
	 
	class Vertex {
	    String label;
	    
	    Vertex(String label) {
	        this.label = label;
	    }

	    // equals and hashCode
	}
	
	
	static Graph createGraph() {
		/*
	    Graph graph = new Graph();
	    graph.addVertex("Zairul");
	    graph.addVertex("Rania");
	    graph.addVertex("Mazwan");
	    graph.addVertex("Mehmet");
	    graph.addVertex("Swift");
	    graph.addEdge("Zairul", "Mazwan");
	    graph.addEdge("Mazwan", "Swift");
	    graph.addEdge("Jilani", "Mazwan");
	    graph.addEdge("Rania", "Mehmet");
	    graph.addEdge("Mehmet", "Jilani");
	    graph.addEdge("Swift", "Rania");
	    return graph;
	    */
		Graph graph = new Graph();
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    return graph;
	}
	
	public void addVertex(String label) {
	    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}
	
	public void removeVertex(String label) {
	    Vertex v = new Vertex(label);
	    adjVertices.values().stream().forEach(e -> e.remove(v));
	    adjVertices.remove(new Vertex(label));
	}
	
	public void addEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    adjVertices.get(v1).add(v2);
	    adjVertices.get(v2).add(v1);
	}
	
	public void removeEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    List<Vertex> eV1 = adjVertices.get(v1);
	    List<Vertex> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	
	public List<Vertex> getAdjVertices(String label) {
	    return adjVertices.get(new Vertex(label));
	}
	
	static Set<String> depthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Vertex v : graph.getAdjVertices(vertex)) {              
	                stack.push(v.label);
	            }
	        }
	    }
	    return visited;
	}

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		graph = createGraph();
		//assertEquals("[Bob, Rob, Maria, Alice, Mark]", depthFirstTraversal(graph, "Bob").toString());
		depthFirstTraversal(graph, "Bob").toString();
		

	}

	private static void assertEquals(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
