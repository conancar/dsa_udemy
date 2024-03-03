package dsa.array;

import java.util.Arrays;

/**
 * find and print all pairs of an array
 * example
 * given array [1,3,5,6]
 * output  11,13,15,16,31,33,35,36,51,53,55,56,61,63,65,66
 */
public class PrintPairsOfAnArray {

	public static void main(String[] args) {

		//test 1
		int[] array1 = {1, 2, 3};
		System.out.println(Arrays.toString(array1));
		System.out.println(printPairs(array1));

		//test 2
		int[] array2 = {1};
		System.out.println(Arrays.toString(array2));
		System.out.println(printPairs(array2));
	}

	static String printPairs(int[] array) {
		StringBuilder sb = new StringBuilder();
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) {
			for (int j = 0; j < arrayLength; j++) {
				sb.append(array[i]).append(array[j]);
				final boolean lastElement = i == (arrayLength - 1) && j == (arrayLength - 1);
				if (!lastElement) {
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}
}
