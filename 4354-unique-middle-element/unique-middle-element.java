class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
            int mid=(nums.length-1)/2;
        for(int i = 0 ; i < nums.length;i++)
        {
            if(i==mid){
                continue;
            }
            if(nums[i]==nums[mid])
            {
                return false;
            }
        }
        return true;
    }
}