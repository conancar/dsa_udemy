package dsa.recursion;

import java.util.Arrays;

public class AnyArrayMemberIsOddRecursive {

	//create functional interface implementation!!!!
	static NumberIsOdd isOdd = (int number) -> number % 2 != 0;

	public static void main(String[] args) {

		int[] array = new int[]{2, 4, 6,1};


		//and pass it as param to function
		System.out.println(anyMemberIsOdd(array));
		System.out.println("//////////////////////////");
		System.out.println(productOfArrayIterative(array));
	}


	static boolean anyMemberIsOdd(int[] array) {

		if (array.length == 0) { //base case stopping from infinite loops
			return false;
		} else if (!isOdd.isOdd(array[0])) {
			return anyMemberIsOdd(Arrays.copyOfRange(array, 1, array.length)); //f(n)=f(shrink array by 1)
		} else {
			return true;
		}
	}

	static boolean productOfArrayIterative(int[] array) {
		boolean atLeastOneNumberIsOdd = false;

		for (int j : array) {
			if (isOdd.isOdd(j)) {
				atLeastOneNumberIsOdd = true;
			}
		}
		return atLeastOneNumberIsOdd;
	}
}
