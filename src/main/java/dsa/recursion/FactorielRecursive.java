package dsa.recursion;

public class FactorielRecursive {

	public static void main(String[] args) {

		int n=10;
		System.out.println(factorialRecursive(n));
		System.out.println("//////////////////////////");
		System.out.println(factorialIterative(n));

	}


	//O(n) time
	static int factorialRecursive(int n){
		if(n<0) {  //unintentional constraint
			return -1;
		}
		if(n==0 || n==1) {   //base case stopping from infinite loops
			return 1;
		}
		return n*factorialRecursive(n-1);  //recursive flow f(n)=n*f(n-1)
	}

	static int factorialIterative(int n){
		if(n<0) {
			return -1;
		}

		int factorial=1;
		for(int i=n;i>=1;i--){
			factorial=factorial*i;
		}

		return factorial;
	}

}
