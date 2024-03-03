package dsa.queue;

import java.io.Serializable;

public interface MyQueue<T extends Serializable> extends Serializable{

	/**
	 * Adds element to the top of the queue
	 * @param value  element value
	 */
	void enQueue(T value);

	/**
	 * removes element from beginning of Queue and returns it
	 * @return elemet value
	 */
	T deQueue();

	/**
	 * gets element value from beginning of queue without removing it
	 * @return element value
	 */
	T peek();


	/**
	 * Cannot deQueue from empty queue
	 * @return t/f
	 */
	boolean isEmpty();

	/**
	 * Cannot enQueue to full queue
	 * @return t/f
	 */
	boolean isFull();


	void clear();

}
