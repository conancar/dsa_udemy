package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
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

	public void addDirectedEdge(int indexOfParentNode,int indexOfChildNode) {
		adjacencyMatrix[indexOfParentNode][indexOfChildNode] = 1;
	}

	public void addWeightedEdge(int indexOfParentNode,int indexOfChildNode,int weight){
		adjacencyMatrix[indexOfParentNode][indexOfChildNode] = 1;

		GraphNode<T> parent=nodeList.get(indexOfParentNode);
		GraphNode<T> child=nodeList.get(indexOfChildNode);
		parent.getWeightMap().put(child,weight);
	}


	private void topologicalVisit(GraphNode<T> graphNode,Stack<GraphNode<T>> stack){
		for (GraphNode<T> neighbour : getNeighbours(graphNode)) {
			if(!neighbour.isVisited()){
				topologicalVisit(neighbour,stack);
			}
		}
		graphNode.setVisited(true);
		stack.push(graphNode);
	}

	public void topologicalSort(){
		Stack<GraphNode<T>> stack=new Stack<>();
		for (GraphNode<T> graphNode : nodeList) {
			if(!graphNode.isVisited()) {
				topologicalVisit(graphNode, stack);
			}
		}

		//just for printing topologically sorted graph
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getValue().toString()+" ");
		}
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

	public void BFSforSSSPP(GraphNode<T> graphNode){
		LinkedList<GraphNode<T>> queue=new LinkedList<>();
		queue.add(graphNode);
		while (!queue.isEmpty()){
			GraphNode<T> currentNode=queue.remove(0);
			currentNode.setVisited(true);
			System.out.print("Printing path for node"+currentNode.getValue() + ": ");
			pathPrint(currentNode);
			System.out.println();

			for (GraphNode<T> neighbour : getNeighbours(currentNode)) {
				if(!neighbour.isVisited()){
					queue.add(neighbour);
					neighbour.setVisited(true);
					neighbour.setParent(currentNode); //setting parent
				}
			}
		}
	}

	//for SSSPP
	public void pathPrint(GraphNode<T> graphNode){
		if(graphNode.getParent()!=null){
			pathPrint(graphNode.getParent());
		}
		System.out.print(graphNode.getValue()+" ");
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


	public void dijkstra(GraphNode<T> graphNode){
		PriorityQueue<GraphNode<T>> queue=new PriorityQueue<>();
		graphNode.setWeight(0);
		queue.addAll(nodeList);

		while (!queue.isEmpty()){
			GraphNode<T> currentNode=queue.remove();
			for(GraphNode<T> neighbour: getNeighbours(currentNode)){
				if(queue.contains(neighbour)){ //nije jos obradjen
					if(neighbour.getWeight()>currentNode.getWeight()+currentNode.getWeightMap().get(neighbour)){
						neighbour.setWeight(currentNode.getWeight()+currentNode.getWeightMap().get(neighbour));
						neighbour.setParent(currentNode);
						queue.remove(neighbour);
						queue.add(neighbour);
					}
				}
			}
		}

		for (GraphNode<T> node : nodeList) {
			System.out.print("Node " + node+ ", weight = "+node.getWeight()+ " Path:" );
			pathPrint(node);
			System.out.println();
		}

	}

	// Bellman Ford Algorithm similar to dijekstra but can catch negative cycles
	void bellmanFord(GraphNode<T> graphNode) {
		graphNode.setWeight(0);
		for (int i=0; i<nodeList.size(); i++) {
			for (GraphNode<T> currentNode : nodeList) {
				for (GraphNode<T> neighbor : getNeighbours(currentNode)) {
					if(neighbor.getWeight() > currentNode.getWeight() + currentNode.getWeightMap().get(neighbor)) {
						neighbor.setWeight(currentNode.getWeight()+currentNode.getWeightMap().get(neighbor));
						neighbor.parent = currentNode;
					}
				}
			}
		}
		System.out.println("Checking for Negative Cycle..");
		for (GraphNode<T> currentNode : nodeList) {
			for (GraphNode<T> neighbor : getNeighbours(currentNode) ) {
				if(neighbor.getWeight() > currentNode.getWeight() + currentNode.getWeightMap().get(neighbor)) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex name: " + neighbor.getValue());
					System.out.println("Old cost: " + neighbor.getWeight());
					int newDistance = currentNode.getWeight() + currentNode.getWeightMap().get(neighbor);
					System.out.println("new cost: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative Cycle not found");

		for (GraphNode<T> nodeToCheck : nodeList) {
			System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.getWeight()+", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}


	//Used for All Pair Shortest Path Problem
	void floydWarshall() {
		int size = nodeList.size();
		int[][] V = new int[size][size];

		// Initializing Distance table from adjacency list
		for (int i = 0; i < size; i++) {
			GraphNode<T>  first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				GraphNode<T>  second = nodeList.get(j);
				if (i == j)
					V[i][j] = 0;
				else if (first.getWeightMap().containsKey(second)) { //we have direct edge between i & j
					V[i][j] = first.getWeightMap().get(second);
				} else { //no direct edge between i & j, so mark it as infinity [divided by 10 to avoid arithmetic overflow]
					V[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}//end of loop


		// Floyd Warshall's Algorithm
		for (int k = 0; k < nodeList.size(); k++) {
			for (int i = 0; i < nodeList.size(); i++) {
				for (int j = 0; j < nodeList.size(); j++) {
					if (V[i][j] > V[i][k] + V[k][j]) {  // if update possible, then update path
						V[i][j] = V[i][k] + V[k][j];    // this will keep a track on path
					}
				}
			}
		}//end of loop


		// Print table of node with minimum distance and shortest path from each source
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node "+nodeList.get(i)+": ");
			for (int j = 0; j < size; j++) {
				System.out.print(V[i][j]+" ");
			}
			System.out.println();
		}

	}// end of method


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
