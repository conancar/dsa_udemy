package dsa.recursion;

public class StringFirstUppercaseRecursive {

	public static void main(String[] args) {

		String string = "amanaplanacanalpanamP";
		System.out.println(firstUpperCaseRecursive(string));
		System.out.println("//////////////////////////");
		System.out.println(isUpperCaseIterative(string));
	}

	static Character firstUpperCaseRecursive(String string) {
		//unintentional constraint and base case stopping from infinite loops
		if (string.isEmpty() ) {
			return null;
		}

		if(Character.isUpperCase(string.charAt(0))){
			return string.charAt(0);
		}

		return firstUpperCaseRecursive(string.substring(1)); //f(n)=f(cut first from n)

	}


	static Character isUpperCaseIterative(String string) {
		int length = 0;

			while (length < string.length()) {
				if(Character.isUpperCase(string.charAt(length))){
					return string.charAt(length);
				}
			length++;
		}
		return null;
	}
}
