package BestFirstSearch;

import java.util.ArrayList;
import java.util.Hashtable;

class Node {
	
	String value;
	int h;
	ArrayList<Edges> edges = new ArrayList<Edges>();
	
	Node(String v, int h) {
		this.value = v;
		this.h = h;
	}
}

class Edges {
	
	Node j;
	int w;
	
	Edges (Node jj, int ww){
		this.j = jj;
		this.w = ww;
	}
	
}

public class AStar {
	
	static ArrayList<Node> graph = new ArrayList<Node>();
	static Hashtable<String, Integer> hValue = new Hashtable<>();
	 
	public static void addNode(Node n) {
		graph.add(n);
	}
	
	void setEdge(Node n1, Node n2, int w) {
		
		if (n1.edges.contains(n2)==false) {
			Edges e = new Edges (n2,w);
			n1.edges.add(e);
		}
		
//		if (n2.edges.contains(n1)==false) {
//			Edges e = new Edges (n1,w);
//			n2.edges.add(e);
//		}
	}

	public static Node getNode(String n) {
		Node res = null;
		for(int i=0; i<graph.size(); i++) {
			if(graph.get(i).value == n)
				res = graph.get(i);
		}
		return res;
	}
	
	public static ArrayList<Edges> getEdges (Node n) {
		int i = graph.indexOf(n);
		ArrayList<Edges> nn = graph.get(i).edges;
		return nn;
	}
	
	public static void printEdges (Node n) {
		for (Edges x : n.edges ) {
			System.out.print(x.j.value+"("+x.w+")"+" ");
		}
	}
	
	public static void printEdges (ArrayList<Edges>  n) {
		for (Edges x : n ) {
			System.out.print(x.j.value+"("+x.w+")"+" ");
		}
	}
	
	
	public static void printGraphNodes() {
		
		for (int i=0; i<graph.size(); i++) {
			System.out.print(graph.get(i).value+" ");
		}
	}
	
	public static boolean containNode (String n) {
		
		boolean res = false;
		for (Node x : graph) {
			if(x.value == n)
				res = true;
		}
		return res;
	}
	
	public void search(String n1, String n2) {
		
		if(containNode(n1) && containNode(n2)) {
			Node node = getNode(n1);
			ArrayList<Edges> e = getEdges(node);
			
			printEdges(e);
			
		}
		else {
			System.out.println("One of the nodes is not in the graph");
		}
		
	}
	
	public void expandRoutes (ArrayList<Edges> e) {
		
		
		
	}
	
	public int hFunction(Edges e,  int h) {
		
		int res = 0;
		res = e.w+h;
		return res;
	}
	

	
	public void createGraph() {
		
		AStar graph = new AStar();
		
		Node s = new Node("S",0);
		Node a = new Node("A",5);
		Node b = new Node("B",6);
		Node c = new Node("C",4);
		Node d = new Node("D",15);
		Node e = new Node("E",0);
		Node x = new Node("X",5);
		Node y = new Node("Y",8);
	
		graph.addNode(s);
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
		graph.addNode(x);
		graph.addNode(y);
		
		//edges for s
		graph.setEdge(s,a,1);
		graph.setEdge(s,b, 2);
		
		//edges for a
		graph.setEdge(a,s,1);
		graph.setEdge(a,x,4);
		graph.setEdge(a,y,7);
		
		//edges for b
		graph.setEdge(b,s,2);
		graph.setEdge(b,c,7);
		graph.setEdge(b,d,1);
		
		//edges for c
		graph.setEdge(c,b,7);
		graph.setEdge(c,e,5);
		
		//edges for d
		graph.setEdge(d,b,1);
		graph.setEdge(d,e,12);
		
		//edges for e
		graph.setEdge(e,c,5);
		graph.setEdge(e,d,12);
		graph.setEdge(e,x,2);
		graph.setEdge(e,y,3);
		
		//edges for x
		graph.setEdge(x,a,4);
		graph.setEdge(x,e,2);
		
		//edges for y
		graph.setEdge(y,a,7);
		graph.setEdge(y,e,3);
		
	}
	
	public static void hValue() {
		hValue.put("A",5);
		hValue.put("B",6);
		hValue.put("C",4);
		hValue.put("D",15);
		hValue.put("X",5);
		hValue.put("Y",8);
		 
	}

	public static void main(String[] args) {
		
		AStar graph = new AStar();
		
		graph.createGraph();
		System.out.println("Graph nodes : ");
		graph.printGraphNodes();
		
		System.out.println("\nNode S edges : ");
		printEdges(graph.graph.get(0));
		
		System.out.println("\nNode A edges : ");
		printEdges(graph.graph.get(1));
		
		System.out.println("\nNode X edges : ");
		printEdges(graph.graph.get(6));
		
		System.out.println("\nNode Y edges : ");
		ArrayList<Edges> yE = getEdges (getNode("Y"));
		printEdges(yE);
		
		hValue();
		
//		Node a = graph.graph.get(1);
//		System.out.println(a.value);
		System.out.println("\n==Search==");
		graph.search("S","E");

	
		

	}

}
