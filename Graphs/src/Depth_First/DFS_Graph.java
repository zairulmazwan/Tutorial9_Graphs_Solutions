package Depth_First;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	
	int value;
	ArrayList<Node> edges = new ArrayList<Node>();
	
	Node(int v) {
		this.value = v;
	}
}

public class DFS_Graph {
	
	static ArrayList<Node> dfs = new ArrayList<Node>();
	
	public static void addNode(Node n) {
		dfs.add(n);
	}
	
	void setEdge(Node n1, Node n2) {
		
		if (n1.edges.contains(n2)==false) {
			n1.edges.add(n2);
		}
		
		if (n2.edges.contains(n1)==false) {
			n2.edges.add(n1);
		}
	}

	public static Node getNode(int n) {
		Node res = null;
		for(int i=0; i<dfs.size(); i++) {
			if(dfs.get(i).value == n)
				res = dfs.get(i);
		}
		return res;
	}
	
	public static ArrayList<Node> getEdges (Node n) {
		int i = dfs.indexOf(n);
		ArrayList<Node> nn = dfs.get(i).edges;
		return nn;
	}
	
	public static void printEdges (Node n) {
		for (Node x : n.edges ) {
			System.out.print(x.value+" ");
		}
	}
	
	public static void printGraphNodes() {
		
		for (int i=0; i<dfs.size(); i++) {
			System.out.print(dfs.get(i).value+" ");
		}
	}
	
	public static boolean containNode (int n) {
		
		boolean res = false;
		for (Node x : dfs) {
			if(x.value == n)
				res = true;
		}
		return res;
	}
	
	public static void traverseBFS(int nodeValue) {
		
		if (containNode(nodeValue)) {
			
			Node firstNode = getNode(nodeValue);
			
			Queue<Node> nodes = new LinkedList();
			nodes.add(firstNode);
			
			ArrayList<Node> visited = new ArrayList<Node>();
			
			while (!nodes.isEmpty()) {
				Node n = nodes.remove();
				
				if (!visited.contains(n)) {
					System.out.print(n.value+" ");
					visited.add(n);
					ArrayList<Node> edges = getEdges(n);
					for (int i=0; i<edges.size(); i++) {
						nodes.add(edges.get(i));
					}
				}
			}
		}
		else {
			System.out.println("There is no node "+nodeValue);
		}
	}
	
	
	public static ArrayList<Node> DFS (int nodeValue, ArrayList<Node> visited) {
		
		if (containNode(nodeValue)) {
			Node firstNode = getNode(nodeValue);
			//System.out.print(firstNode.value+" ");
			if(visited.isEmpty()) visited.add(firstNode);
			
			for (int i=0; i<firstNode.edges.size(); i++) {
				if (!visited.contains(firstNode.edges.get(i))) {
					visited.add(firstNode.edges.get(i));
					DFS (firstNode.edges.get(i).value, visited);
				}
			}
		}
		else {
			System.out.println("There is no node "+nodeValue);
		}
		return visited;
	}
	
	public static void traverseDFS(int nodeValue) {
		
		if (containNode(nodeValue)) {
			
			Node firstNode = getNode(nodeValue);
			
			ArrayList<Node> nodes = new ArrayList<Node>();
			nodes.add(firstNode);
			
			ArrayList<Node> visited = new ArrayList<Node>();
			
			while (!nodes.isEmpty()) {
				Node n = nodes.get(nodes.size()-1);
				nodes.remove(nodes.size()-1);
				
				if (!visited.contains(n)) {
					System.out.print(n.value+" ");
					visited.add(n);
					ArrayList<Node> edges = getEdges(n);
					for (int i=0; i<edges.size(); i++) {
						nodes.add(edges.get(i));
					}
				}
			}
		}
		else {
			System.out.println("There is no node "+nodeValue);
		}
	}
	
	public void createGraph() {
		
		DFS_Graph graph = new DFS_Graph();
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		Node i = new Node(9);
		
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
		graph.addNode(f);
		graph.addNode(g);
		graph.addNode(h);
		graph.addNode(i);
		
		//edges for a
		graph.setEdge(a,b);
		graph.setEdge(a,h);
		
		//edges for b
		graph.setEdge(b,c);
		graph.setEdge(b,h);
		
		//edges for c
		graph.setEdge(c,d);
		graph.setEdge(c,h);
		
		//edges for d
		graph.setEdge(d,c);
		graph.setEdge(d,g);
		graph.setEdge(d,i);
		
		//edges for e
		graph.setEdge(e,f);
		graph.setEdge(e,g);
		
		//edges for f
		graph.setEdge(f,e);

		
		//edges for g
		graph.setEdge(g,d);
		graph.setEdge(g,h);
		
		//edges for h
		graph.setEdge(h,a);
		graph.setEdge(h,b);
		graph.setEdge(h,c);
		graph.setEdge(h,g);
				
		//edges for i
		graph.setEdge(i,d);
	

		
//		Node a = new Node(10);
//		Node b = new Node(20);
//		Node c = new Node(30);
//		Node d = new Node(40);
//		Node e = new Node(50);
//		Node f = new Node(60);
//		
//		graph.addNode(a);
//		graph.addNode(b);
//		graph.addNode(c);
//		graph.addNode(d);
//		graph.addNode(e);
//		graph.addNode(f);
//		
//		//edges for a
//		graph.setEdge(a,b);
//		graph.setEdge(a,e);
//		
//		//edges for b
//		graph.setEdge(b,a);
//		graph.setEdge(b,c);
//		graph.setEdge(b,f);
//		
//		//edges for c
//		graph.setEdge(c,b);
//		graph.setEdge(c,d);
//		graph.setEdge(c,e);
//		
//		//edges for d
//		graph.setEdge(d,c);
//		
//		//edges for e
//		graph.setEdge(e,a);
//		graph.setEdge(e,c);
//		
//		//edges for f
//		graph.setEdge(f,b);
		
	}
	
	public static void printNodes (ArrayList<Node> n) {
		for(Node x : n) {
			System.out.print(x.value+" ");
		}
	}


	public static void main(String[] args) {
		
		DFS_Graph graph = new DFS_Graph();
		graph.createGraph();
		
		System.out.println("Number of nodes in the graph : "+dfs.size());
		System.out.println("Nodes in the graph are : ");
		printGraphNodes();

		System.out.println("\nThe graph contains 60 ? : "+graph.containNode(60));
		System.out.println("\nEdges in 10 : ");
		printEdges(dfs.get(0));
		
		System.out.println("\nEdges in 20 : ");
		printEdges(dfs.get(1));
		
		System.out.println("\nEdges in 30 : ");
		printEdges(dfs.get(2));
		
		System.out.println("\nEdges in 40 : ");
		printEdges(dfs.get(3));
		
		System.out.println("\nEdges in 50 : ");
		printEdges(dfs.get(4));
		
		System.out.println("\nDFS Traverse starts from node 50 : ");
		traverseDFS(1);
		
		System.out.println("\nBFS Traverse starts from node 50 : ");
		traverseBFS(4);
		
		System.out.println("\nDFS Traverse starts from node 50 xx : ");
		ArrayList<Node> visited = new ArrayList<Node>();
		visited = DFS(1,visited);
		
		printNodes(visited);
		

	}

}
