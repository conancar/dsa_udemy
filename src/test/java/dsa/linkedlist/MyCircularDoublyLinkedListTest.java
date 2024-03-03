package dsa.linkedlist;

import junit.framework.TestCase;

import java.io.IOException;

import static dsa.MyMain.getBytesOfObject;
import static org.junit.Assert.assertNotEquals;

public class MyCircularDoublyLinkedListTest extends TestCase {


		public void testAdd() throws IOException {

			MyCircularDoublyLinkedList<String> test1 = new MyCircularDoublyLinkedList<>();
			test1.add("V5", 0);
			test1.add("V4", 0);
			test1.add("V3", 0);
			test1.add("V6", 10);
			test1.add("V1", 0);
			test1.add("V2", 1);
			test1.add("V5a", 5);

			System.out.println(test1);
			System.out.println(getBytesOfObject(test1));
			assertEquals(7, test1.getSize());

		}

	public void testContainsAtIndex() {
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add("V3",0);
		myCircularDoublyLinkedList.add("V6",10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final Integer indexOfValue=myCircularDoublyLinkedList.containsAtIndex(firstValue);
		assertNotNull(indexOfValue);
		assertEquals(0,indexOfValue.intValue());

		assertNotEquals(1,indexOfValue.intValue());
		System.out.println(myCircularDoublyLinkedList);

	}


	public void testRemoveWhenOnlyOneElementPresent() {

		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		myCircularDoublyLinkedList.add(firstValue,0);
		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.removeAtIndex(0);

		//then
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		final boolean containsNot=myCircularDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myCircularDoublyLinkedList);
	}


	public void testRemoveAtFirstIndex() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add("V3",0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		myCircularDoublyLinkedList.add("V4a",4);
		myCircularDoublyLinkedList.add("V4b",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);
		//when
		myCircularDoublyLinkedList.removeAtIndex(0);
		//then
		System.out.println(myCircularDoublyLinkedList);
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		final boolean containsNot=myCircularDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);
		final boolean contains=myCircularDoublyLinkedList.contains(lastValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveAtLastIndex() {

		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add("V3",0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.removeAtIndex(88);

		//then
		System.out.println(myCircularDoublyLinkedList );
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		final boolean containsNot=myCircularDoublyLinkedList.contains(lastValue);
		assertFalse(containsNot);
		final boolean contains=myCircularDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveAtMiddleIndex() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add(valueAtIndex2,0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.removeAtIndex(2);

		//then
		System.out.println(myCircularDoublyLinkedList);
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		final boolean containsNot=myCircularDoublyLinkedList.contains(valueAtIndex2);
		assertFalse(containsNot);
		final boolean contains=myCircularDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveAtMiddleIndexLastHalf() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add(valueAtIndex2,0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.removeAtIndex(4);

		//then
		System.out.println(myCircularDoublyLinkedList);
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		final boolean containsNot=myCircularDoublyLinkedList.contains("V5");
		assertFalse(containsNot);
		final boolean contains=myCircularDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}



	//***Remove value test
	public void testRemoveValueWhenOnlyOneElementPresent() {

		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		myCircularDoublyLinkedList.add(firstValue,0);
		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.remove(firstValue);

		//then
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		final boolean containsNot=myCircularDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myCircularDoublyLinkedList);
	}

	public void testRemoveFirstValue() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add("V3",0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.remove(firstValue);

		//then
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		System.out.println(myCircularDoublyLinkedList);
		final boolean containsNot=myCircularDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);
		final boolean contains=myCircularDoublyLinkedList.contains(lastValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
	}

	public void testRemoveLastValue() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add("V3",0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.remove(lastValue);

		//then
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);
		final boolean containsNot=myCircularDoublyLinkedList.contains(lastValue);
		assertFalse(containsNot);
		final boolean contains=myCircularDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveExistingValueInMiddle() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add(valueAtIndex2,0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.remove(valueAtIndex2);

		//then
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		final boolean containsNot=myCircularDoublyLinkedList.contains(valueAtIndex2);
		assertFalse(containsNot);
		final boolean contains=myCircularDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myCircularDoublyLinkedList);
	}

	public void testRemoveNonExistingValueInMiddle() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add(valueAtIndex2,0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myCircularDoublyLinkedList.getSize();
		System.out.println(myCircularDoublyLinkedList);

		final String nonExistingValue="ssss";

		//when
		myCircularDoublyLinkedList.remove(nonExistingValue);

		//then
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		assertEquals(0,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myCircularDoublyLinkedList);

	}

	public void testClearList() {
		//given
		MyCircularDoublyLinkedList<String> myCircularDoublyLinkedList=new MyCircularDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myCircularDoublyLinkedList.add("V5",0);
		myCircularDoublyLinkedList.add("V4",0);
		myCircularDoublyLinkedList.add(valueAtIndex2,0);
		myCircularDoublyLinkedList.add(lastValue,10);
		myCircularDoublyLinkedList.add(firstValue,0);
		myCircularDoublyLinkedList.add("V2",1);
		myCircularDoublyLinkedList.add("V5a",5);


		System.out.println(myCircularDoublyLinkedList);

		//when
		myCircularDoublyLinkedList.clear();

		//then
		final int sizeAfterRemoval=myCircularDoublyLinkedList.getSize();

		assertEquals(0,sizeAfterRemoval);
		System.out.println(myCircularDoublyLinkedList);

	}

}