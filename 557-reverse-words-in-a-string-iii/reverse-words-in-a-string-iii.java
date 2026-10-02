class Solution {
    public String reverseWords(String s) {
        String str[]=s.trim().split("\\s+");
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<str.length;i++){
            StringBuilder temp=new StringBuilder(str[i]);
            ans.append(temp.reverse());
            if(i!=str.length-1){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}