package dsa.stack;

import java.io.Serializable;

public interface MyStack<T extends  Serializable> extends Serializable {

	/**
	 * Adds a value at a top of a stack, increase size by one
	 *
	 * @param value - element to add
	 */
	void push(T value);

	/**
	 * Returns top element of stack and removes it from stack. Decrease size by one
	 * @return top element
	 */
	T pop();

	/**
	 * Does not remove top element, just returns it. Size stays the same
	 * @return top element
	 */
	T peek();

	/**
	 * Checks if stack is empty
	 * @return true/false
	 */
	boolean isEmpty();

	/**
	 * If stack has limited fixed size returns if stack is full and cannot take any more elements (implemented using array)
	 * @return true/false
	 */
	boolean isFull();

	/**
	 * removes all elements, size=0
	 */
	void clear();
}
