package dsa.tree;


public class MyBSTBasicOps {

	public static void main(String[] args) {


		MyBinarySearchTreeLinkedListImpl<Integer> binarySearchTree=new MyBinarySearchTreeLinkedListImpl<>();
		binarySearchTree.insert(70);
		binarySearchTree.insert(50);
		binarySearchTree.insert(90);
		binarySearchTree.insert(30);
		binarySearchTree.insert(60);
		binarySearchTree.insert(80);
		binarySearchTree.insert(100);
		binarySearchTree.insert(20);
		binarySearchTree.insert(40);


//		final MyBinaryTreeNode<Integer> found = binarySearchTree.search(binarySearchTree.getRoot(), 50);
//		System.out.println(found);

		binarySearchTree.deleteNode(binarySearchTree.getRoot(),20);

		System.out.println(binarySearchTree);

	}




}
