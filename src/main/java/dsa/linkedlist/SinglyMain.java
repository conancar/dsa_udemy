package dsa.linkedlist;

public class SinglyMain {

	public static void main (String[] args){
		MyLinkedList<String> myFirstSinglyLL=new MySinglyLinkedList<>("Value1");
		System.out.println("FIRST ELEMENT VALUE="+myFirstSinglyLL.getHead().getValue()+ " reference = "+myFirstSinglyLL.getHead()) ;
		System.out.println("LAST ELEMENT VALUE="+myFirstSinglyLL.getTail().getValue()+ " reference = "+myFirstSinglyLL.getTail()) ;
	}
}
