class Solution {
    public long countSubstrings(String s, char c) {
        long n=0;
        for(char ch : s.toCharArray())
        {
            if(ch==c) n++;
        }
        return n*(n+1)/2;
    }
}