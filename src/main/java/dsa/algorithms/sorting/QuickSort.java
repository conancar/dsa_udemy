package dsa.algorithms.sorting;

public class QuickSort {

	int[] arr;
	public QuickSort(int[] arr) {
		this.arr = arr;
	}

	static int partition(int[] array, int start, int end) {
		int pivot = end;
		int i = start - 1;
		for (int j= start; j<=end; j++) {
			if (array[j] <= array[pivot]) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		return i;
	}

	private static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot -1);
			quickSort(array, pivot + 1, end);
		}
	}


	public int[] sort() {
		quickSort(arr,0,arr.length-1);
		return arr;
	}


	public static void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}

}
