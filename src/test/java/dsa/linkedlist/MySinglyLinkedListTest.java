package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;
import junit.framework.TestCase;

import java.io.IOException;

import static dsa.MyMain.getBytesOfObject;
import static org.junit.Assert.assertNotEquals;

public class MySinglyLinkedListTest extends TestCase {

	public void testAdd() throws IOException {
		MyLinkedList<String> test1=new MySinglyLinkedList<>();
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

	public void testAddOnEmpty() throws IOException {
		//given
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		//when
		final String nodeValue = "aa";
		test.add(nodeValue,3);
		//then
		System.out.println(test);
		System.out.println(getBytesOfObject(test));
		assertEquals(1,test.getSize());
		assertEquals(nodeValue, test.getHead().getValue());
		assertEquals(nodeValue, test.getTail().getValue());
		assertEquals(test.getHead().getValue(),test.getTail().getNext().getValue());

	}

	public void testPrintEmptyLinkedList() {
		MyLinkedList<String> test1=new MySinglyLinkedList<>();

		System.out.println(test1);

	}
	public void testContainsAtIndex() {
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add("V3",0);
		myLinkedListSingly.add("V6",10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final Integer indexOfValue=myLinkedListSingly.containsAtIndex(firstValue);
		assertNotNull(indexOfValue);
		assertEquals(0,indexOfValue.intValue());

		assertNotEquals(1,indexOfValue.intValue());
		System.out.println(myLinkedListSingly);

	}

	public void testContains() {
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add("V3",0);
		myLinkedListSingly.add("V6",10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final boolean contains=myLinkedListSingly.contains(firstValue);
		final boolean containsNot=myLinkedListSingly.contains("ddd");

		assertTrue(contains);
		assertFalse(containsNot);

	}

	public void testRemoveWhenOnlyOneElementPresent() {

		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		myLinkedListSingly.add(firstValue,0);
		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.removeAtIndex(0);

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		final boolean containsNot=myLinkedListSingly.contains(firstValue);
		assertFalse(containsNot);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myLinkedListSingly);
	}


	public void testRemoveAtFirstIndex() {
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add("V3",0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);
		myLinkedListSingly.removeAtIndex(0);

		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		final boolean containsNot=myLinkedListSingly.contains(firstValue);
		assertFalse(containsNot);
		final boolean contains=myLinkedListSingly.contains(lastValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myLinkedListSingly);
	}

	public void testRemoveAtLastIndex() {

		//given
		MySinglyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add("V3",0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.removeAtIndex(88);

		//then
		System.out.println(myLinkedListSingly );
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		final boolean containsNot=myLinkedListSingly.contains(lastValue);
		assertFalse(containsNot);
		final boolean contains=myLinkedListSingly.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveAtMiddleIndex() {
		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add(valueAtIndex2,0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.removeAtIndex(2);

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		final boolean containsNot=myLinkedListSingly.contains(valueAtIndex2);
		assertFalse(containsNot);
		final boolean contains=myLinkedListSingly.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myLinkedListSingly);
	}

	public void testRemoveValueWhenOnlyOneElementPresent() {

		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		myLinkedListSingly.add(firstValue,0);
		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.remove(firstValue);

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		final boolean containsNot=myLinkedListSingly.contains(firstValue);
		assertFalse(containsNot);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myLinkedListSingly);
	}

	public void testRemoveFirstValue() {
		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add("V3",0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.remove(firstValue);

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		System.out.println(myLinkedListSingly);
		final boolean containsNot=myLinkedListSingly.contains(firstValue);
		assertFalse(containsNot);
		final boolean contains=myLinkedListSingly.contains(lastValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
	}

	public void testRemoveLastValue() {
		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add("V3",0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.remove(lastValue);

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);
		final boolean containsNot=myLinkedListSingly.contains(lastValue);
		assertFalse(containsNot);
		final boolean contains=myLinkedListSingly.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);

	}

	public void testRemoveExistingValueInMiddle() {
		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add(valueAtIndex2,0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.remove(valueAtIndex2);

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		final boolean containsNot=myLinkedListSingly.contains(valueAtIndex2);
		assertFalse(containsNot);
		final boolean contains=myLinkedListSingly.contains(firstValue);
		assertTrue(contains);

		assertEquals(1,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myLinkedListSingly);
	}

	public void testRemoveNonExistingValueInMiddle() {
		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add(valueAtIndex2,0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);

		final int sizeBeforeRemoval=myLinkedListSingly.getSize();
		System.out.println(myLinkedListSingly);

		final String nonExistingValue="ssss";

		//when
		myLinkedListSingly.remove(nonExistingValue);

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		assertEquals(0,sizeBeforeRemoval-sizeAfterRemoval);
		System.out.println(myLinkedListSingly);

	}

	public void testClearList() {
		//given
		MyLinkedList<String> myLinkedListSingly=new MySinglyLinkedList<>();
		final String firstValue = "V1";
		final String lastValue = "V6";
		final String valueAtIndex2 = "V3";
		myLinkedListSingly.add("V5",0);
		myLinkedListSingly.add("V4",0);
		myLinkedListSingly.add(valueAtIndex2,0);
		myLinkedListSingly.add(lastValue,10);
		myLinkedListSingly.add(firstValue,0);
		myLinkedListSingly.add("V2",1);
		myLinkedListSingly.add("V5a",5);


		System.out.println(myLinkedListSingly);

		//when
		myLinkedListSingly.clear();

		//then
		final int sizeAfterRemoval=myLinkedListSingly.getSize();

		assertEquals(0,sizeAfterRemoval);
		System.out.println(myLinkedListSingly);

	}


	public void testAddNodeAtEnd() {
		//given
		MySinglyLinkedList<Integer> myLinkedListSingly=new MySinglyLinkedList<>();
		NodeSingly<Integer> node1=new NodeSingly<>(1);
		NodeSingly<Integer> node2=new NodeSingly<>(2);
		NodeSingly<Integer> node3=new NodeSingly<>(3);

		//when
		myLinkedListSingly.addNodeAtEnd(node1);
		myLinkedListSingly.addNodeAtEnd(node2);
		myLinkedListSingly.addNodeAtEnd(node3);


		//then
		System.out.println(myLinkedListSingly);
		final int sizeAfter=myLinkedListSingly.getSize();

		assertEquals(3,sizeAfter);

	}
}