package leetcode;

/**
 *  #121 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *  
 * Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
	/**
	 * brute force solution - Runtime : O(N^2), Space : O(1)
	 */
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buyPrice = prices[0];
		int sellPrice = prices[0];
		
		if (prices == null || prices.length == 0)
			return 0;
		
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				
				if (profit > maxProfit) {
					maxProfit = profit;
					buyPrice = prices[i];
					sellPrice = prices[j];
				}
			}
		}
		System.out.println("buyPrice = " + buyPrice + ", sellPrice = " + sellPrice);
		return maxProfit;
	}
	
	/**
	 * One pass solution - Runtime : O(N), Space : O(1)
	 */
	public static int maxProfitFast(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		
		int minPrice = prices[0];
		int buyPrice = prices[0];
		int sellPrice = prices[0];
		int maxProfit = 0;
		
		for(int i = 1; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			int profit = prices[i] - minPrice;
			
			if(profit > maxProfit) {
				maxProfit = profit;
				sellPrice = prices[i];
				buyPrice = minPrice;
			}
		}
		System.out.println(sellPrice +" - " + buyPrice);
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int[] prices2 = { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit(prices2));
		//System.out.println(maxProfitFast(prices));
		//System.out.println(maxProfitFast(prices2));
	}
}
