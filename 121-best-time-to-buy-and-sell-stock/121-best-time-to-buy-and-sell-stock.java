class Solution {
    public int maxProfit(int[] prices) {
        int least = Integer.MAX_VALUE;
        int ans = 0;
        int priceIfSoldToday = 0;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < least){
                least = prices[i];
            }
            
            priceIfSoldToday = prices[i] - least;
            if(priceIfSoldToday > ans){
                ans = priceIfSoldToday;
            }
        }
        return ans;
    }
}