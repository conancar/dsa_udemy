package dsa.graph;

import java.io.Serializable;

public class UndirectedEdge<T extends Serializable> {

	private GraphNode<T> first;
	private GraphNode<T> second;

	private int weight;

	public UndirectedEdge(GraphNode<T> first, GraphNode<T> second,int weight) {
		this.first = first;
		this.second = second;
		this.weight=weight;
	}

	public GraphNode<T> getFirst() {
		return first;
	}

	public void setFirst(GraphNode<T> first) {
		this.first = first;
	}

	public GraphNode<T> getSecond() {
		return second;
	}

	public void setSecond(GraphNode<T> second) {
		this.second = second;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
