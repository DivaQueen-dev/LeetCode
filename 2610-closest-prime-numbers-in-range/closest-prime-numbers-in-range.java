class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];

        for (int i = 2; i <= right; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int ans1 = -1;
        int ans2 = -1;
        int prevPrime = -1;
        int minGap = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {

                if (prevPrime == -1) {
                    prevPrime = i;
                } else {
                    int gap = i - prevPrime;

                    if (gap < minGap) {
                        minGap = gap;
                        ans1 = prevPrime;
                        ans2 = i;
                    }

                    prevPrime = i;
                }
            }
        }

        return new int[] { ans1, ans2 };
    }
}