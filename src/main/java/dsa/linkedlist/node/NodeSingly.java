package dsa.linkedlist.node;

import java.io.Serializable;

public class NodeSingly<T extends Serializable> implements MyNode<T> {

	private T value;
	private NodeSingly<T> next;

	public NodeSingly(T value, NodeSingly<T> next) {
		this.value = value;
		this.next = next;
	}

	public NodeSingly(T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}


	public NodeSingly<T> getNext() {
		return next;
	}

	public void setNext(NodeSingly<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "value=" + value + "["+ this.hashCode()+"]" ;
	}
}
