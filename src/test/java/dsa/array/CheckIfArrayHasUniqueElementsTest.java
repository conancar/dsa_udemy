package dsa.array;

import junit.framework.TestCase;

public class CheckIfArrayHasUniqueElementsTest extends TestCase {

	public void testCheckIfArrayIsUniqueTrue() {
		int[] uniqueArray={1,3,5,4,6};
		boolean expected=true;
		final boolean actual = CheckIfArrayHasUniqueElements.checkIfArrayIsUnique(uniqueArray);
		assertEquals(expected,actual);

	}

	public void testCheckIfArrayIsUniqueFalse() {
		int[] uniqueArray={1,3,5,4,6,1};
		boolean expected=false;
		final boolean actual = CheckIfArrayHasUniqueElements.checkIfArrayIsUnique(uniqueArray);
		assertEquals(expected,actual);

	}
}