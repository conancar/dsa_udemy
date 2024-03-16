package dsa.graph;

import java.io.Serializable;
import java.util.ArrayList;

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
