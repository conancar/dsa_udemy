package dsa.linkedlist.node;


import java.io.Serializable;

public class NodeDoubly<T extends Serializable > implements MyNode<T>  {

	private T value;

	private NodeDoubly<T> next;
	private  NodeDoubly<T> previous;

	public NodeDoubly(T value) {
		this.value = value;
	}

	public NodeDoubly(T value, NodeDoubly<T> next, NodeDoubly<T> previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	@Override
	public String toString() {
		return value + "["+ this.hashCode()+"]";
	}
	@Override
	public T getValue() {
		return value;
	}
	@Override
	public void setValue(T value) {
		this.value = value;
	}

	public NodeDoubly<T> getNext() {
		return next;
	}

	public void setNext(NodeDoubly<T> next) {
		this.next = next;
	}

	public NodeDoubly<T> getPrevious() {
		return previous;
	}

	public void setPrevious(NodeDoubly<T> previous) {
		this.previous = previous;
	}
}
