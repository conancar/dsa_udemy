package dsa.array;

import junit.framework.TestCase;

import static dsa.array.FindingNumberInArrayLinearSearch.searchInArray;

public class FindingNumberInArrayLinearSearchTest extends TestCase {

	public void testTargetExistsInArray() {
		int[] intArray=new int[]{1,2,3,6,4,1,333,3};
		int target=333;

		final int valueAtIndex = searchInArray(intArray, target);
		assertEquals(6,valueAtIndex);
	}

	public void testTargetIsNotInArray() {
		int[] intArray=new int[]{1,2,3,6,4,1,333,3};
		int target=3334;

		final int valueAtIndex = searchInArray(intArray, target);
		assertEquals(-1,valueAtIndex);
	}
}