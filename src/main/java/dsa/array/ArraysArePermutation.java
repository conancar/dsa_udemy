package dsa.array;

import java.util.Arrays;

/**
 * Symmetry
 * For given two integer arrays. Write a program to check if they are Permutation (have the same elements) on same or different
 * positions of each other. No Duplicates of elements allowed.
  * Example
 *     int[] array1 = {1,2,3,4,5};
 *     int[] array2 = {5,4,3,2,1};
 *     Permutation(array1, array2)
 * Output
 * true
 */
public class ArraysArePermutation {


	public static void main(String[] args){

		//Test arrays with different sizes
		final int[] array1=new int[] {1,2,3};
		final int[] array2=new int[] {1,2};
		final boolean arraysArePermutation = checkIfTwoArraysArePermutation(array1, array2);
		if(arraysArePermutation) {
			throw new IllegalArgumentException("Test arrays are Permutation failed!");
		}else{
			System.out.println("TEST 0 PASSED !");
		}
		//Test arrays are Permutation
		final int[] array11=new int[] {1,2,3,5,6};
		final int[] array22=new int[] {6,5,3,2,1};
		final boolean arraysArePermutation2 = checkIfTwoArraysArePermutation(array11, array22);
		if(!arraysArePermutation2) {
			throw new IllegalArgumentException("Test arrays are Permutation failed!");
		}else{
			System.out.println("TEST 1 PASSED !");
		}

		//Test arrays are Permutation duplicates
//		final int[] array113=new int[] {1,2,3,5,6,3};
//		final int[] array223=new int[] {6,3,5,3,2,1};
//		final boolean arraysArePermutation23 = checkIfTwoArraysArePermutation(array113, array223);
//		if(!arraysArePermutation23) throw new IllegalArgumentException("Test arrays are Permutation duplicates failed!");

		//Test arrays NOT Permutation
		final int[] array111=new int[] {1,2,3,5,4};
		final int[] array222=new int[] {2,1,6,5,4};
		final boolean arraysArePermutation3 = checkIfTwoArraysArePermutation(array111, array222);
		if(arraysArePermutation3) {
			throw new IllegalArgumentException("Test arrays are Permutation failed!");
		}else{
			System.out.println("TEST 2 PASSED !");
		}
		//Test arrays NOT Permutation duplicates
//		final int[] array1111=new int[] {1,1,2,3,4};
//		final int[] array2222=new int[] {2,1,6,3,4};
//		final boolean arraysArePermutation4 = checkIfTwoArraysArePermutation(array1111, array2222);
//		if(arraysArePermutation4) throw new IllegalArgumentException("Test arrays NOT Permutation duplicates failed!");

		System.out.println("ALL TESTS PASSED!");
	}

	static boolean checkIfTwoArraysArePermutation(int[] array1, int[] array2){
		return implementationON(array1, array2);
		//return implementationOPower2(array1, array2);
	}

	//INTEGER ARRAYS HAVE SAME ELEMENTS IS THEIR SUMS AND PRODUCTS ARE SAME
	private static boolean implementationON(int[] array1, int[] array2) {
		final int array1Length= array1.length;
		final int array2Length= array2.length;

		if(array1Length!=array2Length){
			return false;
		}

		int sumArray1=0;
		int sumArray2=0;

		int productArray1=1;
		int productArray2=1;

		for(int i=0;i<array1Length;i++){
			sumArray1+=array1[i];
			sumArray2+=array2[i];
			productArray1*=array1[i];
			productArray2*=array2[i];
		}

		return (sumArray1==sumArray2 && productArray1==productArray2);

	}


	private static boolean implementationOPower2(int[] array1, int[] array2) {
		final int array1Length= array1.length;
		final int array2Length= array2.length;

		if(array1Length!=array2Length){
			return false;
		}

		//array for storing if element of array1 is inside array2
		boolean[] elementInsideSecondArray=new boolean[array1Length];


		for(int i=0;i<array1Length;i++){
			for(int j=0;j<array2Length;j++){
				System.out.println("Checking element of array1 at index "+i+" and value "+ array1[i] + " against array2 at index "+j+" and value "+ array2[j]);
				if(array1[i]== array2[j]){
					elementInsideSecondArray[i]=true;
					System.out.println("Element of first array with index "+ i+" IS in second array at index "+j);
					break;
				}
			}
		}

		System.out.println(Arrays.toString(elementInsideSecondArray));
		for (boolean elementInSecondArray : elementInsideSecondArray) {

			if(!elementInSecondArray){
				return false;
			}

		}
		return true;
	}
}
