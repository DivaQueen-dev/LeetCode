class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int k = s1.length();

        for (int i = 0; i < k; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, window)) {
            return true;
        }

        for (int i = k; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - k) - 'a']--;

            if (Arrays.equals(s1Freq, window)) {
                return true;
            }
        }

        return false;
    }
}