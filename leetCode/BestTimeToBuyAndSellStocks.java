import java.util.*;

/*
 * 121. Best Time to Buy and Sell Stock
 * ----------------------------------------------
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share 
 * of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * ----------------------------------------------
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

class Solution{

    public static int maxProfit(int[] prices) {
        
        int self = 0;
        int other = 0;
        int diff = 0;
        
        for(int i=0; i< prices.length; i++){
            for(int k =i+1 ;k< prices.length; k++){
                if(prices[k]-prices[i] > diff){
                    diff = prices[k]-prices[i];
                    self = i;
                    other = k;
                }
            }
        }
        
        if(diff == 0 )
            return 0;
        return prices[other] - prices[self];
    }

    public static in maxProfitHelper(int[] prices){
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0; // verbose
        int max = 0;
        
        for(int i = 1; i < n; i++){
            int diff = prices[i] - prices[i-1];
            if(dp[i-1]+diff >0){
                dp[i] = diff+dp[i-1];
                if(max<dp[i])
                    max = dp[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}