package dsa.linkedlist;

import dsa.linkedlist.node.NodeDoubly;

import java.io.Serializable;

public class MyDoublyLinkedList<T extends Serializable> implements MyLinkedList<T> {

	protected NodeDoubly<T> head;
	protected NodeDoubly<T> tail;
	protected int size;

	public MyDoublyLinkedList(T value) {
		NodeDoubly<T> firstNode = new NodeDoubly<>(value);
		this.head = firstNode;
		this.tail = firstNode;
		this.size = 1;
	}

	public MyDoublyLinkedList() {
	}

	@Override
	public void add(T value, int position) {
		NodeDoubly<T> addedNode = new NodeDoubly<>(value);
		if(this.head==null){
			this.head=addedNode;
			this.tail=addedNode;
			this.size=1;
			return;
		}else	if(position==0){
			this.head.setPrevious(addedNode);
			addedNode.setNext(this.head);
			this.head = addedNode;

		}else if(position>=this.size){
			this.tail.setNext(addedNode);
			addedNode.setPrevious(this.tail);
			this.tail=addedNode;
		}else {

			if(position>this.size/2){
				NodeDoubly<T> oneAfterInsertPosition=this.tail;
				int index = this.size-1;
				while (index >= position+1 ) {
					oneAfterInsertPosition = oneAfterInsertPosition.getPrevious(); //jump one by one from back
					index--;
				}
				addedNode.setNext(oneAfterInsertPosition);
				addedNode.setPrevious(oneAfterInsertPosition.getPrevious());
				oneAfterInsertPosition.getPrevious().setNext(addedNode);
				oneAfterInsertPosition.setPrevious(addedNode);

			}else{
				NodeDoubly<T> oneBeforeInsertPosition=this.head;
				int index = 0;
				while (index <= position-2 ) {
					oneBeforeInsertPosition = oneBeforeInsertPosition.getNext(); //jump one by one from head
					index++;
				}
				addedNode.setPrevious(oneBeforeInsertPosition);
				addedNode.setNext(oneBeforeInsertPosition.getNext());
				oneBeforeInsertPosition.getNext().setPrevious(addedNode);
				oneBeforeInsertPosition.setNext(addedNode);
			}
		}
		size++;
	}

	@Override
	public Integer containsAtIndex(T value) {
		NodeDoubly<T> seeker=this.head;
		int index=0;
		while(index<=this.size-1){
			if(seeker.getValue().equals(value)){
				return index;
			}
			seeker=seeker.getNext();
			index++;
		}
		return null;

	}

	@Override
	public boolean contains(T value) {
		return this.containsAtIndex(value)!=null;
	}

	@Override
	public void removeAtIndex(int index) {
		if(this.head==null){
			return;
		}
		//only one element in list
		if(this.size==1){
			this.head=null;
			this.tail=null;
			this.size=0;
			return;
		}
		//remove from first
		if(index==0){
			this.head.getNext().setPrevious(null);
			this.head=this.head.getNext();
		}//remove from last
		else if (index>=this.size) {
			this.tail.getPrevious().setNext(null);
			this.tail=this.tail.getPrevious();
		}else {
			//index is in first half
			if(index<this.size/2){
				NodeDoubly<T> frontSeekerOneBefore=this.head;
				for(int i=0;i<=index-2;i++){
					frontSeekerOneBefore=frontSeekerOneBefore.getNext();
				}
				frontSeekerOneBefore.setNext(frontSeekerOneBefore.getNext().getNext());
				frontSeekerOneBefore.getNext().getNext().setPrevious(frontSeekerOneBefore);
			}
			//index in second half
			else{
				NodeDoubly<T> tailSeekerOneAfter=this.tail;
				for(int i=this.size-1;i>index;i--){
					tailSeekerOneAfter=tailSeekerOneAfter.getPrevious();
				}
				tailSeekerOneAfter.setPrevious(tailSeekerOneAfter.getPrevious().getPrevious());
				tailSeekerOneAfter.getPrevious().getPrevious().setNext(tailSeekerOneAfter);

			}
		}
		size--;

	}

	@Override
	public void remove(T value) {
		if(this.head==null){
			return;
		}

		//only one element in list
		if(this.size==1 && this.head.getValue().equals(value)){
			this.head=null;
			this.tail=null;
			this.size=0;
			return;
		}

		NodeDoubly<T> valueSeeker=this.head;

		for(int i=0;i<this.size;i++){
			if(valueSeeker.getValue().equals(value)){
				//value at first place
				if(i==0){
					valueSeeker.getNext().setPrevious(null);
					this.head=valueSeeker.getNext();
				} else if (i==this.size-1) {
					valueSeeker.getPrevious().setNext(null);
					this.tail=valueSeeker.getPrevious();
				}else {
					valueSeeker.getPrevious().setNext(valueSeeker.getNext());
					valueSeeker.getNext().setPrevious(valueSeeker.getPrevious());
				}
				this.size--;
				return;
			}
			valueSeeker=valueSeeker.getNext();
		}

	}

	@Override
	public void clear() {
		NodeDoubly<T> jumperEraser=this.head;
		for(int i=0;i<this.size-1;i++){
			jumperEraser.setPrevious(null);
			jumperEraser=jumperEraser.getNext();
		}
		this.head=null;
		this.tail=null;
		this.size=0;
	}

	@Override
	public String toString() {
		NodeDoubly<T> jumper = this.head;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < this.size) {
			sb.append(jumper);
			if(i<this.size-1){
				sb.append("->");
			}
			jumper = jumper.getNext();
			i++;
		}
		sb.append(System.lineSeparator());
		jumper = this.tail;
		int j=this.size;
		while (j >0) {
			sb.append(jumper);
			if(j>1){
				sb.append("->");
				jumper = jumper.getPrevious();
			}
			j--;
		}
		sb.append(System.lineSeparator());
		sb.append("HEAD=").append(this.getHead()).append(" TAIL=").append(this.getTail()).append(" NEXT OF LAST =").append(this.getTail() == null ? null : this.getTail().getNext());

		return sb.toString();
	}

	@Override
	public NodeDoubly<T> getHead() {
		return this.head;
	}

	@Override
	public NodeDoubly<T> getTail() {
		return this.tail;
	}

	@Override
	public int getSize() {
		return this.size;
	}

}





