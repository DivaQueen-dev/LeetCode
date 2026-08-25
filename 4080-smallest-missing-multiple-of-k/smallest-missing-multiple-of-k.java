import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i = 1; ; i++) {
            int mul = k * i;
            if (!set.contains(mul)) {
                return mul;
            }
        }
    }
}
