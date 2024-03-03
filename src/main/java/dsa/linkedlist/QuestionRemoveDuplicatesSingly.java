package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

import java.util.HashSet;

/**
 * Write a method to remove duplicates from an unsorted linked list.
 *
 * Example
 *
 *     linkedList = 1->2->1->3
 *     deleteDups(linkedList)
 *     //Output
 *     1->2->3
 */
public class QuestionRemoveDuplicatesSingly {

	public static void main(String[] args){

		MySinglyLinkedList<Integer> mySinglyLinkedList=new MySinglyLinkedList<>();
		mySinglyLinkedList.add(1,0);
		mySinglyLinkedList.add(2,0);
		mySinglyLinkedList.add(3,0);
		mySinglyLinkedList.add(1,0);
		mySinglyLinkedList.add(3,0);
		mySinglyLinkedList.add(1,0);
		mySinglyLinkedList.add(2,0);
		System.out.println(mySinglyLinkedList);

		QuestionRemoveDuplicatesSingly questionRemoveDuplicatesSingly =new QuestionRemoveDuplicatesSingly();
		final MySinglyLinkedList<Integer> cleanList = questionRemoveDuplicatesSingly.removeDuplicates(mySinglyLinkedList);
		System.out.println(cleanList);
	}

	private  MySinglyLinkedList<Integer> removeDuplicates(MySinglyLinkedList<Integer> listWithDuplicates) {


		NodeSingly<Integer> valueSeeker=listWithDuplicates.getHead();
		NodeSingly<Integer> oneNodeBeforeValueSeeker=null; //first value in list cannot be duplicate

		HashSet<Integer> uniqueSet=new HashSet<>(); // SPACE COMPLEXITY O(n)

	// !!!!!!!!!!!!!!! DO NOT DO THIS WITH FOR LOOP, size iz shrinking and tail is not automatically changes, use while seeker.next!=null!
//		int listSize=listWithDuplicates.getSize(); // reducing size in loop! must be taken before loop
//		for(int i=0;i<listSize;i++){
//
//			final Integer value = valueSeeker.getValue();
//			if(uniqueSet.contains(value)){  // Time ??;
//				oneNodeBeforeValueSeeker.setNext(valueSeeker.getNext());
//				listWithDuplicates.size--;
//			}else{
//				uniqueSet.add(value);
//				oneNodeBeforeValueSeeker=valueSeeker;
//				listWithDuplicates.tail=valueSeeker;
//			}
//			valueSeeker=valueSeeker.getNext();
//		}

		while(valueSeeker!=null){
			final int value=valueSeeker.getValue();
			if(uniqueSet.contains(value)){  // Time ??
				oneNodeBeforeValueSeeker.setNext(valueSeeker.getNext());
				listWithDuplicates.size--;
			}else {
				uniqueSet.add(value);
				oneNodeBeforeValueSeeker=valueSeeker;
				listWithDuplicates.tail=valueSeeker; // do not mess with tail
			}
			valueSeeker=valueSeeker.getNext();
		}

		return listWithDuplicates;
	}
}
