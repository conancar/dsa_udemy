package dsa.tree;


public class MyBinaryTreeArrayImplBasicOps {

	public static void main(String[] args) {

		String node1 = "N1";
		String node2 = "N2";
		String node3 = "N3";
		String node4 = "N4";
		String node5 = "N5";
		String node6 = "N6";
		String node7 = "N7";
		String node8 = "N8";
		String node9 = "N9";
		String node10 = "N10";
		String node11 = "N11";

		MyBinaryTreeArrayImpl<String> binaryTree=new MyBinaryTreeArrayImpl<>(String.class,10);
		binaryTree.addNode(node1);
		binaryTree.addNode(node2);
		binaryTree.addNode(node3);
		binaryTree.addNode(node4);
		binaryTree.addNode(node5);
		binaryTree.addNode(node6);
		binaryTree.addNode(node7);
		binaryTree.addNode(node8);
		binaryTree.addNode(node9);
//		binaryTree.addNode(node10);
	//	binaryTree.addNode(node11);


//		preOrderTraverse(binaryTree);
//		System.out.println("************************************");
//		inOrderTraverse(binaryTree);
//		System.out.println("************************************");
//		postOrderTraverse(binaryTree);
//		System.out.println("************************************");
//		levelOrderTraverse(binaryTree);
//		System.out.println("************************************");
//	search(binaryTree,"N4");
		//add(binaryTreeNode1, "N0");
		//removeDeepest(binaryTreeNode1);
		deleteNode(binaryTree,"N3");
	}

	private static void preOrderTraverse(MyBinaryTreeArrayImpl<String> binaryTree) {
		binaryTree.traverseAllNodesPreOrderStyle(1);
	}

	private static void inOrderTraverse(MyBinaryTreeArrayImpl<String> binaryTree) {
		binaryTree.traverseAllNodesInOrderStyle(1);
	}

	private static void postOrderTraverse(MyBinaryTreeArrayImpl<String> binaryTree) {
		binaryTree.traverseAllNodesPostOrderStyle(1);
	}

	private static void levelOrderTraverse(MyBinaryTreeArrayImpl<String> binaryTree) {
		binaryTree.traverseAllNodesLevelOrderStyle();

	}

	private static void search(MyBinaryTreeArrayImpl<String> binaryTree,String value) {
		final int indexOfFoundValue = binaryTree.searchForValue(value);
		System.out.println(indexOfFoundValue);
	}

	private static void add(MyBinaryTreeNode<String> binaryTreeNode1, String value) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.setRoot(binaryTreeNode1);
		treeLinkedList.addNode(value);
		treeLinkedList.addNode("01");
		treeLinkedList.addNode("02");
		treeLinkedList.addNode("03");
		treeLinkedList.addNode("04");
		treeLinkedList.addNode("05");
		treeLinkedList.addNode("06");


		System.out.println(treeLinkedList.toString());
	}



	private static void deleteNode(MyBinaryTreeArrayImpl<String> binaryTree,String value) {
		System.out.println(binaryTree.toString(0));

		binaryTree.removeNode(value);

   System.out.println(binaryTree.toString(0));
	}


}
