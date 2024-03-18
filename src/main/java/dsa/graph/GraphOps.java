package dsa.graph;

import java.util.ArrayList;

public class GraphOps {

	/*
	 * ┌────┐        ┌────┐
	 * │ A  ├────────┤ B  ├───┐
	 * └──┬─┤        └────┘   │
	 *    │ │                 │
	 *    │ └─────┐           │
	 *    │       └─┐         └┬────┐
	 * ┌──┴─┐       ├────┐     │ E  │
	 * │ C  ├───────┤ D  ├─────┴────┘
	 * └────┘       └────┘
	 *                                ┼
	 */
	public static void main(String[] args){

		ArrayList<GraphNode<String>> nodeList=new ArrayList<>();
		nodeList.add(new GraphNode<>("A",0));
		nodeList.add(new GraphNode<>("B",1));
		nodeList.add(new GraphNode<>("C",2));
		nodeList.add(new GraphNode<>("D",3));
		nodeList.add(new GraphNode<>("E",4));


		GraphAdjacencyMatrixImpl<String> graphMatrix=new GraphAdjacencyMatrixImpl<>(nodeList);
		graphMatrix.addUndirectedEdge(0,1); //link from A to B
		graphMatrix.addUndirectedEdge(0,2);//link from A to C
		graphMatrix.addUndirectedEdge(0,3);//link from A to D
		graphMatrix.addUndirectedEdge(1,4);//link from C to E
		graphMatrix.addUndirectedEdge(4,3);//link from D to E
		graphMatrix.addUndirectedEdge(2,3);//link from C to D

		GraphAdjacencyListImpl<String> graphList=new GraphAdjacencyListImpl<>(nodeList);
		graphList.addUndirectedEdge(0,1); //link from A to B
		graphList.addUndirectedEdge(0,2);//link from A to C
		graphList.addUndirectedEdge(0,3);//link from A to D
		graphList.addUndirectedEdge(1,4);//link from C to E
		graphList.addUndirectedEdge(4,3);//link from D to E
		graphList.addUndirectedEdge(2,3);//link from C to D


	//	graphMatrix.bfs();
	//	graphList.bfs();
	 	graphMatrix.dfs(); //ADECB
	//	graphList.dfs();  //ADCBE

//		System.out.println(graphMatrix);
//
//		System.out.println(graphList);

	}
}
