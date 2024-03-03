package dsa.recursion;

public class GreatestCommonDivisorRecursive {

	public static void main(String[] args) {
		//GCD is the greatest whole number that divides two numbers  (12,8)=4
		//EUCLID algorithm 12/8=1  ostatak =4  -> 8/4=2 ostatak 0 ZNACI 4
		//gdc(48,18) 48/18=2 ostatak 12 -> 18/12=1 ostatak 6 -> 12/6 =2 ostatak 0 ZNACI 6
		//Matematicki gdc(a,b)=gdc(b,a%b)


		int number1 = 12;
		int number2 = 4;
		System.out.println(greatestCommonDevisorRecursive(number1, number2));
		System.out.println("//////////////////////////");
		System.out.println(gcdByBruteForce(number1, number2));

	}

	//O(Log min(n1, n2))
	static int greatestCommonDevisorRecursive(int number1, int number2) {

		if (number1 < 0 || number2 < 0) { //unintentional constraint
			return -1;
		}

		if (number2 == 0) { //base case stopping from infinite loops
			return number1;
		}
		return greatestCommonDevisorRecursive(number2, number1 % number2);
	}

	//O(min(n1, n2))
	static int gcdByBruteForce(int n1, int n2) {
		int gcd = 1;
		for (int i = 1; i <= n1 && i <= n2; i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}

}
