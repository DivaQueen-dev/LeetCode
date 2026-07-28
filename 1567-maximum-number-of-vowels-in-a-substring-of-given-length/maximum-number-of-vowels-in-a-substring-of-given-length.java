class Solution {

    static boolean isVowel(char ch) {
        String vowels = "aeiou";
        return vowels.indexOf(ch) != -1;
    }

    public int maxVowels(String s, int k) {
        char[] ch = s.toCharArray();

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(ch[i])) {
                count++;
            }
        }

        int ans = count;
        for (int i = k; i < ch.length; i++) {
            if (isVowel(ch[i - k])) {
                count--;
            }
            if (isVowel(ch[i])) {
                count++;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}