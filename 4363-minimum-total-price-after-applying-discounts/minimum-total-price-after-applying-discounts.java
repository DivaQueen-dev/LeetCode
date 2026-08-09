class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double ans = 0.0;

        int price = prices.length - 1;
        int discount = discounts.length - 1;

        while (price >= 0 && discount >= 0 && discounts[discount] >= 0) {
            ans += (double) prices[price] * (100 - discounts[discount]) / 100.0;
            price--;
            discount--;
        }

        while (price >= 0) {
            ans += prices[price];
            price--;
        }
        System.out.println(ans);
        return ans; 
    }
}