package dsa.array;

import junit.framework.TestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest extends TestCase {

	public void testIndexesOfTwoNumbers() {

			int[] correctArray1={0,5,1,11,4,6};
		   int[] expectedIndexes1={1,4};
			int target1 = 9;
			final int[] array = TwoSum.indexesOfTwoNumbers(correctArray1,target1);
			assertArrayEquals(array,expectedIndexes1);

	}

	public void testIndexesOfTwoNumbersAtTheEnd() {

		int[] correctArray={0,2,1,3,10,8};
		int[] expectedIndexes={4,5};
		int target1 = 18;
		final int[] array = TwoSum.indexesOfTwoNumbers(correctArray,target1);
		assertArrayEquals(array,expectedIndexes);

	}


	public void testIndexesOfTwoNumbersAtThBegining() {

		int[] correctArray1={10,8,1,3,1,2};
		int[] expectedIndexes1={0,1};
		int target1 = 18;
		final int[] array = TwoSum.indexesOfTwoNumbers(correctArray1,target1);
		assertArrayEquals(array,expectedIndexes1);

	}
}