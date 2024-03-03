package dsa.array;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {

		//test1
		int[] array1 = {1, 3, 4,5,8};
		System.out.println(Arrays.toString(array1));
		final int[] reversedArray = reverseElementsInArrayInsSameArray(array1);
		System.out.println(Arrays.toString(reversedArray));
	}

	static int[] reverseElementsInArrayInsSameArray(int[] array) {


		int start = 0;
		int end = array.length - 1;

		while (start < end) {

			System.out.println("From start element="+array[start]+" @@ "+" From end element="+array[end]);

			// Swap elements at start and end indices
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;

			// Move indices towards the center
			start++;
			end--;
		}
		return array;
	}

	static int[] reverseElementsInArrayUsingAnotherArray(int[] array) {
		int[] arrayReversed=new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayReversed[i] = array[array.length - 1 - i];
		}
		return arrayReversed;
	}
}
