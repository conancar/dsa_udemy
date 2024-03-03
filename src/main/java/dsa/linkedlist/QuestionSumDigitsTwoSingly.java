package dsa.linkedlist;

import dsa.linkedlist.node.NodeSingly;

/**
 Sum Lists

 You have two numbers represented by a linked list, where each node contains a single digit.
 The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 Write a function that adds the two numbers and returns the sum as a linked list.

 list1 = 7 -> 1 -> 6
 list2 =  5 -> 9 -> 2
 result = 2 -> 1 -> 9
 */
public class QuestionSumDigitsTwoSingly {

	public static void main(String[] args){

		MySinglyLinkedList<Integer> mySinglyLinkedList1=new MySinglyLinkedList<>();
		mySinglyLinkedList1.add(6,0);
		mySinglyLinkedList1.add(1,0);
		mySinglyLinkedList1.add(7,0);

		System.out.println(mySinglyLinkedList1);

		MySinglyLinkedList<Integer> mySinglyLinkedList2=new MySinglyLinkedList<>();
		mySinglyLinkedList2.add(2,0);
		mySinglyLinkedList2.add(9,0);
		mySinglyLinkedList2.add(5,0);
		System.out.println(mySinglyLinkedList2);

		final MySinglyLinkedList<Integer>  sumResult = sumTwoLists2(mySinglyLinkedList1,mySinglyLinkedList2);
		System.out.println(sumResult);
	}

	private static MySinglyLinkedList<Integer>  sumTwoLists1(MySinglyLinkedList<Integer> linkedList1,MySinglyLinkedList<Integer> linkedList2) {

		if(linkedList1.getSize()!=linkedList2.getSize()){
			throw new IllegalArgumentException("Lists must be same size!");
		}

		NodeSingly<Integer> pointer1=linkedList1.head;
		NodeSingly<Integer> pointer2=linkedList2.head;

		MySinglyLinkedList<Integer> result=new MySinglyLinkedList<>();


		int remain=0;

		for(int i =0;i<linkedList1.getSize();i++){

			float sum= (float) (pointer1.getValue() + pointer2.getValue()) /10;
			final String sumAsString = Float.toString(sum);
			int indexOfDecimal = sumAsString.indexOf(".");
			int wholeNumber= Integer.parseInt(sumAsString.substring(0,indexOfDecimal));
			int decimalPart= Integer.parseInt(sumAsString.substring(indexOfDecimal+1));
			result.add(decimalPart+remain, linkedList1.getSize());
			remain=wholeNumber;

			pointer1=pointer1.getNext();
			pointer2=pointer2.getNext();
		}

		return result;

	}

	private static MySinglyLinkedList<Integer>  sumTwoLists2(MySinglyLinkedList<Integer> linkedList1,MySinglyLinkedList<Integer> linkedList2) {

		if(linkedList1.getSize()!=linkedList2.getSize()){
			throw new IllegalArgumentException("Lists must be same size!");
		}

		NodeSingly<Integer> pointer1=linkedList1.head;
		NodeSingly<Integer> pointer2=linkedList2.head;

		MySinglyLinkedList<Integer> resultList=new MySinglyLinkedList<>();

		int remain=0;
		while(pointer1!=null || pointer2!=null){
			int result=remain;
			if(pointer1!=null){
				result+=pointer1.getValue();
				pointer1=pointer1.getNext();
			}
			if(pointer2!=null){
				result+=pointer2.getValue();
				pointer2=pointer2.getNext();
			}
			int decimalPart=result%10;
			remain=result/10;
			resultList.add(decimalPart, linkedList1.getSize());

		}

		return resultList;

	}

}
