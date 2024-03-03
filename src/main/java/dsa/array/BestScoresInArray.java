package dsa.array;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class BestScoresInArray {

	private static final int MIN_ARRAY_SIZE=2;

	private static final Random rnd=new Random();

	public static void main(String[] args) {

		final int[] array =formArray();
		System.out.println(Arrays.toString(array));

		final int[] goldAndSilverArray =findFirstAndSecondGreatestInArray(array);
		System.out.println(Arrays.toString(goldAndSilverArray));
	}

	private static int[] findFirstAndSecondGreatestInArray(int[] array){

		int gold=Integer.MIN_VALUE;
		int silver=Integer.MIN_VALUE;

		for (int score : array) {
			if (score > gold) {
				silver = gold;
				gold = score;
			} else if (score > silver && score < gold) {
				silver = score;
			}
		}


		//find gold
		// for(int i=0;i<array.length;i++){

		//   if(array[i]>gold){
		//     gold=array[i];
		//   }
		// }
		// //find silver
		// for(int i=0;i<array.length;i++){

		// if(array[i]>silver && array[i]<gold){
		//   silver=array[i];
		// }
		// }
		return new int[]{gold,silver};
	}
	private static int[] formArray(){
		final int arraySize=getArraySize();

		if(arraySize<MIN_ARRAY_SIZE){
			return new int[0];
		}

		int[] array=new int[arraySize];
		for(int i=0;i<arraySize;i++){
			array[i]=rnd.nextInt(50);
		}
		return array;
	}
	private static int getArraySize(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input array size:");
		int arraySize=scanner.nextInt();
		scanner.close();
		return arraySize;
	}
}
