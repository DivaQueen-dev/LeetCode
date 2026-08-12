class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left=0 ,maxlen=0;
        Map<Integer,Integer>freq=new HashMap<>();
        for(int right=0;right<nums.length;right++){
            freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);
            while(freq.get(nums[right])>k){
                freq.put(nums[left],freq.getOrDefault(nums[left],0)-1);
                left++;
            }
                            maxlen=Math.max(maxlen,right-left+1);

        }
        return maxlen;
    }
}