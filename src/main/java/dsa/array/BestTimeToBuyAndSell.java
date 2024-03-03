package dsa.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example:
 *     Input: prices = [7, 1, 5, 3, 6, 4]
 *     Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 */
public class BestTimeToBuyAndSell {


	//define constraints and edge cases
	private static final int MIN_NUMBER_OF_DAYS=2;
	private static final int MIN_PRICE_FOR_DAY=1;
	public static final String STOCK_LASTS_TOO_SHORT_MESSAGE = "Number of days too small!";
	public static final String PRICE_TOO_LOW_MESSAGE = "Price is to low!";
	private static final Scanner scanner=new Scanner(System.in);

	public static void main(String[] args){

		//define size of a price array from user
		final int numberOfDays= getNumberOfDays();

		//let user define prices for day
		final int[] pricesArray=fillNumberOfDaysArray(numberOfDays);
		System.out.println(Arrays.toString(pricesArray));

		//find best profit
		final int bestProfit=findBestProfit(pricesArray);
		System.out.println("You earned "+ bestProfit+" points on stock");

		//write test with edge cases

	}

	//todo THIS IS BETER SOLUTION SINCE PROFIT IS DEPENDENT ON MINPRICE AND CURRENT PRICE IN LOOP!
	static int  maxProfitInOneForLoop(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			} else if (price - minPrice > maxProfit) {
				maxProfit = price - minPrice;
			}
		}
		return maxProfit;
	}

	 static int findBestProfit(int[] pricesArray){
		final int arrayLength = pricesArray.length;

		 if(arrayLength<MIN_NUMBER_OF_DAYS){
			 throw new IllegalArgumentException(STOCK_LASTS_TOO_SHORT_MESSAGE);
		 }

		//find minimum price and its index
		int minimumPrice=Integer.MAX_VALUE;
		int indexOfMinimumPrice=0;
		for(int i = 0; i< arrayLength; i++){
			if(pricesArray[i]<MIN_PRICE_FOR_DAY){
				throw new IllegalArgumentException(PRICE_TOO_LOW_MESSAGE);
			}
			if(pricesArray[i]<minimumPrice){
				minimumPrice=pricesArray[i];
				indexOfMinimumPrice=i;
			}
		}
		System.out.println("Minimum price is "+minimumPrice+" on first found day  "+(indexOfMinimumPrice+1) + " .");

		//find maximum price in array after index of minimum price
		int maximumPrice=MIN_PRICE_FOR_DAY;
		int indexOfMaximumPrice=0;
		for(int i=indexOfMinimumPrice;i< arrayLength;i++){
			if(pricesArray[i]>minimumPrice && pricesArray[i]>maximumPrice){
				maximumPrice=pricesArray[i];
				indexOfMaximumPrice=i;
			}
		}
		System.out.println("Maximum price is "+maximumPrice+" on day  "+(indexOfMaximumPrice+1) + " .");

		if(indexOfMaximumPrice==0){
			System.out.println("Sorry no luck for you on stock, better learn some programming language!");
			return 0;
		}

		return maximumPrice-minimumPrice;

	}

	private static int[] fillNumberOfDaysArray(int arraySize){
		int[] pricesArray=new int[arraySize];
		for(int i=0;i<arraySize;i++){
			System.out.println("Please enter price for day "+(i+1)+" (min price is "+MIN_PRICE_FOR_DAY+"):");

			boolean enteredPriceIsOk=false;
			while(!enteredPriceIsOk){
				final int price = scanner.nextInt();
				if(price<MIN_PRICE_FOR_DAY){
					System.out.println("Price for day " + (i + 1) + " is too small ! (min price is " + MIN_PRICE_FOR_DAY + "):");
				}else{
					enteredPriceIsOk=true;
					pricesArray[i]= price;
				}
			}
		}
		return pricesArray;
	}

	private static int getNumberOfDays(){
		System.out.println("Enter number of days (min "+MIN_NUMBER_OF_DAYS+"):");
		final int numberOfDays= scanner.nextInt();
		if(numberOfDays<MIN_NUMBER_OF_DAYS){
			throw new IllegalArgumentException("Number of days too small!");
		}
		return numberOfDays;
	}


}
