package dsa.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1, 1, 2]
 * Output: 2
 */
public class RemoveDuplicatesfromSortedArray {


	private static final Scanner scanner = new Scanner(System.in);
	//define constraints and edge cases
	private static final int MIN_ARRAY_SIZE = 3;


	public static void main(String[] args) {
		//input size of sorted array with duplicates, apply constraints
		final int arraySize = getArraySizeFromUser();

		//ask user for number of duplicates in array
		final int numberOfDuplicates = getNumberOfDuplicatesFromUser(arraySize);

		scanner.close();

		//create sorted array with duplicates for given size
		final int[] arrayWithDuplicates = createSortedArrayWithDuplicates(arraySize, numberOfDuplicates);
		System.out.println("arrayWithDuplicates=" + Arrays.toString(arrayWithDuplicates));
		//create new array without duplicates
		final int[] cleanArray = cleanDuplicatesInNewArray(arrayWithDuplicates);
		System.out.println("clean array=" + Arrays.toString(cleanArray));
		//find length of new row
		System.out.println("Clean array size="+cleanArray.length);

	}

	private static int[] cleanDuplicatesInNewArray(int[] arrayWithDuplicates){

		int cleanArraySize=0;
		for(int i=0;i<arrayWithDuplicates.length;i++){

			if(i==arrayWithDuplicates.length-1){
				cleanArraySize++;
				break;
			}

			if(arrayWithDuplicates[i]!=arrayWithDuplicates[i+1]){
				cleanArraySize++;
			}
		}

		int[] cleanArray=new int[cleanArraySize];

		int j=0;
		for(int i=0;i<arrayWithDuplicates.length;i++){
			if(i==arrayWithDuplicates.length-1){
				cleanArray[j]=arrayWithDuplicates[i];
				break;
			}
			if(arrayWithDuplicates[i]!=arrayWithDuplicates[i+1]){
				cleanArray[j]=arrayWithDuplicates[i];
				j++;
			}
		}

		return cleanArray;

	}

	private static int[] createSortedArrayWithDuplicates(int arraySize, int numberOfDuplicates) {


		final int[] arrayWithDuplicates = new int[arraySize];

		//first put duplicates in array
		int k = 0;
		for (int j = 0; j < numberOfDuplicates; j = j + 1) {

				arrayWithDuplicates[k] = j;
				arrayWithDuplicates[k + 1] = j;
				//move for 2 places for each iteration (duplicates)
				k = k + 2;

		}
		//then other numbers in sequence
		for(int j=numberOfDuplicates*2;j<arraySize;j++){
			arrayWithDuplicates[j]=j-numberOfDuplicates;
		}

		return arrayWithDuplicates;
	}

	private static int getNumberOfDuplicatesFromUser(int arraySize) {
		int maxNumberOfDuplicates = arraySize / 2;

		System.out.println("number of duplicates (max " + maxNumberOfDuplicates + ") :");
		final int numberOfDuplicates = scanner.nextInt();
		if (numberOfDuplicates > maxNumberOfDuplicates) {
			throw new IllegalArgumentException("Too many duplicates!");
		}
		return numberOfDuplicates;
	}

	private static int getArraySizeFromUser() {

		System.out.println("Enter size of array (min " + MIN_ARRAY_SIZE + ") :");
		final int arraySize = scanner.nextInt();
		if (arraySize < MIN_ARRAY_SIZE) {
			throw new IllegalArgumentException("Size to small!");
		}
		return arraySize;
	}
}
