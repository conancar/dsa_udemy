package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

/**
 * Rotate
 * <p>
 * This function should rotate all the nodes in the list by some number passed in.
 * For instance, if your list looks like 1 -> 2 -> 3 -> 4 -> 5 and you rotate by 2, the list should be modified to 3 -> 4 -> 5 -> 1 -> 2.
 * The number passed in  to rotate can be any integer (negative also).
 * <p>
 * Time Complexity : O(N), where N is the length of the list.
 * <p>
 * Space Complexity : O(1)
 */
public class QuestionRotateSingly {

	public static void main(String[] args) {

		MySinglyLinkedList<Integer> mySinglyLinkedList = new MySinglyLinkedList<>();
		mySinglyLinkedList.add(5, 0);
		mySinglyLinkedList.add(4, 0);
		mySinglyLinkedList.add(3, 0);
		mySinglyLinkedList.add(2, 0);
		mySinglyLinkedList.add(1, 0);
		System.out.println(mySinglyLinkedList);

		QuestionRotateSingly questionPartitionRearangeSingly = new QuestionRotateSingly();
		final MySinglyLinkedList<Integer> reAranged = questionPartitionRearangeSingly.rotate(mySinglyLinkedList, -1);
		System.out.println(reAranged);
	}

	private MySinglyLinkedList<Integer> rotate(MySinglyLinkedList<Integer> linkedList, int number) {

		//set index to last element that will be rotated
		//Goal is to make circle - glue head to the back (tail) and cut circle at desired place


		int index = number;
		if (number < 0) {
			index = number + linkedList.getSize();
		}
		if (index < 0 || index >= linkedList.getSize()) {
			return null;
		}
		if (index == 0) {
			return linkedList;
		}

		//move head to tail for all values before index
		NodeSingly<Integer> prevNode = linkedList.head;
		for (int i = 0; i < index - 1; i++) {
			prevNode = prevNode.getNext();
		}
		if (prevNode == null) {
			return linkedList;
		}
		linkedList.tail.setNext(linkedList.head);  //glue 5 to 1  (make circle)
		linkedList.head = prevNode.getNext(); //set head to 4 (cut circle)
		linkedList.tail = prevNode; //set tail to 3 (cut circle)
		prevNode.setNext(null); //tail behaivour next is null
		return linkedList;
	}
}



