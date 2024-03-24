package dsa.graph;

import java.util.ArrayList;

public class GraphOps {


	public static void main(String[] args) {

		//directed();
		//undirected();
		weighted();
	}

	/*
	 *        ┌───┐       ┌───┐
	 *        │ A │       │B  │
	 *        └──┬┘       ├───┴┐
	 *           │        │    │
	 *           │    ┌───┘    │
	 *           │    │        │
	 *         ┌─▼─┐  │     ┌──▼┐
	 *         │ C │◄─┘  ┌──┤ D │
	 *         ├───┘     │  └───┘
	 *         │         │
	 *         │         │
	 *         │         │
	 *       ┌─▼─┐       │
	 *   ┌───┤ E ├─────┐ │
	 *   │   └───┘     │ │
	 *   │             │ │
	 *   │             │ │
	 * ┌─▼─┐           │ ▼         ┌───┐
	 * │H  │          ┌▼──┐        │ G │
	 * └───┘          │F  ├───────►└───┘
	 *                └───┘
	 */
	private static void directed() {
		ArrayList<GraphNode<String>> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode<>("A", 0));
		nodeList.add(new GraphNode<>("B", 1));
		nodeList.add(new GraphNode<>("C", 2));
		nodeList.add(new GraphNode<>("D", 3));
		nodeList.add(new GraphNode<>("E", 4));
		nodeList.add(new GraphNode<>("H", 5));
		nodeList.add(new GraphNode<>("F", 6));
		nodeList.add(new GraphNode<>("G", 7));


		GraphAdjacencyMatrixImpl<String> graphMatrix = new GraphAdjacencyMatrixImpl<>(nodeList);
		graphMatrix.addDirectedEdge(0, 2);
		graphMatrix.addDirectedEdge(2, 4);
		graphMatrix.addDirectedEdge(4, 5);
		graphMatrix.addDirectedEdge(4, 6);
		graphMatrix.addDirectedEdge(6, 7);
		graphMatrix.addDirectedEdge(1, 2);
		graphMatrix.addDirectedEdge(1, 3);
		graphMatrix.addDirectedEdge(3, 6);

		GraphAdjacencyListImpl<String> graphList = new GraphAdjacencyListImpl<>(nodeList);
		graphList.addDirectedEdge(0, 2);
		graphList.addDirectedEdge(2, 4);
		graphList.addDirectedEdge(4, 5);
		graphList.addDirectedEdge(4, 6);
		graphList.addDirectedEdge(6, 7);
		graphList.addDirectedEdge(1, 2);
		graphList.addDirectedEdge(1, 3);
		graphList.addDirectedEdge(3, 6);


		//	graphMatrix.bfs();
		//	graphList.bfs();
		//	graphMatrix.dfs(); //ADECB
		//	graphList.dfs();  //ADCBE

		System.out.println(graphMatrix);
//
		//	System.out.println(graphList);

		//	graphList.topologicalSort();

		graphMatrix.topologicalSort();
	}


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
	private static void undirected() {
		ArrayList<GraphNode<String>> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode<>("A", 0));
		nodeList.add(new GraphNode<>("B", 1));
		nodeList.add(new GraphNode<>("C", 2));
		nodeList.add(new GraphNode<>("D", 3));
		nodeList.add(new GraphNode<>("E", 4));


		GraphAdjacencyMatrixImpl<String> graphMatrix = new GraphAdjacencyMatrixImpl<>(nodeList);
		graphMatrix.addUndirectedEdge(0, 1); //link from A to B
		graphMatrix.addUndirectedEdge(0, 2);//link from A to C
		graphMatrix.addUndirectedEdge(0, 3);//link from A to D
		graphMatrix.addUndirectedEdge(1, 4);//link from C to E
		graphMatrix.addUndirectedEdge(4, 3);//link from D to E
		graphMatrix.addUndirectedEdge(2, 3);//link from C to D

		GraphAdjacencyListImpl<String> graphList = new GraphAdjacencyListImpl<>(nodeList);
		graphList.addUndirectedEdge(0, 1); //link from A to B
		graphList.addUndirectedEdge(0, 2);//link from A to C
		graphList.addUndirectedEdge(0, 3);//link from A to D
		graphList.addUndirectedEdge(1, 4);//link from C to E
		graphList.addUndirectedEdge(4, 3);//link from D to E
		graphList.addUndirectedEdge(2, 3);//link from C to D


		//	graphMatrix.bfs();
		//	graphList.bfs();
		//graphMatrix.dfs(); //ADECB
		//	graphList.dfs();  //ADCBE

//		System.out.println(graphMatrix);
//
		//graphList.BFSforSSSPP(nodeList.get(0));
		graphMatrix.BFSforSSSPP(nodeList.get(0));

		//	System.out.println(graphList);
		//	graphList.pathPrint(nodeList.get(0));
	}


	/*
	 *           ┌───┐             3    ┌───┐
	 *           │ B ├─────────┬───────►│E  ├────────────┐
	 *   ┌──────►└───┤         │        └───┘            │
	 *  2│           │        1│        ▲                │
	 *   │           │         ▼        │                │ 9
	 *   │           │         ┌───┐    │4               │
	 * ┌─┴─┐         │         │ D ├────┘                │
	 * │ A │         │         └───┘                     │
	 * └──┬┘         │                                  ┌▼──┐
	 *    │         6│                                  │ G │
	 *    │          │                                  └───┘
	 *    │          │                                  ▲
	 *  5 │          │                                  │
	 *    │          │                                  │
	 *    │          ▼                                  │
	 *    │         ┌───┐                 ┌───┐         │ 7
	 *    └────────►│ C ├────────────────►│ F ├─────────┘
	 *              └───┘      8          └───┘
	 */
	private static void weighted() {
		ArrayList<GraphNode<String>> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode<>("A", 0));
		nodeList.add(new GraphNode<>("B", 1));
		nodeList.add(new GraphNode<>("C", 2));
		nodeList.add(new GraphNode<>("D", 3));
		nodeList.add(new GraphNode<>("E", 4));
		nodeList.add(new GraphNode<>("F", 5));
		nodeList.add(new GraphNode<>("G", 6));


		GraphAdjacencyMatrixImpl<String> matrixList = new GraphAdjacencyMatrixImpl<>(nodeList);
		matrixList.addWeightedEdge(0, 1, 2);
		matrixList.addWeightedEdge(0, 2, 5);
		matrixList.addWeightedEdge(1, 2, 6);
		matrixList.addWeightedEdge(1, 3, 1);
		matrixList.addWeightedEdge(1, 4, 3);
		matrixList.addWeightedEdge(3, 4, 4);
		matrixList.addWeightedEdge(4, 6, 9);
		matrixList.addWeightedEdge(2, 5, 8);
		matrixList.addWeightedEdge(5, 6, 7);

		GraphAdjacencyListImpl<String> graphList = new GraphAdjacencyListImpl<>(nodeList);
		graphList.addWeightedEdge(0, 1, 2);
		graphList.addWeightedEdge(0, 2, 5);
		graphList.addWeightedEdge(1, 2, 6);
		graphList.addWeightedEdge(1, 3, 1);
		graphList.addWeightedEdge(1, 4, 3);
		graphList.addWeightedEdge(3, 4, 4);
		graphList.addWeightedEdge(4, 6, 9);
		graphList.addWeightedEdge(2, 5, 8);
		graphList.addWeightedEdge(5, 6, 7);


		//	graphMatrix.bfs();
		//	graphList.bfs();
		//graphMatrix.dfs(); //ADECB
		//	graphList.dfs();  //ADCBE

//		System.out.println(graphMatrix);
//
		//graphList.BFSforSSSPP(nodeList.get(0));
		//	graphMatrix.BFSforSSSPP(nodeList.get(0));

		//	System.out.println(graphList);
		//	graphList.pathPrint(nodeList.get(0));

	//	graphList.dijkstra(nodeList.get(0)); //from node A

	//	matrixList.dijkstra(nodeList.get(0)); //from node A
	//	matrixList.bellmanFord(nodeList.get(0));

	//	graphList.floydWarshall();

		matrixList.floydWarshall();

	}
}
