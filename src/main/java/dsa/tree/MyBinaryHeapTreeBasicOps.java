package dsa.tree;


public class MyBinaryHeapTreeBasicOps {

	public static void main(String[] args) {


		MyBinaryHeapArrayImpl<Integer> binaryHeapTree=new MyBinaryHeapArrayImpl<>(Integer.class,15);
		binaryHeapTree.addNode(40, MyBinaryHeapArrayImpl.heapType.MAX_HEAP);
		binaryHeapTree.addNode(50, MyBinaryHeapArrayImpl.heapType.MAX_HEAP);
		binaryHeapTree.addNode(30, MyBinaryHeapArrayImpl.heapType.MAX_HEAP);
		binaryHeapTree.addNode(10, MyBinaryHeapArrayImpl.heapType.MAX_HEAP);
		binaryHeapTree.addNode(20, MyBinaryHeapArrayImpl.heapType.MAX_HEAP);
		binaryHeapTree.addNode(60, MyBinaryHeapArrayImpl.heapType.MAX_HEAP);


//		final MyBinaryTreeNode<Integer> found = binarySearchTree.search(binarySearchTree.getRoot(), 50);
//		System.out.println(found);

		binaryHeapTree.removeRootNode(MyBinaryHeapArrayImpl.heapType.MAX_HEAP);

		System.out.println(binaryHeapTree.toString(3));
		

	}




}
