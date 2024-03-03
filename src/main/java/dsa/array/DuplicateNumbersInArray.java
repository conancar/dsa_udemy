package dsa.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Write a function which takes integer array as a parameter and returns a new integer array with unique elements. (remove duplicates)
 */
public class DuplicateNumbersInArray {

	private static final Scanner scanner = new Scanner(System.in);
	private static final Random rnd = new Random();

	private static final int MIN_SIZE_OF_ARRAY = 3;

	public static void main(String[] args) {

		final int arraySizeWithDuplicates = getSizeOfArrayWithDuplicates();

		final int numberOfDuplicates = getNumberOfDuplicatesInArray(arraySizeWithDuplicates);

		final int[] arrayWithDuplicates = formArrayWithDuplicates(arraySizeWithDuplicates, numberOfDuplicates);
		System.out.println("Array with duplicates="+Arrays.toString(arrayWithDuplicates));

		final int[] arrayCleanOfDuplicates = removeDuplicatesUniqueNewArray(arrayWithDuplicates);

		System.out.println("Final clean array="+Arrays.toString(arrayCleanOfDuplicates));

		scanner.close();
	}

	private static int[] removeDuplicatesUniqueNewArray(int[] arrayWithDuplicates) {
		final int helperArrayLength = arrayWithDuplicates.length;
		int[] helperArray= new int[helperArrayLength];
		Arrays.fill(helperArray, -1);
		System.out.println("Helper Array = "+ Arrays.toString(helperArray));

		int numberOfUniqueMembers=0;
		for(int j=0;j<arrayWithDuplicates.length;j++){
			boolean containInHelper=false;
			for(int i = 0; i< helperArrayLength; i++){
				if(helperArray[i]==arrayWithDuplicates[j]){
					containInHelper=true;
					break;
				}
			}
			if(!containInHelper){
				helperArray[j]=arrayWithDuplicates[j];
				numberOfUniqueMembers++;
			}
		}

		int[] uniqueArray = new int[numberOfUniqueMembers];
		System.out.println("Helper Array after fill= "+ Arrays.toString(helperArray));
		int i=0;
		for(int helperMember:helperArray){
			if(helperMember>-1){
				uniqueArray[i]=helperMember;
				i++;
			}
		}

		return uniqueArray;
	}

	private static int[] formArrayWithDuplicates(int size, int numberOfDuplicates) {
		int[] arrayWithDuplicates = new int[size];

		final Set<Integer> duplicatesUsed = new HashSet<>(numberOfDuplicates);
		final int rndSpectre = numberOfDuplicates * 10;
		duplicatesUsed.add(rnd.nextInt(rndSpectre));

		while (duplicatesUsed.size() < numberOfDuplicates) {
			final int duplicate = rnd.nextInt(rndSpectre);
			duplicatesUsed.add(duplicate);
		}

		duplicatesUsed.forEach(System.out::println);
		int i=0;
		for (Integer number : duplicatesUsed) {
			arrayWithDuplicates[i]=number;
			arrayWithDuplicates[i+1]=number;
			i=i+2;
		}

		final Set<Integer> duplicatesUsedOfRest = new HashSet<>();

		for(int k=0;k<size-2*duplicatesUsed.size();k++){

			boolean foundNonDuplicateElement=false;
			while (!foundNonDuplicateElement){
				final int nonDuplicateElement = rnd.nextInt(rndSpectre);
				if(!duplicatesUsed.contains(nonDuplicateElement) && !duplicatesUsedOfRest.contains(nonDuplicateElement)){
					arrayWithDuplicates[2*duplicatesUsed.size()+k]= nonDuplicateElement;
					duplicatesUsedOfRest.add(nonDuplicateElement);
					foundNonDuplicateElement=true;
				}
			}
		}
		return arrayWithDuplicates;
	}

	private static int getSizeOfArrayWithDuplicates() {

		System.out.println("Input size of array:");
		final int size = scanner.nextInt();
		if (size < MIN_SIZE_OF_ARRAY) {
			throw new IllegalArgumentException("Minimum size is " + MIN_SIZE_OF_ARRAY);
		}
		return size;
	}

	private static int getNumberOfDuplicatesInArray(int arraySize) {

		final int maxAllowedDuplicates = (arraySize / 2);


		System.out.println("Input number of duplicates in array (max is " + maxAllowedDuplicates + ") :");
		final int numberOfDuplicates = scanner.nextInt();

		if (numberOfDuplicates > maxAllowedDuplicates) {
			throw new IllegalArgumentException("Max number of duplicates= " + maxAllowedDuplicates);
		}
		return numberOfDuplicates;
	}
}
