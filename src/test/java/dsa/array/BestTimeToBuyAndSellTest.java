package dsa.array;

import junit.framework.TestCase;


import static dsa.array.BestTimeToBuyAndSell.PRICE_TOO_LOW_MESSAGE;
import static dsa.array.BestTimeToBuyAndSell.STOCK_LASTS_TOO_SHORT_MESSAGE;
import static org.junit.Assert.assertThrows;

public class BestTimeToBuyAndSellTest extends TestCase {

	public void testTooSmallArray() {
		int[] arrayEmpty={};
		int[] arraySizeOne={1};

		IllegalArgumentException exceptionEmpty=assertThrows(IllegalArgumentException.class, () -> BestTimeToBuyAndSell.findBestProfit(arrayEmpty));
		IllegalArgumentException exceptionSizeOne=assertThrows(IllegalArgumentException.class, () -> BestTimeToBuyAndSell.findBestProfit(arraySizeOne));

		String actualMessageEmpty = exceptionEmpty.getMessage();
		assertEquals(STOCK_LASTS_TOO_SHORT_MESSAGE, actualMessageEmpty);

		String actualMessageSizeOne = exceptionSizeOne.getMessage();
		assertEquals(STOCK_LASTS_TOO_SHORT_MESSAGE, actualMessageSizeOne);
	}

	public void testToLowPrice() {
		int[] arrayWithTooLowPriceInside={1,2,4,0,1,-1};

		IllegalArgumentException exceptionEmpty=assertThrows(IllegalArgumentException.class, () -> BestTimeToBuyAndSell.findBestProfit(arrayWithTooLowPriceInside));

		String actualMessageEmpty = exceptionEmpty.getMessage();

		assertEquals(PRICE_TOO_LOW_MESSAGE, actualMessageEmpty);

	}

	public  void testCorrectPaths(){
		int[] correctArray1={1,3,5,1,3,4,6};
		final int bestProfit1 = BestTimeToBuyAndSell.findBestProfit(correctArray1);
		assertEquals(5,bestProfit1);

		int[] correctArray2={8,3,5,1,3,4,6,3,4,65,3,212,4,5,23,2,54,43,23,56,2322,3333};
		final int bestProfit2= BestTimeToBuyAndSell.findBestProfit(correctArray2);
		assertEquals(3332,bestProfit2);

		int[] correctArray3={1,1,1,1,1,2};
		final int bestProfit3= BestTimeToBuyAndSell.findBestProfit(correctArray3);
		assertEquals(1,bestProfit3);
	}

	public  void testNoLuckPaths(){
		int[] noLuckArray1={2,2,1,1,1,1};
		final int bestProfit1 = BestTimeToBuyAndSell.findBestProfit(noLuckArray1);
		assertEquals(0,bestProfit1);

		int[] noLuckArray2={3333,333,333};
		final int bestProfit2= BestTimeToBuyAndSell.findBestProfit(noLuckArray2);
		assertEquals(0,bestProfit2);
	}


	public  void testEdgeCase1(){
		int[] correctArray={1,3};
		final int bestProfit = BestTimeToBuyAndSell.findBestProfit(correctArray);
		assertEquals(2,bestProfit);
	}

	public  void testEdgeCase2(){
		int[] correctArray={3,1};
		final int bestProfit = BestTimeToBuyAndSell.findBestProfit(correctArray);
		assertEquals(0,bestProfit);
	}

}