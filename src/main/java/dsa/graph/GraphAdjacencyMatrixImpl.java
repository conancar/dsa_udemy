package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;

public class GraphAdjacencyMatrixImpl<T extends Serializable> {

	ArrayList<GraphNode<T>> nodeList=new ArrayList<>();

	int[][] adjacencyMatrix;


	public GraphAdjacencyMatrixImpl(ArrayList<GraphNode<T>> nodeList) {
		this.nodeList = nodeList;
		//size of matrix is equal to number of nodes
		adjacencyMatrix =new int[nodeList.size()][nodeList.size()];
	}

	public void addUndirectedEdge(int indexOfNodeA,int indexOfNodeB){
		//since undirected both connections are created. Also for weighted 1 instead of weight value
		adjacencyMatrix[indexOfNodeA][indexOfNodeB]=1;
		adjacencyMatrix[indexOfNodeB][indexOfNodeA]=1;

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
