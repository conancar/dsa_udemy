package dsa.algorithms.searching;

public class LinearSearch {

	public int search(int[] array,int value){

		for (int i=0;i<array.length;i++) {
			if(value==array[i]){
				return i;
			}
		}

		return -1;

	}
}
