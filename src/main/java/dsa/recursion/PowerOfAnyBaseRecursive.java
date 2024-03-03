package dsa.recursion;

public class PowerOfAnyBaseRecursive {

	public static void main(String[] args) {
		int base=3;
		int n=3;
		System.out.println(powerOfAnyBaseRecursive(base,n));
		System.out.println("//////////////////////////");
		System.out.println(powerOfAnyBaseIterative(base,n));

	}


	static int powerOfAnyBaseRecursive(int base,int n){
		if(n<0 || base<=0) { //unintentional constraint
			return -1;
		}

		if(n==0){ //base case stopping from infinite loops
			return 1;
		}else{
			final int power = base * powerOfAnyBaseRecursive(base,n - 1);   //recursive flow f(n)=base*f(n-1)
			System.out.println(power);
			return power;
		}
	}

	static int powerOfAnyBaseIterative(int base,int n){
		int power=1;
		for(int i=0;i<n;i++){
			power=base*power;
			System.out.println(power);
		}

		return power;
	}

}
