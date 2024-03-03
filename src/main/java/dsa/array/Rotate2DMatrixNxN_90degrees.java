package dsa.array;


import java.util.Arrays;

/**
 * Rotate Matrix
 *
 * Given an image represented by an NxN matrix write a method to rotate the image by 90 degrees.
 *
 * 123     741
 * 456  -> 852
 * 789     963
 */
public class Rotate2DMatrixNxN_90degrees {

	public static void main(String[] args){

		final int[][] originalMatrix ={{1,2,3},{4,5,6},{7,8,9}};

		final int[][] originalMatrix2 ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		System.out.println(Arrays.deepToString(originalMatrix2));

		final int[][] rotatedMatrix = rotateMatrixWithRotatingValuesOfTopLeftRightAndBottomElementsInLayers(originalMatrix2);
		System.out.println(Arrays.deepToString(rotatedMatrix));
//		rotateMatrixWithHelperMatrixClone(originalMatrix);
	}



	static int[][] rotateMatrixWithRotatingValuesOfTopLeftRightAndBottomElementsInLayers(int[][] matrix){


		final int numberOfRows=matrix.length;
		final int numberOfColumns=matrix[0].length;

		if(numberOfColumns!=numberOfRows){
			throw new IllegalArgumentException("This is not NxN matrix!");
		}

		final int numberOfLayers=numberOfRows/2; //Number of layers in matix. 3->2, 4->2,

		for(int layer=0;layer<numberOfLayers;layer++){
			int last=numberOfRows-1-layer;
			for(int i = layer; i<last; i++){
				int offset=i- layer;
				//Now we determine diamonds in layers
				int top = matrix[layer][i];
				int left = matrix[last-offset][layer];
				int bottom=matrix[last][last-offset];
				int right =matrix[i][last];

				System.out.println("For layer "+layer+" -->>" +" top="+top+";left="+left+";bottom="+bottom+";right="+right);

				//do the diamond rotation
				matrix[layer][i]=left;
				matrix[last-offset][layer]=bottom;
				matrix[last][last-offset]=right;
				matrix[i][last]=top;
			}
		}

		return matrix;
	}


	static int[][] rotateMatrixWithHelperMatrixClone(int[][] matrix){


		final int numberOfRows=matrix.length;
		final int numberOfColumns=matrix[0].length;

		if(numberOfColumns!=numberOfRows){
			throw new IllegalArgumentException("This is not NxN matrix!");
		}

		for(int row=0;row<numberOfRows;row++){
		//	System.out.println(Arrays.toString(matrix[row]));
		}

		int[][] rotatedMatrix=new int[numberOfRows][numberOfColumns];
		for(int row=0;row<numberOfRows;row++){
			for(int column=0;column<numberOfColumns;column++){
				rotatedMatrix[column][numberOfRows-1-row]=matrix[row][column];
			}
		}
		System.out.println("********************************");
		for(int row=0;row<numberOfRows;row++){
			//System.out.println(Arrays.toString(rotatedMatrix[row]));
		}

		return rotatedMatrix;
	}



}
