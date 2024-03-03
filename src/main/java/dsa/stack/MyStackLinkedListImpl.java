package dsa.stack;

import dsa.linkedlist.node.NodeSingly;

import java.io.Serializable;


public class MyStackLinkedListImpl<T extends Serializable> implements MyStack<T> {

	private NodeSingly<T> head = null;

	public MyStackLinkedListImpl() {

	}

	@Override
	public void push(T value) {
		NodeSingly<T> node=new NodeSingly<>(value);
		node.setNext(this.head);
		this.head=node;
	}

	@Override
	public T pop() {
		final T value = this.peek();
		this.head=this.head.getNext();
		return value;
	}

	@Override
	public T peek() {
		if(this.head==null){
			throw new IllegalArgumentException("Stack is empty");
		}
		return this.head.getValue();
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void clear() {
		this.head = null;
	}

	@Override
	public String toString() {
		if (this.isEmpty()) {
			return "Stack is empty";
		}
		NodeSingly<T> jumper = this.head;
		StringBuilder sb = new StringBuilder();
		while (jumper != null) {
			sb.append(jumper.getValue());
			sb.append("<-");
			jumper = jumper.getNext();
		}
		sb.deleteCharAt(sb.length() - 2);
		sb.deleteCharAt(sb.length() - 1);
		sb.append("|");

		return sb.toString();
	}
}
