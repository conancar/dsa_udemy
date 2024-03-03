package dsa.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MissingElementOfArray {

	private static final Random rnd = new Random();

	public static void main(String[] args) {
		int arraySize = getArraySizeFromStdIn();
		int[] array = createArray(arraySize);
		System.out.println(Arrays.toString(array));

		final int missingNumber = findMissingNumberInArray(array);
		System.out.println(missingNumber);
	}

	private static int findMissingNumberInArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i + 1] - arr[i] > 1) {
				return arr[i] + 1;
			}
		}
		return 0;
	}

	private static int[] createArray(int size) {
		if (size < 3) {
			return new int[0];
		}

		int numberToSkip;
		if (size == 3) {
			numberToSkip = 1;
		} else {
			numberToSkip = rnd.nextInt(size - 2 - 1) + 1;
		}
		System.out.println("Skip=" + numberToSkip);
		int indexToSkip = numberToSkip;

		boolean indexSkipped = false;

		int[] array = new int[size - 1];
		for (int i = 0; i < size - 1; i++) {
			if (i == indexToSkip) {
				array[i] = i + 1;
				indexSkipped = true;
				continue;
			}
			if (!indexSkipped) {
				array[i] = i;
			} else {
				array[i] = i + 1;
			}
		}
		return array;
	}

	private static int getArraySizeFromStdIn() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input array size:");
		int arraySize=scanner.nextInt();
		scanner.close();
		return arraySize;
	}
}
