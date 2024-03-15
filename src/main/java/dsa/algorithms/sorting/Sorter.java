package dsa.algorithms.sorting;


public class Sorter {


	public static void main(String[] args) {

		final int[] array = {5, 4, 2, 7, 6, 1};

		//final int[] sortedArray = bubbleSortAsc(array);

		//final int[] sortedArray = selectionSortAsc(array);

		//final int[] sortedArray = insertionSortAsc(array);


		//final int[] sortedArray = new BucketSort(array).bucketSort();

		//final int[] sortedArray = new MergeSort(array).sort();

		//final int[] sortedArray = new QuickSort(array).sort();

		final int[] sortedArray = new HeapSort(array).sort();

		printArray(sortedArray);

	}


	/*  unsorted 542761

		iter1     iter2    iter3    iter4   iter5
		452761	 245617   245167   241567  124567
		425761	 245617   245167   214567
		425761	 245617	 241567
		425671	 245167
		425617


	 */
	public static int[] bubbleSortAsc(int[] array) {
		int arrayLength = array.length;

		for (int i = 0; i < arrayLength - 1; i++) { //we will compare j and j+1, we do not need to iterate last element (it will be +1)
			for (int j = 0; j < arrayLength - 1 - i; j++) { // on each iteration we check one less since we pushed largest element to the most right place
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		return array;
	}


	/*  unsorted 542761
		split array in sorted and unsorted part, and in each iteration find minimum , swap with first element from left in unsorted and place it in sorted part

		----- | 542761             iteration 1
		----1 | 42765
		---12 | 4765
		--124 | 765
		-1245 | 67
		12456 | 7                   iteration n
   */
	public static int[] selectionSortAsc(int[] array) {
		int arrayLength = array.length;

		for (int i = 0; i < arrayLength ; i++) { //when seek minim we go for all elements every iteration
			int minimumIndex=i;
			for (int j = i+1; j < arrayLength ; j++) { // on each iteration we check one less since we pushed largest element to the most right place
				//check for minimum in unsorted pard
				System.out.println("index="+ i + " seek min in "+array[j]);
				if (array[j] < array[minimumIndex]) {
					System.out.println("swaped "+array[j]+" and "+ array[minimumIndex]);
					minimumIndex=j;
				}
			}
			if(minimumIndex!=i){
				//swap
				int tmp = array[i];
				array[i] = array[minimumIndex];
				array[minimumIndex] = tmp;
			}
		}
		return array;
	}


	/*  unsorted 542761
		split array in sorted and unsorted part, place one by one in sorted part by comparing with elements in sorted part and fit it in its place


		----5 | 42761            iteration 1
		---45 | 2761
		--245 | 761
		-2457 | 61
	  -24567 | 1
	  124567	|                   iteration n
   */
	public static int[] insertionSortAsc(int[] array) {
		int arrayLength = array.length;

		for (int i = 1; i < arrayLength ; i++) { //start from 1 since first is considered to be in sorted part since we have none to compare with
				int temp=array[i];
				int j=i; //unsorted part is smaller and smaller
				while (j>0 && array[j-1]>temp){
					System.out.println("index="+ i + " push j "+array[j]);
					array[j]=array[j-1]; //when inserting in sorted array push left until inserting element is greater than current element
					j--;
				}
				array[j]=temp;
		}
		return array;
	}

	public static void printArray(int[] array) {
		for (int j : array) {
			System.out.print(j + " ");
		}
	}
}
