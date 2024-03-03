package dsa.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MiddleOfArray {
	private static final int MIN_ARRAY_LENGHT = 2;
	private static final Random rnd = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final int arraySize = getArraySize();
		final int[] fullArray = generateArray(arraySize);
		System.out.println(Arrays.toString(fullArray));
		int[] middlePartOfArray = generateMiddlePartOfArray(fullArray);

		System.out.println(Arrays.toString(middlePartOfArray));

		scanner.close();
	}

	public static int[] generateMiddlePartOfArray(int[] array) {

		//Boundary Conditions
		if (array.length <= MIN_ARRAY_LENGHT) {
			return new int[0];
		}

		int[] middleArray = new int[array.length - 2];

		int index = 1;
		while (index < array.length - 1) {
			middleArray[index - 1] = array[index];
			index++;
		}
		// for(int i=0;i<array.length;i++){
		//     if(i==0 || i==array.length-1){
		//       continue;
		//     }
		//     middleArray[i-1]=array[i];;
		//  }

		return middleArray;
	}

	private static int[] generateArray(int size) {

		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = rnd.nextInt(10);
		}
		return array;
	}

	private static int getArraySize() {
		System.out.println("Insert array size:");
		final int size = scanner.nextInt();
		if (size <= MIN_ARRAY_LENGHT) {
			throw new IllegalArgumentException("Size to small");
		}
		return size;
	}
}
