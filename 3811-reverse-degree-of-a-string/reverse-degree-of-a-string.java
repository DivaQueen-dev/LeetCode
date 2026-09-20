class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int alphabetPosition = s.charAt(i) - 'a' + 1;
            int reverseValue = 27 - alphabetPosition;
            sum += reverseValue * (i + 1);
        }

        return sum;
    }
}