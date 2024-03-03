package dsa.stack;

import junit.framework.TestCase;

import java.io.IOException;

import static dsa.MyMain.getBytesOfObject;

public class MyStackLinkedListImplTest extends TestCase {

	public void testCreate() throws IOException {
		MyStackLinkedListImpl<String> emptyStack = new MyStackLinkedListImpl<>();
		System.out.println(emptyStack);
		System.out.println(getBytesOfObject(emptyStack));
		assertTrue(emptyStack.isEmpty());
		assertFalse(emptyStack.isFull());

	}

	public void testPush() throws IOException {
		MyStackLinkedListImpl<String> myStack = new MyStackLinkedListImpl<>();
		myStack.push("1");
		myStack.push("2");
		System.out.println(myStack);
		System.out.println(getBytesOfObject(myStack));
		assertFalse(myStack.isEmpty());
	}

	public void testPop() throws IOException {
		MyStackLinkedListImpl<String> myStack = new MyStackLinkedListImpl<>();
		myStack.push("1");
		final String lastValue = "2";
		myStack.push(lastValue);
		System.out.println(getBytesOfObject(myStack));

		final String popped = myStack.pop();
		System.out.println(myStack);
		System.out.println(getBytesOfObject(myStack));
		assertFalse(myStack.isEmpty());
		assertEquals(lastValue, popped);
	}

	public void testPeek() throws IOException {
		MyStackLinkedListImpl<String> myStack = new MyStackLinkedListImpl<>();
		myStack.push("1");
		final String lastValue = "2";
		myStack.push(lastValue);
		System.out.println(getBytesOfObject(myStack));

		final String peeked = myStack.peek();
		System.out.println(myStack);
		System.out.println(getBytesOfObject(myStack));
		assertFalse(myStack.isEmpty());
		assertEquals(lastValue, peeked);
	}

	public void testIsEmpty() {
		MyStackLinkedListImpl<String> emptyStack = new MyStackLinkedListImpl<>();
		System.out.println(emptyStack);
		assertTrue(emptyStack.isEmpty());
		assertFalse(emptyStack.isFull());
	}

	public void testIsFull() {
		MyStackLinkedListImpl<String> myStack = new MyStackLinkedListImpl<>();
		myStack.push("1");
		final String lastValue = "2";
		myStack.push(lastValue);

		assertFalse(myStack.isFull());

	}

	public void testClear() throws IOException {
		MyStackLinkedListImpl<String> myStackArray = new MyStackLinkedListImpl<>();
		for (int i = 0; i < 1000; i++) {
			myStackArray.push("aaaaaaaascdasdcasdddddddddddddddccsacsacas");
		}
		System.out.println(getBytesOfObject(myStackArray));

		//when
		myStackArray.clear();
		System.out.println(getBytesOfObject(myStackArray));
		assertTrue(myStackArray.isEmpty());


	}
}