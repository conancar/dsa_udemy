package dsa.array;

import junit.framework.TestCase;

import static dsa.array.MaxProductOfTwoPositiveIntegers.ARRAY_TO_SHORT_MESSAGE;
import static dsa.array.MaxProductOfTwoPositiveIntegers.NEGATIVE_ELEMENT_IN_ARRAY_MESSAGE;
import static org.junit.Assert.assertThrows;


public class MaxProductOfTwoPositiveIntegersTest extends TestCase {

	public void testMaxProduct() {

		int[] intArray=new int[]{10,20,30,40,50};
		final String expected="(40,50)";

		final String actual = MaxProductOfTwoPositiveIntegers.findMaxElementsInArray(intArray);
		assertEquals(expected,actual);
	}

	public void testMaxProduct1() {

		int[] intArray=new int[]{50,40,30,20,10};
		final String expected="(40,50)";

		final String actual = MaxProductOfTwoPositiveIntegers.findMaxElementsInArray(intArray);
		assertEquals(expected,actual);
	}

	public void testMaxProduct2() {

		int[] intArray=new int[]{3,110,330,0,103};
		final String expected="(110,330)";

		final String actual = MaxProductOfTwoPositiveIntegers.findMaxElementsInArray(intArray);
		assertEquals(expected,actual);
	}

	public void testMaxProductArrayToSmall() {

		int[] intArray=new int[]{3};
		IllegalArgumentException exceptionEmpty=assertThrows(IllegalArgumentException.class, () -> MaxProductOfTwoPositiveIntegers.findMaxElementsInArray(intArray));

		String actualMessageEmpty = exceptionEmpty.getMessage();

		assertEquals(ARRAY_TO_SHORT_MESSAGE, actualMessageEmpty);
	}


	public void testForNegativeElementsInArray() {

		int[] intArray=new int[]{-3,5,10};
		IllegalArgumentException exceptionEmpty=assertThrows(IllegalArgumentException.class, () -> MaxProductOfTwoPositiveIntegers.findMaxElementsInArray(intArray));

		String actualMessageEmpty = exceptionEmpty.getMessage();

		assertEquals(NEGATIVE_ELEMENT_IN_ARRAY_MESSAGE, actualMessageEmpty);
	}

	public void testWhenDuplicatesInArray() {

		int[] intArray=new int[]{3,110,110,0,103};
		final String expected="(103,110)";

		final String actual = MaxProductOfTwoPositiveIntegers.findMaxElementsInArray(intArray);
		assertEquals(expected,actual);
	}

}