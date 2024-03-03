package dsa.recursion;

public class PowerOf2Recursive {

	public static void main(String[] args) {

		int n=10;
		System.out.println(powerOf2Recursive(n));
		System.out.println("//////////////////////////");
		System.out.println(powerOf2Iterative(n));
		System.out.println("//////////////////////////");
		System.out.println(powerOf2Iterative1(n));
	}


	static int powerOf2Recursive(int n){
		if(n<0) { //unintentional constraint
			return -1;
		}

		if(n==0){ //base case stopping from infinite loops
			return 1;
		}else{
			final int power = 2 * powerOf2Recursive(n - 1);   //recursive flow f(n)=2*f(n-1)
			System.out.println(power);
			return power;  // powerOf2Recursive(n-1) is kept in stack and computed later LIFO
		}
	}

	static int powerOf2Iterative(int n){
		int power=1;
		for(int i=0;i<n;i++){
			power=2*power;
			System.out.println(power);
		}

		return power;
	}
	static int powerOf2Iterative1(int n){
		int power=1;
		int i=0;
		while(i<n){
			power=2*power;
			System.out.println(power);
			i++;
		}

		return power;
	}
}
