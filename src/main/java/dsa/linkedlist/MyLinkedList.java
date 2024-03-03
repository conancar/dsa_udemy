package dsa.linkedlist;

import dsa.linkedlist.node.MyNode;

import java.io.Serializable;

public interface MyLinkedList<T extends Serializable> extends Serializable {

	MyNode<T> getHead();

	MyNode<T> getTail();

	int getSize();

	/**
	 * Adds node to a linkedList with value at index position
	 *
	 * @param valueForNode value for node
	 * @param position     position can be at :
	 *                     beginning of a list (position=0)  (O1)
	 *                     end of a list (position>=size) (O1)
	 *                     anywhere in between O(N)
	 */
	void add(T valueForNode, int position);

	/**
	 * Prints to STOUT all elements of Linked list
	 *
	 * @return Comma delimited linked list elements
	 */
	String toString();

	/**
	 * Loops over LinkedList and return index of first(if same multiple values are present) element where value is found
	 *
	 * @param value value we seek
	 * @return index of value, null if not found
	 */
	Integer containsAtIndex(T value);

	/**
	 * Loops over LinkedList and return if at least one element of linked list has value provided in argument
	 *
	 * @param value value we seek
	 *              * @return linked list contains value
	 */
	boolean contains(T value);

	/**
	 * Removes element at given index. If index i greater then list size removes last element
	 *
	 * @param index index of element to be removed
	 */
	void removeAtIndex(int index);

	/**
	 * Removes element of linked list at index first found(if same multiple values are present)
	 *
	 * @param value value to remove
	 */
	void remove(T value);

	/**
	 * Removes all elements from list
	 */
	void clear();

}
