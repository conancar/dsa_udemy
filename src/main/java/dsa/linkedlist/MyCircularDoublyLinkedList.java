package dsa.linkedlist;

import dsa.linkedlist.node.NodeDoubly;

import java.io.Serializable;

public class MyCircularDoublyLinkedList<T extends Serializable> extends MyDoublyLinkedList<T> implements MyLinkedList<T>{

	public MyCircularDoublyLinkedList(T valueOfFirstNode) {
		super(valueOfFirstNode);
		this.head.setNext(this.head);
		this.head.setPrevious(this.head);
	}

	public MyCircularDoublyLinkedList() {
	}

	@Override
	public void add(T value,int position){
		NodeDoubly<T> addedNode=new NodeDoubly<>(value);

		//empty list
		if(this.head==null){
			this.head=addedNode;
			this.tail=addedNode;
			addedNode.setNext(addedNode);
			addedNode.setPrevious(addedNode);
			this.size++;
			return;
		}

		if(position==0){
			this.head.setPrevious(addedNode);
			addedNode.setNext(this.head);
			this.head=addedNode;
			this.tail.setNext(addedNode);
			this.head.setPrevious(this.tail);

		}else if (position>=this.size){
			this.tail.setNext(addedNode);
			addedNode.setPrevious(this.tail);
			this.tail=addedNode;
			this.tail.setNext(this.head);
			this.head.setPrevious(this.tail);

		}else{
			if(position<this.size/2){
				NodeDoubly<T> oneBeforePositionFromHead=this.head;
				int i=0;
				while (i<position-1){
					oneBeforePositionFromHead=oneBeforePositionFromHead.getNext();
					i++;
				}
				oneBeforePositionFromHead.getNext().setPrevious(addedNode);
				addedNode.setNext(oneBeforePositionFromHead.getNext());

				oneBeforePositionFromHead.setNext(addedNode);
				addedNode.setPrevious(oneBeforePositionFromHead);
			}else{
				NodeDoubly<T> oneAfterPositionFromTail=this.tail;
				int i=this.size;
				while (i>position+1){
					oneAfterPositionFromTail=oneAfterPositionFromTail.getPrevious();
					i--;
				}
				oneAfterPositionFromTail.getPrevious().setNext(addedNode);
				addedNode.setPrevious(oneAfterPositionFromTail.getPrevious());

				addedNode.setNext(oneAfterPositionFromTail);
				oneAfterPositionFromTail.setPrevious(addedNode);
			}
		}
		size++;
	}
	@Override
	public void removeAtIndex(int index){
		if(this.head==null){
			return;
		}
		if(this.size==1){
			this.head.setPrevious(null);
			this.head.setNext(null);
			this.head=null;
			this.tail=null;
			size--;
			return;
		}
		if(index==0){
			this.head.getNext().setPrevious(this.tail);
			this.tail.setNext(this.head.getNext());
			this.head=this.head.getNext();
		} else if (index>=this.size) {
			this.tail.getPrevious().setNext(this.head);
			this.head.setPrevious(this.tail.getPrevious());
			this.tail=this.tail.getPrevious();
		}else{
			if(index<this.size/2){
				NodeDoubly<T> oneBeforeIndexPosition=this.head;
				int i=0;
				while (i<index-1){
					oneBeforeIndexPosition=oneBeforeIndexPosition.getNext();
					i++;
				}
				oneBeforeIndexPosition.setNext(oneBeforeIndexPosition.getNext().getNext());
				oneBeforeIndexPosition.getNext().getNext().setPrevious(oneBeforeIndexPosition);
			}else{
				NodeDoubly<T> oneAtIndexPosition=this.tail;
				int i=this.size-1;
				while (i>index){
					oneAtIndexPosition=oneAtIndexPosition.getPrevious();
					i--;
				}
				oneAtIndexPosition.getPrevious().setNext(oneAtIndexPosition.getNext());
				oneAtIndexPosition.getNext().setPrevious(oneAtIndexPosition.getPrevious());
			}
		}
		size--;
	}
	@Override
	public void remove(T value){
		if(this.head==null){
			return;
		}

		if(this.size==1 && this.head.getValue().equals(value)){
			this.head.setPrevious(null);
			this.head.setNext(null);
			this.head=null;
			this.tail=null;
			size--;
			return;
		}

		NodeDoubly<T> valueSeeker=this.head;
		for(int i=0;i<this.size;i++){
			if(valueSeeker.getValue().equals(value)){
				if(i==0){
					this.head.getNext().setPrevious(this.tail);
					this.tail.setNext(this.head.getNext());
					this.head=this.head.getNext();
				}else if (i==this.size-1){
					this.tail.getPrevious().setNext(this.head);
					this.head.setPrevious(this.tail.getPrevious());
					this.tail=this.tail.getPrevious();
				}else {
					valueSeeker.getPrevious().setNext(valueSeeker.getNext());
					valueSeeker.getNext().setPrevious(valueSeeker.getPrevious());
				}
				size--;
				return;
			}
			valueSeeker=valueSeeker.getNext();
		}
	}

	@Override
	public void clear() {
		NodeDoubly<T> eraser = this.head;
		for (int i=0;i<this.size;i++){
			eraser.setPrevious(null);
			eraser=eraser.getNext();
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
		sb.append("HEAD=").append(this.getHead()).append(" TAIL=").append(this.getTail())
			.append(" NEXT OF TAIL =").append(this.getTail() == null ? null : this.getTail().getNext())
			.append(" PREVIOUS OF HEAD =").append(this.getHead() == null ? null : this.getHead().getPrevious());

		return sb.toString();
	}
}
