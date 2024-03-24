package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Used for landing cables, tv networks, water and gas pipes...
public class Kruskal<T extends Serializable> {

	ArrayList<GraphNode<T>> nodeList = new ArrayList<GraphNode<T>>();
	ArrayList<UndirectedEdge<T>> edgeList = new ArrayList<UndirectedEdge<T>>();

	public Kruskal(ArrayList<GraphNode<T>> nodeList) {
		this.nodeList = nodeList;
	}

	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge<T> edge = new UndirectedEdge<T>(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
		GraphNode<T> first = edge.getFirst();
		GraphNode<T> second = edge.getSecond();
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
		edgeList.add(edge);
	}

	void kruskal() {
		DisjointSet<T> disjointSet=new DisjointSet();
		disjointSet.makeSet(nodeList);
		Comparator<UndirectedEdge<T>> comparator = new Comparator<UndirectedEdge<T>>() {
			@Override
			public int compare(UndirectedEdge<T> o1, UndirectedEdge<T> o2) {
				return o1.getWeight() - o2.getWeight();
			}
		};

		Collections.sort(edgeList, comparator);
		int cost = 0;
		for (UndirectedEdge<T> edge : edgeList) {
			GraphNode<T> first = edge.getFirst();
			GraphNode<T> second = edge.getSecond();
			if (!disjointSet.findSet(first).equals(disjointSet.findSet(second))) {
				disjointSet.union(first, second);
				cost += edge.getWeight();
				System.out.println("Taken " + edge);
			}
		}

		System.out.println("\nTotal cost of MST: " + cost);

	}
}
