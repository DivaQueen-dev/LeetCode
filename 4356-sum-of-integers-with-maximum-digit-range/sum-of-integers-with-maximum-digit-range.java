class Solution {
      public int getrange(int num)
        {
            int min=Integer.MAX_VALUE; 
            int max=Integer.MIN_VALUE;
            while(num>0)
            {
                int ld=num%10;
                max=Math.max(max,ld);
                min=Math.min(min,ld);
                num/=10;
            }
            return max-min;
        }
    public int maxDigitRange(int[] nums) {
        int maxrange=-1;
        int sum=0;
        for(int num:nums)
        {
            int range=getrange(num);
            if(range>maxrange)
            {
                maxrange=range;
                sum=num;
            }
            else if(range==maxrange){
                sum+=num;
            }
        }
        return sum;
    }
}