package dsa.queue;


import dsa.linkedlist.node.NodeSingly;

import java.io.Serializable;

public class MyQueueLinkedListImpl<T extends Serializable> implements MyQueue<T> {

	private NodeSingly<T> head;
	private NodeSingly<T> tail;


	public MyQueueLinkedListImpl() {
		head = null;
		tail = null;

	}

	@Override
	public void enQueue(T value) {

		NodeSingly<T> addedElement = new NodeSingly<>(value);
		if (head == null) {
			head = addedElement;
			tail = addedElement;
		} else {
			tail.setNext(addedElement);
			tail = addedElement;
		}

	}

	@Override
	public T deQueue() {
		T value = peek();
		head = head.getNext();
		return value;
	}

	@Override
	public T peek() {
		if (head == null) {
			throw new IllegalArgumentException("Queue is empty");
		}
		return head.getValue();
	}


	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void clear() {


		head = null;
		tail = null;

	}

	@Override
	public String toString() {
		if (this.isEmpty()) {
			return "Queue is empty";
		}
		StringBuilder sb = new StringBuilder("beginning<-");
		NodeSingly<T> jumper = head;
		while (jumper != null) {
			sb.append(jumper.getValue());
			sb.append("<-");
			jumper = jumper.getNext();
		}
		sb.append("|top");
		return sb.toString();
	}
}
