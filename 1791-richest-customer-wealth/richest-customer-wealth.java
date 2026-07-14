class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxwealth=0;
        for(int rows[]: accounts)
        {
             int wealth=0; 
            for(int cols:rows)
            {
                wealth+=cols;
            }
            maxwealth=Math.max(wealth,maxwealth);
        }
        return maxwealth;
    }
}