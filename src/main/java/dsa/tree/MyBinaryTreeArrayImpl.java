package dsa.tree;

import java.io.Serializable;
import java.lang.reflect.Array;

public class MyBinaryTreeArrayImpl<T extends Serializable> {

	private T[] array;

	private int lastUsedIndex;

	public MyBinaryTreeArrayImpl(Class<T> clazz, int capacity) {
		this.array = (T[]) Array.newInstance(clazz, capacity + 1); //capacity +1
		this.lastUsedIndex = 0; //keep zero index always empty so cell formula can be implemented
	}

	private boolean isFull() {
		return array.length == lastUsedIndex;
	}

	public void traverseAllNodesPreOrderStyle(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		System.out.println(array[index] + " ");
		traverseAllNodesPreOrderStyle(index * 2);
		traverseAllNodesPreOrderStyle(index * 2 + 1);

	}

	public void traverseAllNodesInOrderStyle(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		traverseAllNodesInOrderStyle(index * 2);
		System.out.println(array[index] + " ");
		traverseAllNodesInOrderStyle(index * 2 + 1);

	}

	public void traverseAllNodesPostOrderStyle(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		traverseAllNodesPostOrderStyle(index * 2);
		traverseAllNodesPostOrderStyle(index * 2 + 1);
		System.out.println(array[index] + " ");

	}


	public void traverseAllNodesLevelOrderStyle() {
		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.println(array[i] + " ");
		}
	}




	public Integer searchForValue(T value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return 0;
	}


	public void addNode(T value) {

		if (this.isFull()) {
			throw new IllegalArgumentException("tree is full!");
		}

		lastUsedIndex++;
		this.array[lastUsedIndex] = value;

	}


	public void removeNode(T value) {
		//find node to remove
		int indexOfElementToRemove=0;
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (array[i].equals(value)) {
				indexOfElementToRemove=i;
				break;
			}
		}
		if(indexOfElementToRemove==0){
			return;
		}
	  //switch values with deepest
		array[indexOfElementToRemove]=array[lastUsedIndex];
		array[lastUsedIndex]=null;
		lastUsedIndex--;

	}

	public void deleteTree() {
		this.array=null;
	}

	public String toString(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= lastUsedIndex; i++) {
			sb.append(array[i]).append("->");
		}
		return sb.toString();
	}
}
