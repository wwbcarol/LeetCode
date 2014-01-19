package graph;

import java.util.ArrayList;

/**
 * Definition for undirected graph.
 * */
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class CloneGraph {

	public static void main(String[] args) {
		UndirectedGraphNode n1 = new UndirectedGraphNode(-1);
		n1.neighbors.add(n1);
		n1.neighbors.add(n1);
		CloneGraph a = new CloneGraph();
		UndirectedGraphNode clone = a.cloneGraph(n1);
		System.out.println(clone.label);
		System.out.println(clone.neighbors.size());
	}
	
	public static ArrayList<UndirectedGraphNode> nodeSet = new ArrayList<UndirectedGraphNode>();
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		nodeSet.clear();
		return cloneGraphHelp(node);
	}
	public UndirectedGraphNode cloneGraphHelp(UndirectedGraphNode node) {
		if (node == null)
			return null;
//		System.out.println(nodeSet.size());
		for (UndirectedGraphNode nodelist : nodeSet) {
			if(nodelist.label == node.label){
				
				return nodelist;
			}
		}
		
		UndirectedGraphNode n = new UndirectedGraphNode(node.label);
		nodeSet.add(n);
		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode neighbors = cloneGraphHelp(node.neighbors.get(i));
			n.neighbors.add(neighbors);
		}
		
		return n;
		
		
	}

}
