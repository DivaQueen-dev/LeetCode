class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        List<Integer>arrlist=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
            set.add(nums[i]);
        }
        for(int i=min;i<=max;i++){
            if(set.contains(i)){
                continue;
            }
            arrlist.add(i);
        }
        return arrlist;
    }
}