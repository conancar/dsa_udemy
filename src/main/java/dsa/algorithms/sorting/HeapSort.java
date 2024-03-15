package dsa.algorithms.sorting;

import dsa.tree.MyBinaryHeapArrayImpl;

public class HeapSort {

	int[] arr = null;

	public HeapSort(int[] arr) {
		this.arr = arr;
	}

	public int[] sort() {
		MyBinaryHeapArrayImpl<Integer> bh = new MyBinaryHeapArrayImpl(Integer.class,arr.length);
		for (int i = 0 ; i < arr.length; i++) {
			bh.addNode(arr[i], MyBinaryHeapArrayImpl.heapType.MIN_HEAP);
		}

		for(int i=0; i<arr.length; i++) {
			arr[i] = bh.removeRootNode(MyBinaryHeapArrayImpl.heapType.MIN_HEAP);
		}
		return arr;
	}



	public void printArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
	}
}
