package dsa.algorithms.searching;

public class BinarySearch {


	public int binarySearchRecursive(int[] array, int value, int leftPointer, int rightPointer){

		int middlePointer=(leftPointer+rightPointer)/2;

		if(array[middlePointer]==value){
			return middlePointer;
		}else if(leftPointer==rightPointer){
			return -1;
		}else if(value>array[middlePointer]){
			return binarySearchRecursive(array,value,middlePointer+1,rightPointer);
		}
		else {
			return binarySearchRecursive(array,value,leftPointer,middlePointer-1);
		}
	}

	public int binarySearch(int[] array, int value){
	   int leftPointer=0;
		int rightPointer=array.length-1;
		int middlePointer=(leftPointer+rightPointer)/2;

		while (value!=array[middlePointer] && leftPointer<=rightPointer){
			if(value>array[middlePointer]){
				leftPointer=middlePointer+1;
			}else {
				rightPointer=middlePointer-1;
			}

			middlePointer=(leftPointer+rightPointer)/2;
		}
		return middlePointer;
	}
}
