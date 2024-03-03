
package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

import static java.lang.Math.abs;

/**
 * Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 * <p>
 * 1->4->6->\
 * 2->7->1
 * 5->6->|
 * Znači da dve liste dele iste nodove ne po vrednosti nego by reference. U promeru iznad prvi intersect node je ovaj sa value 2 a zadnji sa value 1
 * Da bi se dve liste "Sekle" moraju da dele bar zadnji nod! Ako ne dele ni jedan nod ne seku se
 */
public class QuestionIntersectionSingly {

	public static void main(String[] args) {
		//given
		//Zajednički by reference
		NodeSingly<Integer> nodeShared1 = new NodeSingly<>(47);
		NodeSingly<Integer> nodeShared2 = new NodeSingly<>(7);
		NodeSingly<Integer> nodeShared3 = new NodeSingly<>(1);
		//samo lista1
		MySinglyLinkedList<Integer> mySinglyLinkedList1 = new MySinglyLinkedList<>();
		NodeSingly<Integer> node11 = new NodeSingly<>(1);
		NodeSingly<Integer> node12 = new NodeSingly<>(4);
		NodeSingly<Integer> node13 = new NodeSingly<>(6);

		mySinglyLinkedList1.addNodeAtEnd(node11);
		mySinglyLinkedList1.addNodeAtEnd(node12);
		mySinglyLinkedList1.addNodeAtEnd(node13);
		mySinglyLinkedList1.addNodeAtEnd(nodeShared1);
		mySinglyLinkedList1.addNodeAtEnd(nodeShared2);
		mySinglyLinkedList1.addNodeAtEnd(nodeShared3);

		MySinglyLinkedList<Integer> mySinglyLinkedList2 = new MySinglyLinkedList<>();
		NodeSingly<Integer> node21 = new NodeSingly<>(5);
		NodeSingly<Integer> node22 = new NodeSingly<>(6);
		mySinglyLinkedList2.addNodeAtEnd(node21);
		mySinglyLinkedList2.addNodeAtEnd(node22);
		mySinglyLinkedList2.addNodeAtEnd(nodeShared1);
		mySinglyLinkedList2.addNodeAtEnd(nodeShared2);
		mySinglyLinkedList2.addNodeAtEnd(nodeShared3);

		System.out.println(mySinglyLinkedList1);

		System.out.println(mySinglyLinkedList2);
		//when
		final Integer intersectionNode = findFirstIntersectionNode(mySinglyLinkedList1, mySinglyLinkedList2);
		//then
		if (!nodeShared1.getValue().equals(intersectionNode)) {
			throw new IllegalArgumentException("Bad result!" + intersectionNode);
		}else {
			System.out.println("First intersectiong node "+intersectionNode);
		}

	}

	private static Integer findFirstIntersectionNode(MySinglyLinkedList<Integer> linkedList1, MySinglyLinkedList<Integer> linkedList2) {

		if (linkedList1.head == null || linkedList2.head == null) {
			return null;
		}

		//check if lists intersect at all
		if (linkedList1.tail != linkedList2.tail) {
			return null;
		}


		//Idea is to traverse with two pointers in same loop for each list BUT we need to start from same point if sizes are different
		final int sizeDifference = abs(linkedList1.getSize() - linkedList2.getSize());

		NodeSingly<Integer> jumperList1 = linkedList1.head;
		NodeSingly<Integer> jumperList2 = linkedList2.head;

		int i = 0;
		if (linkedList1.getSize() > linkedList2.getSize()) {
			while (i < sizeDifference) {
				jumperList1 = jumperList1.getNext();
				i++;
			}
		} else {
			while (i < sizeDifference) {
				jumperList2 = jumperList2.getNext();
				i++;
			}
		}

		while (jumperList2 != null) {
			if (jumperList2 == jumperList1) {
				return jumperList1.getValue();
			}
			jumperList1 = jumperList1.getNext();
			jumperList2 = jumperList2.getNext();
		}

		return null;

	}


}
