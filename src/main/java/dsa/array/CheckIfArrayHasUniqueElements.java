package dsa.array;

import java.util.Arrays;

/**
 * Write a program to check if an array is unique or not.
 * Example
 *     int[] intArray = {1,2,3,4,5,6};
 *     isUnique(intArray) // true
 */
public class CheckIfArrayHasUniqueElements {

	static boolean checkIfArrayIsUnique(int[] intArray){
		System.out.println("Array is "+Arrays.toString(intArray));

		final int arrayLength=intArray.length;

		for(int i=0;i<arrayLength;i++){
			for(int j = i+1;j<arrayLength;j++){
				System.out.println("checking for duplicate  between vale "+ intArray[i] +" on index "+ i+" and value "+intArray[j]+ " on index "+j);
				if(intArray[i]==intArray[j]){
					System.out.println("Duplicate found "+ intArray[i] +" on indexes "+ i+" , "+j);
					return false;
				}
			}
		}
		return true;
	}
}
