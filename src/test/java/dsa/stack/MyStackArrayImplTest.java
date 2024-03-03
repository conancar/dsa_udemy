package dsa.stack;

import junit.framework.TestCase;

import java.io.IOException;

import static dsa.MyMain.getBytesOfObject;
import static org.junit.Assert.assertThrows;

public class MyStackArrayImplTest extends TestCase {

	public void testCreate() throws IOException {
		MyStackArrayImpl<String> emptyStack = new MyStackArrayImpl<>(String.class, 10);
		System.out.println(emptyStack);
		System.out.println(getBytesOfObject(emptyStack));
		assertTrue(emptyStack.isEmpty());
		assertFalse(emptyStack.isFull());

	}

	public void testPush() throws IOException {
		MyStackArrayImpl<String> myStack = new MyStackArrayImpl<>(String.class, 1000);
		myStack.push("1");
		myStack.push("2");
		System.out.println(myStack);
		System.out.println(getBytesOfObject(myStack));
		assertFalse(myStack.isEmpty());
	}

	public void testPop() throws IOException {
		MyStackArrayImpl<String> myStack = new MyStackArrayImpl<>(String.class, 10);
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
		MyStackArrayImpl<String> myStack = new MyStackArrayImpl<>(String.class, 1000);
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
		MyStackArrayImpl<String> emptyStack = new MyStackArrayImpl<>(String.class, 1000);
		System.out.println(emptyStack);
		assertTrue(emptyStack.isEmpty());
		assertFalse(emptyStack.isFull());
	}

	public void testIsFull() {
		MyStackArrayImpl<String> myStack = new MyStackArrayImpl<>(String.class, 2);
		myStack.push("1");
		final String lastValue = "2";
		myStack.push(lastValue);
		assertThrows(IllegalArgumentException.class, () -> myStack.push(lastValue));

	}

	public void testClear() throws IOException {
		MyStackArrayImpl<String> myStackArray = new MyStackArrayImpl<>(String.class, 1000);
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