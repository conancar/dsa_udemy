package dsa.array;

/**
 *Finding a Number in an Array
 * Write a program  to check if an array contains a number in Java.
 *     int[] intArray = {1,2,3,4,5,6};
 *     searchInArray(intArray, 6); // 5 - index of found number
 */
public class FindingNumberInArrayLinearSearch {

	public static void main(String[] args){


	}

	public static int searchInArray(int[] intArray, int valueToSearch) {
		final int arrayLength = intArray.length;
		int valueFoundOnIndex=-1;
		for(int i = 0; i< arrayLength; i++){
			if(intArray[i]==valueToSearch){
				valueFoundOnIndex=i;
				break;
			}
		}
		return valueFoundOnIndex;
	}
}
