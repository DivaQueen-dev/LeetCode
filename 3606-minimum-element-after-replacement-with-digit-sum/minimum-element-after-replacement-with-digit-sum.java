class Solution {
    public int minElement(int[] nums) {

        int minimumDigitSum = Integer.MAX_VALUE;

        for (int currentNumber : nums) {

            int digitSum = 0;

            while (currentNumber > 0) {

                int lastDigit = currentNumber % 10;

                digitSum += lastDigit;

                currentNumber /= 10;
            }

            minimumDigitSum = Math.min(minimumDigitSum, digitSum);
        }

        return minimumDigitSum;
    }
}