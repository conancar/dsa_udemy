package dsa.algorithms.searching;

public class Searcher {


	public static void main(String[] args) {

		final int[] array = {5, 4, 2, 7, 6, 1};

		final int[] arraySorted = {1, 4, 7, 9, 11, 12};

		final int indexFound = new LinearSearch().search(array, 4);

		final int indexFoundSortedRecursive = new BinarySearch().binarySearchRecursive(arraySorted, 9,0,arraySorted.length-1);

		final int indexFoundSorted = new BinarySearch().binarySearch(arraySorted, 9);

		System.out.println("found at index " + indexFound);
		System.out.println("found at index sorted " + indexFoundSorted);
		System.out.println("found at index sorted recursive " + indexFoundSortedRecursive);

	}
}
