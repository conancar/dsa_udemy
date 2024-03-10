package dsa.hashing;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LinearProbingHashing<T extends Comparable<T> & Serializable> implements MyHashing<T> {

	T[] hashTable;
	float maxLoadFactor;
	int usedNumberOfCells;
	Class<T> clazz;

	public LinearProbingHashing(Class<T> clazz, int hashTableSize) {

		hashTable = (T[]) Array.newInstance(clazz, hashTableSize);
		usedNumberOfCells = 0;
		maxLoadFactor = 0.75F;
		this.clazz = clazz;
	}

	private float getCurrentLoadFactor() {
		return (float) usedNumberOfCells / hashTable.length;
	}

	private void reHashWhenMaxLoadFactorIsReached(T newValue) {
		usedNumberOfCells = 0;

		//get all elements in temp arrayList
		ArrayList<T> temp = new ArrayList<>(hashTable.length + 1);
		for (T value : hashTable) {
			temp.add(value);
		}
		//double the array size of hashtable
		hashTable = (T[]) Array.newInstance(clazz, hashTable.length * 2);

		//insert values to new bigger hash table
		for (T t : temp) {
			insert(t);
		}

	}

	public void insert(T value) {
		if (getCurrentLoadFactor() > maxLoadFactor) {
			reHashWhenMaxLoadFactorIsReached(value);
		} else {
			int indexFromHashFunction = asciiHashFunction(value, hashTable.length);

			//We can iterate more than hash table size
			for (int firstAvailableIndex = indexFromHashFunction; firstAvailableIndex < indexFromHashFunction + hashTable.length; firstAvailableIndex++) {
				int newIndex = firstAvailableIndex % hashTable.length; //to go to 0 index from max since we loop untill lenght+indexFromHashFunction
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = value;
					break;
				}
			}
		}
		usedNumberOfCells++;
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

	@Override
	public boolean find(T value) {
		if (this.hashTable == null) {
			return false;
		}

		int indexFromHashFunction=asciiHashFunction(value,hashTable.length);

		for(int i=indexFromHashFunction;i<indexFromHashFunction+hashTable.length;i++){
			int newIndex=i%hashTable.length;  //to go to 0 index from max since we loop untill lenght+indexFromHashFunction
			if(hashTable[newIndex]!=null && hashTable[newIndex].compareTo(value)==0){
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean remove(T value) {
		if (this.hashTable == null) {
			return false;
		}

		int indexFromHashFunction=asciiHashFunction(value,hashTable.length);

		for(int i=indexFromHashFunction;i<indexFromHashFunction+hashTable.length;i++){
			int newIndex=i%hashTable.length;  //to go to 0 index from max since we loop untill lenght+indexFromHashFunction
			if(hashTable[newIndex]!=null && hashTable[newIndex].compareTo(value)==0){
				hashTable[newIndex]=null;
				usedNumberOfCells--;
				return true;
			}
		}

		return false;
	}


}
