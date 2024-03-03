package dsa.recursion;


/**
 * Fibonacci is a sequence of numbers starting with 0 AND 1 in which each number is sum of preceding 2 numbers
 *
 * 0,1,1,2,3,5,8,13,21,34,55,89,144.....
 */
public class FibonacciRecursive {




	public static void main(String[] args) {

		int n=45;
	//	System.out.println(fibRecursive(n));
		System.out.println("//////////////////////////");
		System.out.println(fibIterative(n));

	}

//O(2^n)   2 puta se poziva dubine n
	static int fibRecursive(int n){
		if(n<0) { //unintentional constraint
			return -1;
		}
		if(n==0 || n==1) { //base case stopping from infinite loops
			return n;
		}
		//System.out.println(n);
		return fibRecursive(n-1)+fibRecursive(n-2);  //recursive flow f(n)=f(n-2)+f(n-1)
	}

	static int fibIterative(int n){
		if(n<0) {
			return -1;
		}

		int nMinus2=0;
		int nMinus1=0;
		int currentNumber=1;


		for(int i=1;i<n;i++){
			System.out.println("(n-2)="+nMinus2+" (n-1)="+nMinus1+" currentNumber="+currentNumber);
			nMinus2=nMinus1;
			nMinus1=currentNumber;
			currentNumber=nMinus2+nMinus1;
		}

		return currentNumber;
	}

}
