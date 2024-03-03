package dsa.recursion;

public class StringReverseRecursive {

	public static void main(String[] args) {

		String string="Ivan";
		System.out.println(reverseStringRecursive(string));
		System.out.println("//////////////////////////");
		System.out.println(reverseStringIterative(string));
	}

	static String reverseStringRecursive(String string){
		//unintentional constraint and base case stopping from infinite loops
		if(string.isEmpty()){
			return string;
		}
		return reverseStringRecursive(string.substring(1))+string.charAt(0); //recursive flow f(n)= f(substring(1))
		
	}


	static String reverseStringIterative(String string){
		int length=string.length();

		String reversed="";
		while(length>0){
			reversed=reversed+string.charAt(length-1);
			length--;
		}
		return reversed;
	}
}
