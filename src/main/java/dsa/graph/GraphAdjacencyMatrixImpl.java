package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyMatrixImpl<T extends Serializable> {

	ArrayList<GraphNode<T>> nodeList;

	int[][] adjacencyMatrix;


	public GraphAdjacencyMatrixImpl(ArrayList<GraphNode<T>> nodeList) {
		this.nodeList = nodeList;
		//size of matrix is equal to number of nodes
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}

	public void addUndirectedEdge(int indexOfNodeA, int indexOfNodeB) {
		//since undirected both connections are created. Also for weighted 1 instead of weight value
		adjacencyMatrix[indexOfNodeA][indexOfNodeB] = 1;
		adjacencyMatrix[indexOfNodeB][indexOfNodeA] = 1;

	}


	private ArrayList<GraphNode<T>> getNeighbours(GraphNode<T> graphNode) {

		ArrayList<GraphNode<T>> neighbours = new ArrayList<>();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[graphNode.getIndex()][i] != 0) {
				neighbours.add(nodeList.get(i));
			}
		}
		return neighbours;
	}

	//BreadthFirstSearch (BFS) helper use queue
	private void bfsVisit(GraphNode<T> graphNode){
		LinkedList<GraphNode<T>> queue=new LinkedList<>();
		queue.add(graphNode);
		while (!queue.isEmpty()){
			GraphNode<T> currentNode=queue.remove(0);
			currentNode.setVisited(true);
			System.out.println("Visited node "+currentNode);
			ArrayList<GraphNode<T>> neighbours=getNeighbours(currentNode);
			for (GraphNode<T> neighbour : neighbours) {
				if(!neighbour.isVisited()){
					queue.add(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}


	//DepthFirstSearch (DFS) helper, stack use
	private void dfsVisit(GraphNode<T> graphNode){
		Stack<GraphNode<T>>stack=new Stack<>();
		stack.push(graphNode);
		while(!stack.isEmpty()){
			final GraphNode<T> currentNode = stack.pop();
			currentNode.setVisited(true);
			System.out.println("Visited node "+currentNode);
			ArrayList<GraphNode<T>> neighbours=getNeighbours(currentNode);
			for (GraphNode<T> neighbour : neighbours) {
				if(!neighbour.isVisited()){
					stack.push(neighbour);
					neighbour.setVisited(true);
				}
			}

		}
	}

	public void bfs(){
		for (GraphNode<T> graphNode : nodeList) {
			if(!graphNode.isVisited()){
				bfsVisit(graphNode);
			}
		}
	}

	public void dfs(){
		for (GraphNode<T> graphNode : nodeList) {
			if(!graphNode.isVisited()){
				dfsVisit(graphNode);
			}
		}

	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("   ");
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).getValue() + " ");
		}
		s.append("\n");
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).getValue() + ": ");
			for (int j : adjacencyMatrix[i]) {
				s.append((j) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
}
