package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

/**
 Partition

 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.

 Example

 Input: 1 -> 9 -> 5  -> 10 -> 2  [x=4]

 Output: 2 -> 1 -> 9 -> 5 -> 10
 */
public class QuestionPartitionRearangeSingly {

	public static void main(String[] args){

		MySinglyLinkedList<Integer> mySinglyLinkedList=new MySinglyLinkedList<>();
		mySinglyLinkedList.add(3,0);
		mySinglyLinkedList.add(6,0);
		mySinglyLinkedList.add(4,0);
		mySinglyLinkedList.add(10,0);
		mySinglyLinkedList.add(5,0);
		mySinglyLinkedList.add(9,0);
		mySinglyLinkedList.add(1,0);
		System.out.println(mySinglyLinkedList);

		QuestionPartitionRearangeSingly questionPartitionRearangeSingly=new QuestionPartitionRearangeSingly();
		final MySinglyLinkedList<Integer>  reAranged = questionPartitionRearangeSingly.partitionOrRearange(mySinglyLinkedList,5);
		System.out.println(reAranged);
	}

	private MySinglyLinkedList<Integer>  partitionOrRearange(MySinglyLinkedList<Integer> linkedList,int border) {

		//iseci linkedlistu tako da sadrzi samo prvi nod i onda ako je tekuci veciili jednak od granice smestaj ga na tail ako ne na head

		NodeSingly<Integer> jumperNode=linkedList.head;
		linkedList.tail=linkedList.head; //only one element connected now

		while (jumperNode!=null){
			NodeSingly<Integer> oneNodeAfterJumper=jumperNode.getNext(); //new node is created to keep value of next
			if(jumperNode.getValue()<border){
				 jumperNode.setNext(linkedList.head);
				 linkedList.head=jumperNode;
			}else{
				linkedList.tail.setNext(jumperNode);
				linkedList.tail=jumperNode;
			}
			jumperNode=oneNodeAfterJumper;
			linkedList.tail.setNext(null);
		}
		return linkedList;
	}


}
