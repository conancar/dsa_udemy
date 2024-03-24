package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GraphNode<T extends Serializable> implements Comparable<GraphNode<T>> {

	private final T value;
	private final int index;

	private boolean isVisited = false; // to prevent infinite loops while traversing

	GraphNode<T> parent; //for SSSPP solving (Single Source Shortest Path Problem)

	private ArrayList<GraphNode<T>> neighbours = new ArrayList<>(); // for linked list implementation only

	//2 properties for weighted node
	private int weight;
	private HashMap<GraphNode<T>, Integer> weightMap = new HashMap<>();

//For MST problem (minimum spanning tree)
	private DisjointSet <T> disjointSet;

	public GraphNode(T value, int index) {
		this.value = value;
		this.index = index;
		this.weight = Integer.MAX_VALUE;
	}

	public T getValue() {
		return value;
	}

	public int getIndex() {
		return index;
	}

	public ArrayList<GraphNode<T>> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<GraphNode<T>> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean visited) {
		isVisited = visited;
	}

	public GraphNode<T> getParent() {
		return parent;
	}

	public void setParent(GraphNode<T> parent) {
		this.parent = parent;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public HashMap<GraphNode<T>, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<GraphNode<T>, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	@Override
	public String toString() {
		return value.toString();
	}


	//comparable for weighted nodes
	@Override
	public int compareTo(GraphNode<T> node) {
		return this.weight - node.weight;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;

		GraphNode<?> graphNode = (GraphNode<?>) object;

		return value.equals(graphNode.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public DisjointSet<T> getDisjointSet() {
		return disjointSet;
	}

	public void setDisjointSet(DisjointSet disjointSet) {
		this.disjointSet = disjointSet;
	}
}
