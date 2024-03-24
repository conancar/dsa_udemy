package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;

//Used for roads, realways city connections,traveling salesman problem, AI pathfinding
public class Prims<T extends Serializable> {

	ArrayList<GraphNode<T>> nodeList = new ArrayList<GraphNode<T>>();

	//Constructor
	public Prims(ArrayList<GraphNode<T>> nodeList) {
		this.nodeList = nodeList;
	}//end of method


	// Prim's algorithm from source node
	void prims(GraphNode<T> node) {
		for (int counter = 0; counter < nodeList.size(); counter++) {
			nodeList.get(counter).setWeight(Integer.MAX_VALUE);
		}
		node.setWeight(0); // Setting '0' distance for Source Vertex


		PriorityQueue<GraphNode<T>> queue = new PriorityQueue<>();

		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			GraphNode<T> presentNode = queue.remove(); // Remove vertex which has min distance


			for (GraphNode<T> neighbor : presentNode.getNeighbours()) {
				if (queue.contains(neighbor)) {//If vertex is not processed, only then enter in if-else
					//If known weight of this �adjacent vertex� is more than current edge,
					//then update �adjacent vertex�s� distance and parent
					if (neighbor.getWeight() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setWeight(presentNode.getWeightMap().get(neighbor));
						neighbor.parent = presentNode;
						queue.remove(neighbor); // Refresh the priority queue
						queue.add(neighbor);
					}//end of if-else
				}//end of if-else
			}//end of for loop
		}//end of while loop

		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		for (GraphNode<T> nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getWeight() + ", Parent: " + nodeToCheck.parent);
			cost = cost + nodeToCheck.getWeight();
		}//end of for loop

		System.out.println("\nTotal cost of MST: " + cost);
	}//end of method


	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		GraphNode<T> first = nodeList.get(i);
		GraphNode<T> second = nodeList.get(j);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
		first.getWeightMap().put(second,d);
		second.getWeightMap().put(first, d);
	}//end of method
}
