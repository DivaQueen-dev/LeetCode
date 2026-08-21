class Solution {
    public int minStartValue(int[] nums) {
        int prefix = 0;
        int minPrefix = 0;

        for (int num : nums) {
            prefix += num;
            minPrefix = Math.min(minPrefix, prefix);
        }

        return 1 - minPrefix;
    }
}