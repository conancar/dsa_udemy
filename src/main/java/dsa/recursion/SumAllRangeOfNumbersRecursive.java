package dsa.recursion;

public class SumAllRangeOfNumbersRecursive {

	public static void main(String[] args) {

		int number=3;
		System.out.println(sumOfNumbersRecursive(number));
		System.out.println("//////////////////////////");
		System.out.println(sumOfNumbersIterative(number));
	}

	static int sumOfNumbersRecursive(int number){
		//unintentional constraint

		if(number==0){ //base case stopping from infinite loops
			return 0;
		}
		return number+ sumOfNumbersRecursive(number-1); //recursive flow f(n)= n+f(n-1)
		
	}


	static int sumOfNumbersIterative(int number){
		int sum=0;

		while(number>0){
			sum=sum+number;
			number--;
		}
		return sum;
	}
}
