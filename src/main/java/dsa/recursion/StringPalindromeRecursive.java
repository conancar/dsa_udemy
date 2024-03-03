package dsa.recursion;

public class StringPalindromeRecursive {

	public static void main(String[] args) {

		String string = "amanaplanacanalpanama";
		System.out.println(palindromeStringRecursive(string));
		System.out.println("//////////////////////////");
		System.out.println(isPalindromeIterative(string));
	}

	static boolean palindromeStringRecursive(String string) {
		//unintentional constraint and base case stopping from infinite loops
		if (string.isEmpty() || string.length()==1) {
			return true;
		}

		if (string.charAt(0) == string.charAt(string.length() - 1)) {
			return palindromeStringRecursive(string.substring(1,string.length()-1)); //f(n)=f(cut first and last from n)
		} else {
			return false;
		}
	}


	static boolean isPalindromeIterative(String string) {
		int length = string.length();

		String reversed = "";
		while (length > 0) {
			reversed = reversed + string.charAt(length - 1);
			length--;
		}
		return reversed.equals(string);
	}
}
