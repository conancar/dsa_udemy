package dsa.linkedlist;

import junit.framework.TestCase;

import java.io.IOException;

import static dsa.MyMain.getBytesOfObject;

public class MyCircularSinglyLinkedListTest extends TestCase {

	public void testCreation() {

		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>("aa");
		System.out.println(test);

		System.out.println(test.getHead().getNext());

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
		System.out.println(getBytesOfObject(test.getHead().getValue()));
		System.out.println(getBytesOfObject(test.getTail()));
		System.out.println(getBytesOfObject(test.getSize()));
		assertEquals(1,test.getSize());
		assertEquals(nodeValue, test.getHead().getValue());
		assertEquals(nodeValue, test.getTail().getValue());
		assertEquals(test.getHead().getValue(),test.getTail().getNext().getValue());

	}

	public void testAddOnStartNotEmpty() {
		//given
		final String firstNodeValueBefore = "E2";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>(firstNodeValueBefore);
		//when
		final String nodeValue = "E1";
		test.add(nodeValue,0);
		//then
		System.out.println(test);
		assertEquals(2,test.getSize());
		assertEquals(nodeValue, test.getHead().getValue());
		assertEquals(test.getHead().getValue(), test.getTail().getNext().getValue());
		assertEquals(test.getHead(), test.getTail().getNext());
	}

	public void testAddOnEndNotEmpty() {
		//given
		final String lastNodeValueBefore = "E2";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>(lastNodeValueBefore);
		test.add(firstNodeValueBefore,0);
		//when
		final String nodeValue = "E3";
		test.add(nodeValue,5);
		//then
		System.out.println(test );
		assertEquals(3,test.getSize());
		assertEquals(nodeValue, test.getTail().getValue());
		assertEquals(test.getHead().getValue(), test.getTail().getNext().getValue());
		assertEquals(test.getHead(), test.getTail().getNext());

	}

	public void testAddMiddle() throws IOException {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1111111111111111111111111111111111111111222222222222222";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add("Ess2dfedddddddddddddddddddqwwwwwwwwwwwwww wefffffffffffewfffffffffffffffffffffffffffffffffffffffffffffefffffbgvtttttttttteeeeF",0);
		test.add(firstNodeValueBefore,0);
		//when
		final String nodeValue = "EI";
		test.add(nodeValue,3);
		//then
		System.out.println(test );
		assertEquals(7,test.getSize());
		assertEquals(lastNodeValueBefore, test.getTail().getValue());
		assertEquals(test.getHead().getValue(), firstNodeValueBefore);
		assertEquals(test.getHead(), test.getTail().getNext());
		System.out.println("Cela Lista ="+getBytesOfObject(test));
		System.out.println("Size int="+getBytesOfObject(test.getSize()));

	}

	public void testRemoveAtIndexFromBeginningMoreThanOneElement() {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add(firstNodeValueBefore,0);
		//when
		test.removeAtIndex(0);
		//then
		System.out.println(test);
		assertEquals(test.getHead().getValue(),"E2");
		assertEquals(test.getTail().getNext().getValue(),"E2");

	}
	public void testRemoveAtIndexFromBeginningOnlyOneElement() {
		//given
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>(firstNodeValueBefore);

		//when
		test.removeAtIndex(0);
		//then
		System.out.println(test );
		assertNull(test.getHead());
		assertNull(test.getTail());
	}

	public void testRemoveAtIndexFromEndMoreThanOneElement() {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add(firstNodeValueBefore,0);
		System.out.println(test);
		//when
		test.removeAtIndex(88);
		//then
		System.out.println(test);

		assertEquals("E4",test.getTail().getValue());
		assertEquals("E1",test.getTail().getNext().getValue());

	}

	public void testRemoveAtIndexFromEndOnlyOneElement() {
		//given
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>(firstNodeValueBefore);

		//when
		test.removeAtIndex(88);
		//then
		assertNull(test.getHead());
		assertNull(test.getTail());
	}


	public void testRemoveAtIndexMiddle() {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add(firstNodeValueBefore,0);
		int sizeBefore=test.getSize();
		System.out.println(test);
		//when
		test.removeAtIndex(2);
		//then
		int sizeAfter=test.getSize();
		System.out.println(test);

		final boolean containsNot=test.contains("E3");
		assertFalse(containsNot);
		final boolean contains=test.contains("E2");
		assertTrue(contains);

		assertEquals(1,sizeBefore-sizeAfter);

	}


	public void testRemoveAtIndexMiddleFromBack() {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add(firstNodeValueBefore,0);
		int sizeBefore=test.getSize();
		System.out.println(test);
		//when
		test.removeAtIndex(3);
		//then
		int sizeAfter=test.getSize();
		System.out.println(test);

		final boolean containsNot=test.contains("E4");
		assertFalse(containsNot);
		final boolean contains=test.contains("E3");
		assertTrue(contains);

		assertEquals(1,sizeBefore-sizeAfter);

	}



	public void testRemoveValueFromBeginningMoreThanOneElement() {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add(firstNodeValueBefore,0);
		int sizeBefore=test.getSize();
		System.out.println(test);
		//when
		test.remove(firstNodeValueBefore);
		//then
		int sizeAfter=test.getSize();
		System.out.println(test);
		assertEquals(test.getHead().getValue(),"E2");
		assertEquals(test.getTail().getNext().getValue(),"E2");
		assertEquals(1,sizeBefore-sizeAfter);
	}
	public void testRemoveValueFromBeginningOnlyOneElement() {
		//given
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>(firstNodeValueBefore);
		System.out.println(test);
		//when
		test.remove(firstNodeValueBefore);
		//then
		System.out.println(test);
		assertNull(test.getHead());
		assertNull(test.getTail());
	}

	public void testRemoveValueFromEndMoreThanOneElement() {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add(firstNodeValueBefore,0);
		int sizeBefore=test.getSize();
		System.out.println(test);
		//when
		test.remove(lastNodeValueBefore);
		//then
		int sizeAfter=test.getSize();
		System.out.println(test);

		assertEquals("E4",test.getTail().getValue());
		assertEquals("E1",test.getTail().getNext().getValue());
		assertEquals(1,sizeBefore-sizeAfter);
	}

	public void testRemoveValueFromEndOnlyOneElement() {
		//given
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>(firstNodeValueBefore);
		System.out.println(test);
		//when
		test.remove(firstNodeValueBefore);
		//then
		System.out.println(test);
		assertNull(test.getHead());
		assertNull(test.getTail());
	}


	public void testRemoveValueMiddle() {
		//given
		final String lastNodeValueBefore = "E5";
		final String firstNodeValueBefore = "E1";
		MyCircularSinglyLinkedList<String> test=new MyCircularSinglyLinkedList<>();
		test.add(lastNodeValueBefore,0);
		test.add("E4",0);
		test.add("E3",0);
		test.add("E2",0);
		test.add(firstNodeValueBefore,0);
		int sizeBefore=test.getSize();
		System.out.println(test);
		//when
		test.remove("E3");
		//then
		int sizeAfter=test.getSize();
		System.out.println(test);

		final boolean containsNot=test.contains("E3");
		assertFalse(containsNot);
		final boolean contains=test.contains("E2");
		assertTrue(contains);

		assertEquals(1,sizeBefore-sizeAfter);

	}
}