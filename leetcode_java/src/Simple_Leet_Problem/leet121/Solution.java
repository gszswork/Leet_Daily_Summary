package leet121;

public class Solution {
    public int maxProfit(int[] prices) {
    	// one pass 一遍扫描，记录最小值
    	int min = Integer.MAX_VALUE;
    	int max = 0;
    	for (int i=0; i<prices.length; i++) {
    		if (prices[i] < min) {
    			min = prices[i];
    		}
    		if (prices[i] - min > max) {
    			max = prices[i]-min;
    		}
    	}
        	
        return max;
    }
}
