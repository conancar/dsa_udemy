package dsa.array;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Examples
 *     Input: nums = [2,7,11,15], target = 9
 *     Output: [0,1]
 *     Output: Because nums[0] + nums[1] == 9, we return [0, 1]

 *     Input: nums = [3,2,4], target = 6
 *     Output: [1,2]
 */
public class TwoSum {

	public static final int MINIMUM_TARGET=2;
	public static final int MINIMUM_ARRAY_LENGTH=2;

	public static void main(String[] args){

	}

	static int[] indexesOfTwoNumbers(int[] array,int target){
		final int arrayLength = array.length;
		System.out.println("Input Array="+Arrays.toString(array));
		//edge cases
		if(target<MINIMUM_TARGET){
			throw new IllegalArgumentException("Target too small");
		}
		if(arrayLength<MINIMUM_ARRAY_LENGTH){
			throw new IllegalArgumentException("Array too short");
		}

		//iterate elements to find values
		for(int i=0;i<arrayLength;i++){

			for(int inx=1;inx<=arrayLength-1-i;inx++) {
				final int number1 = array[i];
				final int number2 = array[i + inx];
				System.out.println("Number1="+number1+ " Number2="+number2);
				if (target == number1 + number2) {
					return new int[]{i, i + inx};
				}
			}
		}
		return new int[0];
	}
}
