/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public int maxProfit(int[] prices) {
    int local = 0;
    int max = local;
    for(int i = 1; i < prices.length; i++) {
        local = Math.max(prices[i]-prices[i-1]+local, prices[i]-prices[i-1]);
        max = Math.max(max, local);
    }
    return max;
}
