class Solution {
    public double myPow(double x, int n) {

        double base = x;
        long exponent = n;

        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        double result = 1;

        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                result *= base;
            }

            base *= base;

            exponent >>= 1;
        }

        return result;
    }
}