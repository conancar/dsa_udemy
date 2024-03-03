package dsa.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiagonalSum2DArray {

	private static final Random rnd = new Random();
	private static final Scanner scanner = new Scanner(System.in);
	private static final int MIN_NUMBER_OF_ROWS = 1;
	private static final int MIN_NUMBER_OF_COLUMNS = 1;

	public static void main(String[] args) {
		int[][] array = form2dArray();


		System.out.println(Arrays.deepToString(array));

		System.out.println(calculateDiagonalSum(array));

		scanner.close();
	}

	private static int[][] form2dArray() {

		System.out.println("Enter the number of rows:");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of columns:");
		int columns = scanner.nextInt();


		if (rows <= MIN_NUMBER_OF_ROWS || columns <= MIN_NUMBER_OF_COLUMNS) {
			return new int[0][0];
		}

		int[][] array = new int[rows][columns];

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				array[row][column] = rnd.nextInt((5 - 1) + 1) + 1;
			}
		}

		return array;

	}

	private static int calculateDiagonalSum(int[][] matrix) {
		int diagonalSum = 0;


		int numRows = matrix.length;

		for (int i = 0; i < numRows; i++) {
			diagonalSum += matrix[i][i];
		}

		// for(int row=0;row<matrix.length;row++){
		//   for(int column=0;column<matrix[0].length;column++){
		//     if(row==column){
		//       diagonalSum+=matrix[row][column];
		//     }
		//   }
		// }

		return diagonalSum;
	}
}
