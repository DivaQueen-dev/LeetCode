class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder xb = new StringBuilder();
        StringBuilder yb = new StringBuilder();
        StringBuilder others = new StringBuilder();
        for(int i=0 ;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==x)
            {
                xb.append(ch);
            }
            else if(ch==y)
            {
                yb.append(ch);
            }
            else{
                others.append(ch);
            }
        }
        return yb.toString()+others.toString()+xb.toString();
    }
}