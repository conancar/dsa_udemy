package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;

public class GraphNode<T extends Serializable> {

	private final T value;
	private final int index;

	private ArrayList<GraphNode<T>> neighbours=new ArrayList<>(); // for linked list implementation only

	public GraphNode(T value, int index) {
		this.value = value;
		this.index = index;
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
}
