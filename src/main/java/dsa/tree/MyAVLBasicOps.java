package dsa.tree;


public class MyAVLBasicOps {

	public static void main(String[] args) {


		MyAVLTreeLinkedListImpl<Integer> avlTree=new MyAVLTreeLinkedListImpl<>();
		avlTree.insert(10);
		avlTree.insert(20);
		avlTree.insert(30);
		avlTree.insert(40);
		avlTree.insert(50);
		avlTree.insert(60);
		avlTree.insert(70);
		avlTree.insert(80);
		avlTree.insert(90);


//		final MyBinaryTreeNode<Integer> found = binarySearchTree.search(binarySearchTree.getRoot(), 50);
//		System.out.println(found);

	//	avlTree.deleteNode(avlTree.getRoot(),20);

		System.out.println(avlTree);

	}




}
