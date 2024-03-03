package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

import java.io.Serializable;

public class MyCircularSinglyLinkedList<T extends Serializable> extends MySinglyLinkedList<T> implements MyLinkedList<T> {


	public MyCircularSinglyLinkedList(T valueOfFirstNode) {
		super(valueOfFirstNode);
		this.head.setNext(this.getHead());

	}

	public MyCircularSinglyLinkedList() {
	}


	@Override
	public void add(T value, int position) {

		NodeSingly<T> addedNode = new NodeSingly<>(value);

		if (this.head == null) {
			this.head = addedNode;
			this.tail = addedNode;
			this.size++;
			addedNode.setNext(addedNode);
			return;
		} else if (position == 0) {
			addedNode.setNext(this.head);
			this.head = addedNode;
			this.tail.setNext(addedNode);
		} else if (position >= this.size) {
			this.tail.setNext(addedNode);
			this.tail = addedNode;
			addedNode.setNext(this.head);
		} else {
			NodeSingly<T> oneBeforePositionOfAdded = this.head;
			int index = 0;
			while (index < position - 1) {
				oneBeforePositionOfAdded = oneBeforePositionOfAdded.getNext();
				index++;
			}
			addedNode.setNext(oneBeforePositionOfAdded.getNext());
			oneBeforePositionOfAdded.setNext(addedNode);
		}
		this.size++;
	}

	@Override
	public void removeAtIndex(int index) {

		if (this.head == null) {
			return;
		}

		//delete from beginning
		if (index == 0) {
			this.head = this.head.getNext();
			this.tail.setNext(this.head);
			size--;
			if (size == 0) {
				this.head.setNext(null); //remove reference of element to itself
				this.head = null;
				this.tail = null;
			}
			//delete from end
		} else if (index >= this.getSize()) {
			NodeSingly<T> beforeLast = head;
			for (int i = 0; i < this.getSize() - 2; i++) {
				beforeLast = beforeLast.getNext();
			}
			beforeLast.setNext(this.head);
			this.tail = beforeLast;
			if (beforeLast == head) {
				beforeLast.setNext(null); //remove reference of element to itself
				this.tail = null;
				this.head = null;
			}
			size--;
		} else {
			NodeSingly<T> beforePositionOfDeletion = head;
			for (int i = 0; i < index - 1; i++) {
				beforePositionOfDeletion = beforePositionOfDeletion.getNext();
			}
			beforePositionOfDeletion.setNext(beforePositionOfDeletion.getNext().getNext());
			size--;
		}

	}

	@Override
	public void remove(T value) {

		if (this.head == null) {
			return;
		}

		NodeSingly<T> nodeThatContainsValue = head;
		NodeSingly<T> nodeBeforeOneThatNeedsToBeRemoved = head;

		boolean valueFound = false;
		for (int i = 0; i < this.size; i++) {
			nodeThatContainsValue = nodeThatContainsValue.getNext();
			if (nodeThatContainsValue.getValue().equals(value)) {
				valueFound = true;
				break;
			}
			nodeBeforeOneThatNeedsToBeRemoved = nodeBeforeOneThatNeedsToBeRemoved.getNext();
		}
		if (!valueFound) {
			return;
		}

		//first element to remove
		if (nodeThatContainsValue == head) {

			//only one element ws in linked list
			if (this.getSize() == 1) {
				this.head.setNext(null);
				this.head=null;
				this.tail=null;
				size--;
				return;

			}

			this.head = this.head.getNext();
			this.tail.setNext(this.head);
			size--;


		}
		//last element remove
		else if (nodeThatContainsValue == tail) {
			nodeBeforeOneThatNeedsToBeRemoved.setNext(this.head);
			this.tail = nodeBeforeOneThatNeedsToBeRemoved;
			//only one element ws in linked list
			if (this.getSize() == 0) {
				this.head.setNext(null);
				this.head=null;
				this.tail=null;
			}
			size--;
		} else {
			nodeBeforeOneThatNeedsToBeRemoved.setNext(nodeThatContainsValue.getNext());
			size--;
		}

	}

	@Override
	public void clear() {
		if (this.head == null) {
			return;
		}

		this.head=null;
		this.tail.setNext(null);
		this.tail=null;
		this.size=0;
	}

}





