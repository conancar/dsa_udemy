package dsa.recursion;

public class MaxInArrayRecursive {

	public static void main(String[] args) {

		int[] array=new int[]{1,4,2,56,3,2};
		System.out.println(maxInArrayRecursive(array,array.length));
		System.out.println("//////////////////////////");
		System.out.println(maxInArrayIterative(array));
	}


	static int maxInArrayRecursive(int[] array,int backwardIndex){
		//unintentional constraint


		if(backwardIndex==1){ //base case stopping from infinite loops
			return array[0];
		}
		return Math.max(array[backwardIndex-1],maxInArrayRecursive(array,backwardIndex-1)); //recursive flow f(n)=max(value,f(n-1))


	}

	static int maxInArrayIterative(int[] array){

		int max=Integer.MIN_VALUE;

		for (int i=0;i<array.length;i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		return max;
	}

}
