class Solution {
    public int scoreDifference(int[] nums) {
        int fp = 0, sp = 0;
        boolean turn = true;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1) turn = !turn;
            if(i % 6 == 5) turn = !turn;

            if(turn) fp += nums[i];
            else sp += nums[i];
        }

        return fp - sp;
    }
}