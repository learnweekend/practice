package com.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class StockBuySell {
	
	/**
	 * Solution :  BuyAndSell - 1 transaction
	 * 1. Take variables to track a) buyPrice, b) sellPrice, c) maxProfit, d) minPrices = prices[0].
	 * 2. Iterate the price array i = 1 to end and check/compare with minPrice and update minPrice.
	 * 3. Calculate the profit = currentPrice - minPrice
	 * 4. Update the maxProfit, buyPrice, sellPrice
	 */

	public static int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0)
			return 0;

		int buyPrice = 0;
		int maxProfit = 0;
		int sellPrice = 0;
		
		int minPrice = prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			int profit = prices[i] - minPrice;

			if (profit > maxProfit) {
				maxProfit = profit;
				buyPrice = minPrice;
				sellPrice = prices[i];
			}
		}
		System.out.println("Max profit = " + maxProfit);
		System.out.println("Buy price  = " + buyPrice);
		System.out.println("Sell price = " + sellPrice);

		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = { 5, 4, 3, 2, 1, 2 };
		maxProfit(prices);
	}
}
