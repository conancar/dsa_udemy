package dsa.tree;

import java.io.Serializable;
import java.lang.reflect.Array;

public class MyBinaryHeapArrayImpl<T extends Comparable<T> & Serializable> {

	private T[] array;

	private int sizeOfTree;

	public MyBinaryHeapArrayImpl(Class<T> clazz, int capacity) {
		this.array = (T[]) Array.newInstance(clazz, capacity + 1); //capacity +1
		this.sizeOfTree = 0; //keep zero index always empty so cell formula can be implemented
	}

	//get min dor min heap or max for max heap
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return array[1];
	}

	public int size() {

		return sizeOfTree;
	}

	private boolean isFull() {
		return array.length == sizeOfTree;
	}

	private boolean isEmpty() {
		return sizeOfTree == 0;
	}

	public void traverseAllNodesPreOrderStyle(int index) {
		if (index > sizeOfTree) {
			return;
		}
		System.out.println(array[index] + " ");
		traverseAllNodesPreOrderStyle(index * 2);
		traverseAllNodesPreOrderStyle(index * 2 + 1);

	}

	public void traverseAllNodesInOrderStyle(int index) {
		if (index > sizeOfTree) {
			return;
		}
		traverseAllNodesInOrderStyle(index * 2);
		System.out.println(array[index] + " ");
		traverseAllNodesInOrderStyle(index * 2 + 1);

	}

	public void traverseAllNodesPostOrderStyle(int index) {
		if (index > sizeOfTree) {
			return;
		}
		traverseAllNodesPostOrderStyle(index * 2);
		traverseAllNodesPostOrderStyle(index * 2 + 1);
		System.out.println(array[index] + " ");

	}


	public void traverseAllNodesLevelOrderStyle() {
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.println(array[i] + " ");
		}
	}


	public Integer searchForValue(T value) {
		for (int i = 1; i <= sizeOfTree; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return 0;
	}


	public void addNode(T value, heapType heapType) {

		if (this.isFull()) {
			throw new IllegalArgumentException("tree is full!");
		}

		this.array[sizeOfTree + 1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree, heapType);

	}

	public enum heapType {
		MIN_HEAP,
		MAX_HEAP
	}

	//O(logN) space and time recursion
	private void heapifyBottomToTop(int index, heapType heapType) {
		int parent = index / 2;
		if (index <= 1) {
			return; //root is reached, at index of 1 always breaks recursion
		}
		if (heapType == MyBinaryHeapArrayImpl.heapType.MIN_HEAP) {
			if (array[index].compareTo(array[parent]) < 0) {
				T tmp = array[parent];
				array[parent] = array[index];
				array[index] = tmp;
			}
		} else if (heapType == MyBinaryHeapArrayImpl.heapType.MAX_HEAP && (array[index].compareTo(array[parent]) > 0)) {
			T tmp = array[parent];
			array[parent] = array[index];
			array[index] = tmp;

		}
		//recursive call with parent
		heapifyBottomToTop(parent, heapType);
	}

	//O(logN) space and time recursion
	private void heapifyTopToBottom(int parentIndex, heapType heapType) {
		int leftChildIndex = parentIndex * 2;
		int rightChildIndex = parentIndex * 2 + 1;


		if (sizeOfTree < leftChildIndex) {
			return; //arrayOutOfBounds, we came to the end
		}

		int tmpChildIndex;

		if (heapType == MyBinaryHeapArrayImpl.heapType.MAX_HEAP) {
			//node has only left (one) child, swap with parent
			if (sizeOfTree == leftChildIndex) {
				if (array[parentIndex].compareTo(array[leftChildIndex]) < 0) {
					T tmp = array[parentIndex];
					array[parentIndex] = array[leftChildIndex];
					array[leftChildIndex] = tmp;
				}
			} else {//we have 2 children
				// we compare children and swap larger with parent
				if (array[leftChildIndex].compareTo(array[rightChildIndex]) > 0) {
					tmpChildIndex = leftChildIndex;
				} else {
					tmpChildIndex = rightChildIndex;
				}

				if (array[parentIndex].compareTo(array[tmpChildIndex]) < 0) {
					T tmp = array[parentIndex];
					array[parentIndex] = array[tmpChildIndex];
					array[tmpChildIndex] = tmp;
				}
			}
		} else if (heapType == MyBinaryHeapArrayImpl.heapType.MIN_HEAP) {
			//node has only left (one) child, swap with parent
			if (sizeOfTree == leftChildIndex) {
				if (array[parentIndex].compareTo(array[leftChildIndex]) > 0) {
					T tmp = array[parentIndex];
					array[parentIndex] = array[leftChildIndex];
					array[leftChildIndex] = tmp;
				}
				return;
			} else {//we have 2 children
				// we compare children and swap larger with parent

				if (array[leftChildIndex].compareTo(array[rightChildIndex]) < 0) {
					tmpChildIndex = leftChildIndex;
				} else {
					tmpChildIndex = rightChildIndex;
				}

				if (array[parentIndex].compareTo(array[tmpChildIndex]) > 0) {
					T tmp = array[parentIndex];
					array[parentIndex] = array[tmpChildIndex];
					array[tmpChildIndex] = tmp;
				}
			}
			heapifyTopToBottom(tmpChildIndex, heapType);
		}


	}


	public T removeRootNode(heapType heapType) {

		if(isEmpty()){
			return null;
		}

		T rootValue=array[1];

		//first swap root value with last element
		array[1]=array[sizeOfTree];

		sizeOfTree--;

		heapifyTopToBottom(1,heapType);

		return rootValue;

	}

	public void deleteTree() {
		this.array = null;
	}

	public String toString(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= sizeOfTree; i++) {
			sb.append(array[i]).append("->");
		}
		return sb.toString();
	}
}
