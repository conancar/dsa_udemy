package dsa.array;

/**
 * Symmetry
 * For given two integer arrays. Write a program to check if they are symmetric of each other.
  * Example
 *     int[] array1 = {1,2,3,4,5};
 *     int[] array2 = {5,4,3,2,1};
 *     symmetric(array1, array2)
 * Output
 * true
 */
public class ArraysAreSymmetric {


	public static void main(String[] args){

		//Test arrays with different sizes
		final int[] array1=new int[] {1,2,3};
		final int[] array2=new int[] {1,2};
		final boolean arraysAreSymmetric = checkIfTwoArraysAreSymmetric(array1, array2);
		if(arraysAreSymmetric) throw new IllegalArgumentException("Test arrays with different sizes failed!");

		//Test arrays are Symmetric
		final int[] array11=new int[] {1,2,3,5,6};
		final int[] array22=new int[] {6,5,3,2,1};
		final boolean arraysAreSymmetric2 = checkIfTwoArraysAreSymmetric(array11, array22);
		if(!arraysAreSymmetric2) throw new IllegalArgumentException("Test arrays are Symmetric failed!");

		//Test arrays NOT Symmetric
		final int[] array111=new int[] {1,2,3,1,2,4};
		final int[] array222=new int[] {2,2,1,2,2,1};
		final boolean arraysAreSymmetric3 = checkIfTwoArraysAreSymmetric(array111, array222);
		if(arraysAreSymmetric3) throw new IllegalArgumentException("Test arrays NOT Symmetric failed!");

		System.out.println("ALL TESTS PASSED!");
	}

	static boolean checkIfTwoArraysAreSymmetric(int[] array1, int[] array2){
		final int array1Length=array1.length;
		final int array2Length=array2.length;

		if(array1Length!=array2Length){
			return false;
		}

		for(int i=0;i<array1Length;i++){
			for(int j=array2Length-1;j>=0;j--){
				System.out.println("Checking element of array1 at index "+i+" and value "+array1[i] + " against array2 at index "+j+" and value "+array2[j]);
				if(array1[i]!=array2[j]){
					System.out.println("NO MATCH!");
					return false;
				}
				i++;
			}
		}
		return true;
	}
}
