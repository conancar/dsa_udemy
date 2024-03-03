package dsa.recursion;

public class SumAllDigitsOfGivenNumberRecursive {

	public static void main(String[] args) {

		int number =2343;
		System.out.println(sumAllDigitsRecursive(number));
		System.out.println("//////////////////////////");
		System.out.println(sumAllDigitsIterative(number));
	}


	static int sumAllDigitsRecursive(int number){ //234
		if(number==0 || number <0 ){ //base case stopping from infinite loops and unintentional constraint
			return 0;
		}
		return number%10+sumAllDigitsRecursive(number/10);   //recursive flow f(n) = n%1 + f(n)
		//       4      +             '23'
		//       3      +             2
		//       0      +             0

	}

	static int sumAllDigitsIterative(int number){ //234
		if(number==0 || number <0 ){
			return 0;
		}
		int sum = 0;

		while (number>0){
			//add last digit to sum
			sum=sum+number%10;
			//'move' one digit left
			number=number/10;
		}
		return sum;
	}



}
