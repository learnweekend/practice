package com.all;

/**
 * Given a list of stock prices for n days, find the maximum profit with a single buy/sell activity.
 */

public class MaxProfit {
	
	/**
	 * Solution : Use maintain the running minimum stock price and max running profit
	 * Kadane's algorithms
	 * runtime : O(N), space : O(1).
	 */
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int maxProfit = 0;
        int minStockPrice = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(prices[i] - minStockPrice, maxProfit);
            minStockPrice = Math.min(prices[i], minStockPrice);
        }
        return maxProfit;
    }

	public static void main(String[] args) {
		int[] stockPrices = new int[] {100, 80, 120, 130, 70, 60, 100, 125};
		System.out.println("max profit = " + maxProfit(stockPrices));
	}

}
