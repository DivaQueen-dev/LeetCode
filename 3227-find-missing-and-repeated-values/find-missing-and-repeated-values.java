class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int xor = 0;

        for (int[] row : grid) {
            for (int num : row) {
                xor ^= num;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            xor ^= i;
        }

        int rightmostBit = xor & -xor;

        int bucket1 = 0;
        int bucket2 = 0;

        for (int[] row : grid) {
            for (int num : row) {

                if ((num & rightmostBit) != 0) {
                    bucket1 ^= num;
                } else {
                    bucket2 ^= num;
                }
            }
        }

        for (int i = 1; i <= n * n; i++) {

            if ((i & rightmostBit) != 0) {
                bucket1 ^= i;
            } else {
                bucket2 ^= i;
            }
        }

        int repeated;
        int missing;

        boolean found = false;

        for (int[] row : grid) {
            for (int num : row) {

                if (num == bucket1) {
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            repeated = bucket1;
            missing = bucket2;
        } else {
            repeated = bucket2;
            missing = bucket1;
        }

        return new int[]{repeated, missing};
    }
}