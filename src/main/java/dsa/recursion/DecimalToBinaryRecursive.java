package dsa.recursion;

public class DecimalToBinaryRecursive {

	public static void main(String[] args) {

		int decimal =257;
		StringBuilder binary=new StringBuilder();
		System.out.println(decimalToBinary(decimal));
		System.out.println("//////////////////////////");
		System.out.println(decimalToBinary2(decimal,binary).reverse());
		System.out.println("//////////////////////////");
		System.out.println(decimalToBinaryIterative(decimal).reverse());
	}

	static int decimalToBinary(int n){
		//unintentional constraint

		if(n==0){ //base case stopping from infinite loops
			return 0;
		}
		return  n%2+10*decimalToBinary(n/2);//recursive flow f(n)=n%2+10*f(n/2)
	}

	static StringBuilder decimalToBinary2(int decimal,StringBuilder binary){
		//unintentional constraint

		binary.append(decimal%2);

		if(decimal==1){ //base case stopping from infinite loops
			return binary;
		}
		return  decimalToBinary2(decimal/2,binary);//recursive flow f(n)=f(n/2)
	}

	static StringBuilder decimalToBinaryIterative(int decimal){

		StringBuilder binary=new StringBuilder();


		while (decimal >= 0){
			if(decimal==0){
				return binary;
			}
			binary.append(decimal%2);
			decimal=decimal/2;
		}
		return null;
	}

}
