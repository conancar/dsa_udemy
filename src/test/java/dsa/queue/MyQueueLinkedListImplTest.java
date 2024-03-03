package dsa.queue;

import junit.framework.TestCase;

import java.io.IOException;

import static dsa.MyMain.getBytesOfObject;

public class MyQueueLinkedListImplTest extends TestCase {

	public void testCreateQueue() {
		MyQueueLinkedListImpl<String> myQueue=new MyQueueLinkedListImpl<>();
		System.out.println(myQueue);
		assertTrue(myQueue.isEmpty());
		assertFalse(myQueue.isFull());
	}

	public void testEnQueue() {
		//given
		MyQueueLinkedListImpl<String> myQueue=new MyQueueLinkedListImpl<>();
		//when
		myQueue.enQueue("1");
		myQueue.enQueue("2");
		myQueue.enQueue("3");
		myQueue.enQueue("4");
		myQueue.enQueue("5");

		//then
		System.out.println(myQueue);
		assertFalse(myQueue.isEmpty());

	}

	public void testDeQueue() {
		//given
		MyQueueLinkedListImpl<String> myQueue=new MyQueueLinkedListImpl<>();
		final String first = "1";
		myQueue.enQueue(first);
		myQueue.enQueue("2");
		myQueue.enQueue("3");
		myQueue.enQueue("4");
		myQueue.enQueue("5");

		//when
		final String beginning = myQueue.deQueue();

		//then
		System.out.println(myQueue);
		assertFalse(myQueue.isEmpty());
		assertFalse(myQueue.isFull());
		assertEquals(first,beginning);
	}

	public void testDeQueue2() {
		//given
		MyQueueLinkedListImpl<String> myQueue=new MyQueueLinkedListImpl<>();
		final String first = "1";
		myQueue.enQueue(first);
		myQueue.enQueue("2");
		myQueue.enQueue("3");
		myQueue.enQueue("4");
		myQueue.enQueue("5");

		//when
		myQueue.deQueue();
		myQueue.deQueue();
		myQueue.deQueue();
		myQueue.deQueue();
		myQueue.deQueue();

		System.out.println(myQueue);

		myQueue.enQueue("11");
		//then
		assertFalse(myQueue.isEmpty());
		assertFalse(myQueue.isFull());
		System.out.println(myQueue);
	}

	public void testPeek() {
		//given
		MyQueueLinkedListImpl<String> myQueue=new MyQueueLinkedListImpl<>();
		final String first = "1";
		myQueue.enQueue(first);
		myQueue.enQueue("2");
		myQueue.enQueue("3");
		myQueue.enQueue("4");
		myQueue.enQueue("5");

		//when
		final String beginning = myQueue.peek();
		//then
		System.out.println(myQueue);
		assertFalse(myQueue.isEmpty());
		assertEquals(first,beginning);
	}

	public void testIsEmpty() {

		//given
		MyQueueLinkedListImpl<String> myQueue=new MyQueueLinkedListImpl<>();
		final String first = "1";
		myQueue.enQueue(first);
		myQueue.enQueue("2");
		myQueue.enQueue("3");
		myQueue.enQueue("4");
		myQueue.enQueue("5");

		myQueue.deQueue();
		myQueue.deQueue();
		myQueue.deQueue();
		myQueue.deQueue();
		myQueue.deQueue();

		//when

		//then
		System.out.println(myQueue);
		assertTrue(myQueue.isEmpty());
		assertFalse(myQueue.isFull());

	}



	public void testClear() throws IOException {
		//given
		MyQueueLinkedListImpl<String> myQueue=new MyQueueLinkedListImpl<>();
		final String first = "1";
		myQueue.enQueue(first);
		myQueue.enQueue("2");
		myQueue.enQueue("3");
		myQueue.enQueue("4");
		myQueue.enQueue("5");
		System.out.println(getBytesOfObject(myQueue));
		//when
		myQueue.clear();
		//then
		System.out.println(myQueue);
		System.out.println(getBytesOfObject(myQueue));
		assertFalse(myQueue.isFull());
		assertTrue(myQueue.isEmpty());
	}
}