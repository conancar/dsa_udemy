package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyListImpl<T extends Serializable> {

	ArrayList<GraphNode<T>> nodeList=new ArrayList<>();

	public GraphAdjacencyListImpl(ArrayList<GraphNode<T>> nodeList) {
		this.nodeList = nodeList;
	}

	public void addUndirectedEdge(int indexOfNodeA,int indexOfNodeB){
		//since undirected both connections are created. For weighted add weight property to node
		GraphNode<T> nodeA=nodeList.get(indexOfNodeA);
		GraphNode<T> nodeB=nodeList.get(indexOfNodeB);

		nodeA.getNeighbours().add(nodeB);
		nodeB.getNeighbours().add(nodeA);

	}


	private void bfsHelper(GraphNode<T> graphNode){
		LinkedList<GraphNode<T>> queue=new LinkedList<>();
		queue.add(graphNode);
		while (!queue.isEmpty()){
			GraphNode<T> currentNode=queue.remove(0);
			currentNode.setVisited(true);
			System.out.println("Visited node List"+currentNode);

			for (GraphNode<T> neighbour : graphNode.getNeighbours()) {
				if(!neighbour.isVisited()){
					queue.add(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}

	private void dfsHelper(GraphNode<T> graphNode){
		Stack<GraphNode<T>> stack=new Stack<>();
		stack.push(graphNode);
		while (!stack.isEmpty()){
			GraphNode<T> currentNode=stack.pop();
			currentNode.setVisited(true);
			System.out.println("Visited node List"+currentNode);

			for (GraphNode<T> neighbour : graphNode.getNeighbours()) {
				if(!neighbour.isVisited()){
					stack.push(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}

	public void bfs(){
		for (GraphNode<T> graphNode : nodeList) {
			if (!graphNode.isVisited()){
				bfsHelper(graphNode);
			}
		}
	}

	public void dfs(){
		for (GraphNode<T> graphNode : nodeList) {
			if (!graphNode.isVisited()){
				dfsHelper(graphNode);
			}
		}
	}

	// For printing Graph to the console

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).getValue() + ": ");
			for (int j =0; j < nodeList.get(i).getNeighbours().size(); j++) {
				if (j == nodeList.get(i).getNeighbours().size()-1 ) {
					s.append((nodeList.get(i).getNeighbours().get(j).getValue()) );
				} else {
					s.append((nodeList.get(i).getNeighbours().get(j).getValue()) + " -> ");
				}
			}
			s.append("\n");
		}
		return s.toString();
	}

}
