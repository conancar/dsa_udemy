package dsa.tree;


public class MyBinaryTreeLinkedListImplBasicOps {

	public static void main(String[] args) {

		MyBinaryTreeNode<String> binaryTreeNode1 = new MyBinaryTreeNode<>("N1");
		MyBinaryTreeNode<String> binaryTreeNode2 = new MyBinaryTreeNode<>("N2");
		MyBinaryTreeNode<String> binaryTreeNode3 = new MyBinaryTreeNode<>("N3");
		MyBinaryTreeNode<String> binaryTreeNode4 = new MyBinaryTreeNode<>("N4");
		MyBinaryTreeNode<String> binaryTreeNode5 = new MyBinaryTreeNode<>("N5");
		MyBinaryTreeNode<String> binaryTreeNode6 = new MyBinaryTreeNode<>("N6");
		MyBinaryTreeNode<String> binaryTreeNode7 = new MyBinaryTreeNode<>("N7");
		MyBinaryTreeNode<String> binaryTreeNode8 = new MyBinaryTreeNode<>("N8");
		MyBinaryTreeNode<String> binaryTreeNode9 = new MyBinaryTreeNode<>("N9");

		binaryTreeNode1.setLeft(binaryTreeNode2);
		binaryTreeNode1.setRight(binaryTreeNode3);

		binaryTreeNode2.setLeft(binaryTreeNode4);
		binaryTreeNode2.setRight(binaryTreeNode5);
		binaryTreeNode3.setLeft(binaryTreeNode6);
		binaryTreeNode3.setRight(binaryTreeNode7);

		binaryTreeNode4.setLeft(binaryTreeNode8);
		binaryTreeNode4.setRight(binaryTreeNode9);

		System.out.println(5/2);
		//preOrderTraverse(binaryTreeNode1);
		//inOrderTraverse(binaryTreeNode1);
		//postOrderTraverse(binaryTreeNode1);
		//levelOrderTraverse(binaryTreeNode1);
		//	search(binaryTreeNode1,"N4");
		//add(binaryTreeNode1, "N0");
		//removeDeepest(binaryTreeNode1);
		//deleteNode(binaryTreeNode1);
	}

	private static void preOrderTraverse(MyBinaryTreeNode<String> binaryTreeNode1) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.traverseAllNodesPreOrderStyle(binaryTreeNode1);
	}

	private static void inOrderTraverse(MyBinaryTreeNode<String> binaryTreeNode1) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.traverseAllNodesInOrderStyle(binaryTreeNode1);
	}

	private static void postOrderTraverse(MyBinaryTreeNode<String> binaryTreeNode1) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.traverseAllNodesPostOrderStyle(binaryTreeNode1);
	}

	private static void levelOrderTraverse(MyBinaryTreeNode<String> binaryTreeNode1) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.traverseAllNodesLevelOrderStyle(binaryTreeNode1);

	}

	private static void search(MyBinaryTreeNode<String> binaryTreeNode1, String value) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.setRoot(binaryTreeNode1);
		final MyBinaryTreeNode<String> valueFound = treeLinkedList.searchForValue(value);
		if (valueFound != null) {
			System.out.println("Found at node " + valueFound);
		}
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


		System.out.println(treeLinkedList);
	}

	private static void removeDeepest(MyBinaryTreeNode<String> binaryTreeNode1) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.setRoot(binaryTreeNode1);
		treeLinkedList.addNode("01");
		treeLinkedList.addNode("02");
		treeLinkedList.addNode("03");
		treeLinkedList.addNode("04");

	//	System.out.println(treeLinkedList.toString(0));
		final MyBinaryTreeNode<String> deepest = treeLinkedList.removeAndReturnDeepestNode();

		System.out.println(deepest);

		//System.out.println(treeLinkedList.toString(0));
	}

	private static void deleteNode(MyBinaryTreeNode<String> binaryTreeNode1) {
		//we can traverse without setting root
		MyBinaryTreeLinkedListImpl<String> treeLinkedList = new MyBinaryTreeLinkedListImpl<>();
		treeLinkedList.setRoot(binaryTreeNode1);
		treeLinkedList.addNode("01");
		treeLinkedList.addNode("02");
		treeLinkedList.addNode("03");
		treeLinkedList.addNode("04");

		System.out.println(treeLinkedList);
		 treeLinkedList.removeNode("N3");

   System.out.println(treeLinkedList);
	}


}
