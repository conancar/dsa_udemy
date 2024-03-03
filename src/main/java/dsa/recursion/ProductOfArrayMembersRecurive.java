package dsa.recursion;

public class ProductOfArrayMembersRecurive {

	public static void main(String[] args) {

		int[] array=new int[]{2,4,3};
		System.out.println(productOfArrayRecursive(array,0,1));
		System.out.println("//////////////////////////");
		System.out.println(productOfArrayRecursive2(array,array.length));
		System.out.println("//////////////////////////");
		System.out.println(productOfArrayIterative(array));
	}

	static int productOfArrayRecursive(int[] array, int index,int result){
		//unintentional constraint

		if(index==array.length){ //base case stopping from infinite loops
			return result;
		}
		result=result*array[index]*productOfArrayRecursive(array,index+1,result); //recursive flow f(n)= n*f(n-1)
		return result;
	}

	static int productOfArrayRecursive2(int[] array, int indexFromBack){
		//unintentional constraint

		if(indexFromBack<=0){ //base case stopping from infinite loops
			return 1;
		}
		return array[indexFromBack-1]*productOfArrayRecursive2(array,indexFromBack-1); //recursive flow f(n)= n*f(n-1)

	}

	static int productOfArrayIterative(int[] array){
		int product=1;

		for (int j : array) {
			product = product * j;
		}
		return product;
	}
}
