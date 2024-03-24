package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;


//Used in MST problem solved by Prims and Kruskal algorithms
public class DisjointSet<T extends Serializable>  {

	private ArrayList<GraphNode<T>> nodeList = new ArrayList<>();

	public void makeSet(ArrayList<GraphNode<T>> nodeList) {
		for (GraphNode<T> node : nodeList) {
			DisjointSet<T> set = new DisjointSet();
			set.nodeList.add(node);
			node.setDisjointSet(set);
		}
	}

	public  DisjointSet<T> findSet(GraphNode<T> node) {
		return node.getDisjointSet();
	}

	public  DisjointSet<T> union(GraphNode<T> node1, GraphNode<T> node2) {
		if (node1.getDisjointSet().equals(node2.getDisjointSet())) {
			return null;
		} else {
			DisjointSet<T> set1 = node1.getDisjointSet();
			DisjointSet<T> set2 = node2.getDisjointSet();

			if (set1.nodeList.size()>set2.nodeList.size()) {
				ArrayList<GraphNode<T>> nodeSet2 = set2.nodeList;
				for (GraphNode<T> node: nodeSet2) {
					node.setDisjointSet(set1);
					set1.nodeList.add(node);
				}
				return set1;
			} else {
				ArrayList<GraphNode<T>> nodeSet1 = set1.nodeList;
				for (GraphNode<T> node : nodeSet1) {
					node.setDisjointSet(set2);
					set2.nodeList.add(node);
				}
				return set2;
			}
		}
	}

	public void printAllNodesofThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for (GraphNode<T> node : nodeList ) {
			System.out.print(node + " ");
		}
		System.out.println();
	}
}
