class Solution {
    public int maxProfit(int[] prices) {
        int max_profit=0 , best_buyprice=prices[0] ;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>best_buyprice)
            {
                max_profit=Math.max(max_profit,prices[i]-best_buyprice);
            }
            best_buyprice=Math.min(best_buyprice,prices[i]);
        }
        return max_profit;
    }
}