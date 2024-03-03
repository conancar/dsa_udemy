package dsa.array;

import java.util.Arrays;

/**
 * How to find maximum product of two integers in the array where all elements are positive.
 * Example
 *     int[] intArray = {10,20,30,40,50};
 *     maxProduct(intArray) // (40,50)
 */
public class MaxProductOfTwoPositiveIntegers {

	private static final int MIN_ARRAY_LENGTH=2;
	static final String ARRAY_TO_SHORT_MESSAGE = "Min array lenght is " + MIN_ARRAY_LENGTH;
	static final String NEGATIVE_ELEMENT_IN_ARRAY_MESSAGE = "Array can contain only positive numbers!";

	public static void main(String[] args){

	}

	public static String findMaxElementsInArray(int[] intArray) {
		System.out.println("Input array = "+Arrays.toString(intArray));

		validateArrayLength(intArray);
		int arrayLength=intArray.length;

		int largestNumberInArray=Integer.MIN_VALUE;
		int secondLargestNumberInArray=Integer.MIN_VALUE;

		return implementationON(intArray, arrayLength, largestNumberInArray, secondLargestNumberInArray);
		//return implementationO2N(intArray, arrayLength, largestNumberInArray, secondLargestNumberInArray);
	}

	private static String implementationON(int[] intArray, int arrayLength, int largestNumberInArray, int secondLargestNumberInArray) {
		for(int i = 0; i< arrayLength; i++){

			//validation for only positive values in array
			validatePositiveNumbersInArray(intArray, i);

			//find largest element
			if(intArray[i]> largestNumberInArray){
				secondLargestNumberInArray=largestNumberInArray; //FIRST THIS so silver becomes old gold
				largestNumberInArray = intArray[i]; //then set new gold
			}
			if(intArray[i]> secondLargestNumberInArray && largestNumberInArray>intArray[i]){
				secondLargestNumberInArray = intArray[i]; //set new silver
			}
			System.out.println("For index="+i+ " Largest is " +largestNumberInArray+" and secod largest "+secondLargestNumberInArray);
		}

		return "("+ secondLargestNumberInArray +","+ largestNumberInArray +")";
	}

	private static String implementationO2N(int[] intArray, int arrayLength, int largestNumberInArray, int secondLargestNumberInArray) {
		for(int i = 0; i< arrayLength; i++){

			//validation for only positive values in array
			validatePositiveNumbersInArray(intArray, i);

			//find largest element
			if(intArray[i]> largestNumberInArray){
				largestNumberInArray = intArray[i];
			}

			//System.out.println("For index="+i+ " Largest is " +largestNumberInArray+" and secod largest "+secondLargestNumberInArray);
		}

		for(int i = 0; i< arrayLength; i++){
			//find largest element
		 if(intArray[i]!= largestNumberInArray && secondLargestNumberInArray < intArray[i]){
				secondLargestNumberInArray = intArray[i];
			}
			System.out.println("For index="+i+ " Largest is " + largestNumberInArray +" and secod largest "+ secondLargestNumberInArray);
		}
		return "("+ secondLargestNumberInArray +","+ largestNumberInArray +")";
	}

	private static void validatePositiveNumbersInArray(int[] intArray, int i) {
		if(intArray[i]<0){

			throw new IllegalArgumentException(NEGATIVE_ELEMENT_IN_ARRAY_MESSAGE);
		}
	}

	private static void validateArrayLength(int[] intArray) {
		if(intArray.length<MIN_ARRAY_LENGTH){

			throw new IllegalArgumentException(ARRAY_TO_SHORT_MESSAGE);
		}
	}
}
