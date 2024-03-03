package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

import java.util.HashSet;

/**
 * Return Nth to Last
 *
 * Implement and algorithm to find the nth to last element of a singly linked list.
 *
 * Example
 *
 *     linkedList = 1->2->3->4-5
 *     findNthFromBack(linkedList, 2)
 *     //Output
 *     4
 */
public class QuestionFindNthFromBackSingly {

	public static void main(String[] args){

		MySinglyLinkedList<Integer> mySinglyLinkedList=new MySinglyLinkedList<>();
		mySinglyLinkedList.add(7,0);
		mySinglyLinkedList.add(6,0);
		mySinglyLinkedList.add(5,0);
		mySinglyLinkedList.add(4,0);
		mySinglyLinkedList.add(3,0);
		mySinglyLinkedList.add(2,0);
		mySinglyLinkedList.add(1,0);
		System.out.println(mySinglyLinkedList);

		QuestionFindNthFromBackSingly questionRemoveDuplicatesSingly =new QuestionFindNthFromBackSingly();
		final Integer nThFromBackValue = questionRemoveDuplicatesSingly.findNthFromBack(mySinglyLinkedList,2);
		final Integer nThFromBackValue2 = questionRemoveDuplicatesSingly.findNthFromBackUsingTwoPointers(mySinglyLinkedList,2);

		System.out.println(nThFromBackValue);
		System.out.println(nThFromBackValue2);
	}

	private  Integer findNthFromBack(MySinglyLinkedList<Integer> linkedList,int nThFromBack) {

		if(linkedList.getSize()-nThFromBack<0){
			return 0;
		}

		NodeSingly<Integer> nThBeforeEnd=linkedList.getHead();

		for(int i=0;i< linkedList.getSize()-1-nThFromBack;i++){
			nThBeforeEnd=nThBeforeEnd.getNext();
		}
		return nThBeforeEnd.getValue();

	}

	private  Integer findNthFromBackUsingTwoPointers(MySinglyLinkedList<Integer> linkedList,int nThFromBack) {

		NodeSingly<Integer> toTheEnd=linkedList.getHead();
		NodeSingly<Integer> nThBeforeEnd=linkedList.getHead();

		//prvo guram ovog sto ide do kraja n mesta napred
		for(int i=0;i<nThFromBack+1;i++){
			toTheEnd=toTheEnd.getNext();
		}
		//onda ih guram oba istim tempom dok brzi ne stigne do kraja
		while(toTheEnd!=null){
			toTheEnd=toTheEnd.getNext();
			nThBeforeEnd=nThBeforeEnd.getNext();
		}

		return nThBeforeEnd.getValue();

	}
}
