package dsa.recursion;

public class CapitalizeFirstLetterOfWordInSentenceRecursive {

	public static void main(String[] args) {

		String string = "i love basketball";
		System.out.println(capitalizeFirstLettersRecursive(string));
		System.out.println("//////////////////////////");
		System.out.println(capitalizeFirstLetterIterative(string));
	}

	static String capitalizeFirstLettersRecursive(String string) {
		//unintentional constraint and base case stopping from infinite loops
		if (string.isEmpty()) {
			return string;
		}


		char chr=string.charAt(string.length()-1);  //from behind

		if(string.length()==1){  //first char
			return Character.toString(Character.toUpperCase(chr));
		}


		if (string.charAt(string.length() - 2) == ' ') {
			chr=Character.toUpperCase(chr);
		}

		return capitalizeFirstLettersRecursive(string.substring(0,string.length()-1))+ chr; //f(n)=f(cut last from n) + chr

	}


	static String capitalizeFirstLetterIterative(String string) {
		int index = 0;

		while (index < string.length()) {
			if (index == 0) {
				string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
			}
			else{
				if(string.charAt(index - 1) == ' '){
					string =string.substring(0,index)+ Character.toUpperCase(string.charAt(index)) + string.substring(index+1);
				}
			}
			index++;
		}
		return string;
	}
}
