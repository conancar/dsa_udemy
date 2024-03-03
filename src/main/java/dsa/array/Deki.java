package dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Deki {

	public static void main(String[] args) {

		testTreeNums();
		//testmaxVerticalLine();
		//testShuffle();
		//	testIdenticalPairs();
		// testIdenticalPairs();
		// testConcat();
		//	testSumProblem();
	}





	private static void testTreeNums() {
		int[] array1 = {1,2,3,4,5,6};

		final List<List<Integer>> numIdenticalPairs = treeNums2(array1);
		numIdenticalPairs.stream().flatMap(List::stream).forEach(e-> System.out.println(e));
	}


	private static List<List<Integer>> treeNums2(int[] array1) {
		List<List<Integer>> results=new ArrayList<>();

		for (int i = 0; i < array1.length; i++) {
			for (int j = i+1; j < array1.length; j++) {
				for (int k = j+1; k < array1.length; k++) {
				   if(array1[i]+array1[j]+array1[k]==0){
						results.add(Arrays.asList(array1[i],array1[j],array1[k]));
					}
				}
			}
		}

		List<List<Integer>>finalResults=new ArrayList<>();

		for (List<Integer> result : results) {
			Collections.sort(result);
			if(!finalResults.contains(result)){
				finalResults.add(result);
			}
		}


		return finalResults;
	}



	private static int[][] treeNums(int[] array1) {
		int[][] results=new int[50][3];

		int row=0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = i+1; j < array1.length; j++) {
				for (int k = j+1; k < array1.length; k++) {

					if(array1[i]+array1[j]+array1[k]==0){
						int[] sorted=new int[]{array1[i],array1[j],array1[k]};
						Arrays.sort(sorted);
						boolean exists=false;
						for (int[] result : results) {
							if (Arrays.equals(result, sorted)) {
								exists = true;
								break;
							}
						}
						if(!exists) {
							results[row][0] = sorted[0];
							results[row][1] = sorted[1];
							results[row][2] = sorted[2];
							row++;
						}
					}
				}
			}
		}
		int[][] finalResult=new int[row][3];
		for (int i = 0; i < row; i++) {
				finalResult[i] = results[i];
		}


		return finalResult;
	}



private static void testmaxVerticalLine() {
	int[] array1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};

	final int numIdenticalPairs = maxArea(array1);
	System.out.println(numIdenticalPairs);
}

private static int maxArea(int[] array1) {


	int maxArea = 0;

	int levi = 0;
	int desni = array1.length - 1;

	while (levi < desni) {

		int visina = Math.min(array1[levi], array1[desni]);
		int sirina = Math.abs(levi - desni);
		int povrsina = visina * sirina;
		System.out.println("Za elemente " + array1[levi] + " i " + array1[desni] + " P=" + povrsina);
		if (povrsina > maxArea) {
			maxArea = povrsina;
		}
		if (array1[levi] > array1[desni]) {
			desni--;
		} else {
			levi++;
		}

	}

	return maxArea;
}

private static int[] shuffle(int[] nums, int n) {

	int[] result = new int[nums.length];
	for (int i = 0; i < n; i++) {
		result[2 * i] = nums[i];
		result[2 * i + 1] = nums[n + i];


	}

	return result;
}

private static void testShuffle() {
	int[] array1 = {1, 2, 4, 7, 3, 5}; //1,7,2,3,4,5
	int n = 3;
	final int[] numIdenticalPairs = shuffle(array1, n);
	System.out.println(Arrays.toString(numIdenticalPairs));
}

private static void testFinalValueAfterOperations() {
	int[] array1 = {1, 1, 11, 1, 9};

	final int numIdenticalPairs = numIdenticalPairs(array1);
	System.out.println(numIdenticalPairs);
}

private static void testIdenticalPairs() {
	int[] array1 = {1, 1, 11, 1, 9};

	final int numIdenticalPairs = numIdenticalPairs(array1);
	System.out.println(numIdenticalPairs);
}


private static int finalValueAfterOperations(String[] operations) {
	int X = 0;
	for (int i = 0; i < operations.length; i++) {
		if (operations[i].equals("--X") || operations[i].equals("X--")) {
			X++;
		}
		if (operations[i].equals("++X") || operations[i].equals("X++")) {
			X--;
		}
	}
	return X;
}


private static int numIdenticalPairs(int[] nums) {
	int pairs = 0;
	for (int i = 0; i < nums.length; i++) {
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[i] == nums[j]) {
				pairs++;
			}
		}
	}
	return pairs;
}


private static void testConcat() {
	int[] array1 = {2, 7, 11, 15, 9};
	final int[] concatenation = getConcatenation(array1);
	System.out.println(Arrays.toString(concatenation));
}

private static int[] getConcatenation(int[] nums) {
	int numsLength = nums.length;

	int[] concatenated = new int[numsLength * 2];
	int concatenatedLength = concatenated.length;

	for (int i = 0; i < concatenatedLength; i++) {

		if (i < nums.length) {
			concatenated[i] = nums[i];
		} else {
			concatenated[i] = concatenated[i - numsLength];
		}

	}
	return concatenated;
}


private static void testSumProblem() {
	//TEST 1
	int[] array1 = {2, 7, 11, 15, 9};
	int target = 9;
	final int[] sum = sum(array1, target);
	System.out.println(Arrays.toString(sum));

	//TEST 2
	int[] array2 = {3, 2, 4};
	int target2 = 6;
	final int[] sum2 = sum(array2, target2);
	System.out.println(Arrays.toString(sum2));

	//TEST 3
	int[] array3 = {3, 3};
	int target3 = 6;
	final int[] sum3 = sum(array3, target3);
	System.out.println(Arrays.toString(sum3));
}

public static int[] sum(int[] array, int target) {

	int[] indexi_sabiraka = new int[2];

	for (int i = 0; i < array.length; i++) {
		for (int j = i + 1; j < array.length; j++) {
			if (array[i] + array[j] == target) {
				indexi_sabiraka[0] = i;
				indexi_sabiraka[1] = j;
			}
		}
	}
	return indexi_sabiraka;
}
}
