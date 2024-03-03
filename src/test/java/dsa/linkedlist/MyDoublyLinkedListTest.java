package dsa.linkedlist;

import junit.framework.TestCase;

import java.io.IOException;

import static dsa.MyMain.getBytesOfObject;
import static org.junit.Assert.assertNotEquals;

public class MyDoublyLinkedListTest extends TestCase {

	public void testAdd() throws IOException {

		MyDoublyLinkedList<String> test1=new MyDoublyLinkedList<>();
		test1.add("V5",0);
		test1.add("V4",0);
		test1.add("V3",0);
		test1.add("V6",10);
		test1.add("V1",0);
		test1.add("V2",1);
		test1.add("V5a",5);

		System.out.println(test1);
		System.out.println(getBytesOfObject(test1));
		assertEquals(7,test1.getSize());

	}

	public void testContainsAtIndex() {
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add("V3",0);
		myDoublyLinkedList.add("V6",10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		final Integer indexOfValue=myDoublyLinkedList.containsAtIndex(firstValue);
		assertNotNull(indexOfValue);
		assertEquals(0,indexOfValue.intValue());

		assertNotEquals(1,indexOfValue.intValue());
		System.out.println(myDoublyLinkedList);

	}

	public void testRemoveWhenOnlyOneElementPresent() {

		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		myDoublyLinkedList.add(firstValue,0);
		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.removeAtIndex(0);

		//then
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		final boolean containsNot=myDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myDoublyLinkedList);
	}


	public void testRemoveAtFirstIndex() {
		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add("V3",0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		myDoublyLinkedList.add("V4a",4);
		myDoublyLinkedList.add("V4b",5);

		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);
		//when
		myDoublyLinkedList.removeAtIndex(0);
		//then
		System.out.println(myDoublyLinkedList);
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		final boolean containsNot=myDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);
		final boolean contains=myDoublyLinkedList.contains(lastValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myDoublyLinkedList);
	}

	public void testRemoveAtLastIndex() {

		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add("V3",0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.removeAtIndex(88);

		//then
		System.out.println(myDoublyLinkedList );
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		final boolean containsNot=myDoublyLinkedList.contains(lastValue);
		assertFalse(containsNot);
		final boolean contains=myDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveAtMiddleIndex() {
		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add(valueAtIndex2,0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.removeAtIndex(2);

		//then
		System.out.println(myDoublyLinkedList);
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		final boolean containsNot=myDoublyLinkedList.contains(valueAtIndex2);
		assertFalse(containsNot);
		final boolean contains=myDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}


	//***Remove value test
	public void testRemoveValueWhenOnlyOneElementPresent() {

		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		myDoublyLinkedList.add(firstValue,0);
		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.remove(firstValue);

		//then
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		final boolean containsNot=myDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myDoublyLinkedList);
	}

	public void testRemoveFirstValue() {
		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add("V3",0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.remove(firstValue);

		//then
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		System.out.println(myDoublyLinkedList);
		final boolean containsNot=myDoublyLinkedList.contains(firstValue);
		assertFalse(containsNot);
		final boolean contains=myDoublyLinkedList.contains(lastValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
	}

	public void testRemoveLastValue() {
		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add("V3",0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.remove(lastValue);

		//then
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);
		final boolean containsNot=myDoublyLinkedList.contains(lastValue);
		assertFalse(containsNot);
		final boolean contains=myDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveExistingValueInMiddle() {
		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add(valueAtIndex2,0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.remove(valueAtIndex2);

		//then
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		final boolean containsNot=myDoublyLinkedList.contains(valueAtIndex2);
		assertFalse(containsNot);
		final boolean contains=myDoublyLinkedList.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myDoublyLinkedList);
	}

	public void testRemoveNonExistingValueInMiddle() {
		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add(valueAtIndex2,0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);

		final int sizeBeforeRemoval=myDoublyLinkedList.getSize();
		System.out.println(myDoublyLinkedList);

		final String nonExistingValue="ssss";

		//when
		myDoublyLinkedList.remove(nonExistingValue);

		//then
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		assertEquals(0,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myDoublyLinkedList);

	}

	public void testClearList() {
		//given
		MyDoublyLinkedList<String> myDoublyLinkedList=new MyDoublyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myDoublyLinkedList.add("V5",0);
		myDoublyLinkedList.add("V4",0);
		myDoublyLinkedList.add(valueAtIndex2,0);
		myDoublyLinkedList.add(lastValue,10);
		myDoublyLinkedList.add(firstValue,0);
		myDoublyLinkedList.add("V2",1);
		myDoublyLinkedList.add("V5a",5);


		System.out.println(myDoublyLinkedList);

		//when
		myDoublyLinkedList.clear();

		//then
		final int sizeAfterRemoval=myDoublyLinkedList.getSize();

		assertEquals(0,sizeAfterRemoval);
		System.out.println(myDoublyLinkedList);

	}




}