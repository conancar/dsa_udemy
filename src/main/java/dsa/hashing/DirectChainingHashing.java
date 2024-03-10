package dsa.hashing;

import java.io.Serializable;
import java.util.LinkedList;

public class DirectChainingHashing<T extends Serializable> implements MyHashing<T> {

	LinkedList<T>[] hashTable;
	int maxChainSize = 5;

	public DirectChainingHashing(int hashTableSize) {

		hashTable = new LinkedList[hashTableSize];
	}

	public int asciiHashFunction(T valueToHash, int size_M) {
		final String keyToHash = valueToHash.toString();

		char[] ch = keyToHash.toCharArray();

		int sum = 0;
		for (char c : ch) {
			sum = sum + c;
		}

		return sum % size_M;
	}

	public void insert(T value) {
		int inex = asciiHashFunction(value, hashTable.length);
		if (hashTable[inex] == null) {
			hashTable[inex] = new LinkedList<>();
			hashTable[inex].add(value);
		} else {
			hashTable[inex].add(value);
		}
	}

	public String read() {
		if (this.hashTable == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hashTable.length; i++) {
			sb.append("position:").append(i).append(hashTable[i]).append(System.lineSeparator());
		}
		return sb.toString();
	}

	public boolean find(T valueToGet){
		int index=asciiHashFunction(valueToGet,hashTable.length);

		final LinkedList<T> tLinkedList = hashTable[index];
		if(tLinkedList ==null){
			return false;
		}
		return tLinkedList.contains(valueToGet);
	}

	public boolean remove(T valueToRemove){
		int index=asciiHashFunction(valueToRemove,hashTable.length);

		final LinkedList<T> tLinkedList = hashTable[index];
		if(tLinkedList ==null){
			return false;
		}
		return tLinkedList.remove(valueToRemove);
	}
}
