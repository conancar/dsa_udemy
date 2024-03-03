package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

import java.io.Serializable;

public class MySinglyLinkedList<T extends Serializable> implements MyLinkedList<T> {

	protected NodeSingly<T> head;
	protected NodeSingly<T> tail;
	protected int size = 0;

	/**
	 * Constructor creates new MyLinkedList Object with one node
	 *
	 * @param valueOfFirstNode - value of first node
	 */
	public MySinglyLinkedList(T valueOfFirstNode) {

		//crate first node ,set value and null as reference for next node
		NodeSingly<T> firstNode = new NodeSingly<>(valueOfFirstNode, null);

		//reference head of linkedList to one and only node
		this.head = firstNode;
		//reference tail of linkedList to one and only node
		this.tail = firstNode;
		this.size = 1;

	}

	public MySinglyLinkedList() {
	}

	@Override
	public void add(T valueForNode, int position) {

		NodeSingly<T> addedNode = new NodeSingly<>(valueForNode);
		//debugNode(addedNode, "START! node added");


		if (this.head == null) {//No element in List, List is only initialised
			this.head = addedNode;
			this.tail = addedNode;

		} else if (position == 0) {//Insert at the beginning
			addedNode.setNext(head);
			this.head = addedNode;

		} else if (position >= this.size) {//Insert at the end
			addedNode.setNext(null);
			//debugNode(this.tail, "TAIL BEFORE NODE ADDED AT END");
			tail.setNext(addedNode);
			this.tail = addedNode;
			//debugNode(this.tail, "TAIL AFTER NODE ADDED AT END");
		} else { //insert at specific middle position
			NodeSingly<T> jumper = head; // create jumper at the beginning. Goal is to get him one place before desired position of addedNode
			//debugJumper(jumper, "Created");
			int index = 0;
			while (index < position - 1) {
				jumper = jumper.getNext(); //jump one by one
				//debugJumper(jumper, "Jumping");
				index++;
			}

			//now jumper is at desired position one before we want to put addedNode
			//get next as node after
			NodeSingly<T> nodeAfter = jumper.getNext();
			//add newly created node after jumper
			jumper.setNext(addedNode);
			//redirect noeAfter from jumper to addedNode
			addedNode.setNext(nodeAfter);


		}
		size++;
	}

	public void addNodeAtEnd(NodeSingly<T> node){
		if(this.head==null){
			this.head=node;
		}else{
			this.tail.setNext(node);
		}
		this.tail=node;
		this.size++;
	}


	private void debugJumper(NodeSingly<T> jumper, String action) {
		System.out.println(action + "-->" + " JUMPER=" + jumper);
	}

	private void debugNode(NodeSingly<T> node, String action) {
		System.out.println(action + "-->" + (node.getValue() == null ? "NULL value" : node));
	}

	@Override
	public NodeSingly<T> getHead() {
		return head;
	}

	@Override
	public NodeSingly<T> getTail() {
		return tail;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		NodeSingly<T> jumper = head; // create jumper
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size; i++) {
			sb.append(jumper);
			if (i < this.size - 1) {
				sb.append(",");
			}
			jumper = jumper.getNext();
		}
		sb.append(" HEAD=").append(this.getHead()).append(" TAIL=").append(this.getTail()).append(" NEXT OF LAST =").append(this.getTail() == null ? null : this.getTail().getNext());

		return sb.toString();
	}

	@Override
	public Integer containsAtIndex(T value) {

		if (head == null) {
			return null;
		}

		NodeSingly<T> jumper = head;
		for (int i = 0; i < this.size; i++) {
			if (value.equals(jumper.getValue())) {
				return i;
			}
			jumper = jumper.getNext();
		}
		return null;
	}

	@Override
	public boolean contains(T value) {
		return this.containsAtIndex(value) != null;
	}

	@Override
	public void removeAtIndex(int index) {
		if (this.head == null) {
			return;
		}
		//remove first element
		if (index == 0) {
			this.head = this.head.getNext(); // set reference on second element, no one is referencing first one GC will collect (except maybe tail,will be checked)
			this.size--;
			if (size == 0) {
				//it was single element in list, tail must ref to null
				tail = this.head;
			}
		}
		//remove last element
		else if (index >= this.size) {
			NodeSingly<T> jumperToOneBeforeLast = this.head;
			for (int i = 0; i < this.size - 2; i++) {
				jumperToOneBeforeLast = jumperToOneBeforeLast.getNext();
			}
			jumperToOneBeforeLast.setNext(null); //no one is referencing on last, except maybe head
			tail = jumperToOneBeforeLast;
			size--;

			if (size == 0) {
				this.head = null;
			}
		}
		//remove element at index
		else {
			NodeSingly<T> jumperToOneBeforeIndex = this.head;
			for (int i = 0; i < (index - 1); i++) {
				jumperToOneBeforeIndex = jumperToOneBeforeIndex.getNext();
			}
			jumperToOneBeforeIndex.setNext(jumperToOneBeforeIndex.getNext().getNext()); //no one is referencing element at index
			size--;
		}
	}

	@Override
	public void remove(T value) {

		if (this.head == null) {
			return;
		}

		//find if value is in list
		NodeSingly<T> seeker = this.head;
		NodeSingly<T> oneBeforeFound = this.head;
		boolean valueFound = false;
		for (int i = 0; i < this.size; i++) {
			if (seeker.getValue().equals(value)) {
				valueFound = true;
				break;
			}
			seeker = seeker.getNext();
			if (i > 0) {
				oneBeforeFound = oneBeforeFound.getNext();
			}
		}

		//no value found
		if (!valueFound) {
			return;
		}
		size--;

		//first element case
		if (seeker == this.head) {
			//only one element was present
			if (this.size == 0) {
				this.head = null;
				this.tail = null;

			}//remove from first position
			else {
				this.head = seeker.getNext();
			}
			return;
		}//value is found at last element
		else if (seeker == this.tail) {
			this.tail = oneBeforeFound;
		}
		oneBeforeFound.setNext(seeker.getNext());

	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

}





