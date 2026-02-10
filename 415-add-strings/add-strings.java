import java.math.BigInteger;
class Solution {
    public String addStrings(String num1, String num2) {
        BigInteger name1=new BigInteger(num1);
        BigInteger name2=new BigInteger(num2);
        BigInteger sum=name1.add(name2);
       String temp=String.valueOf(sum);
       return temp;
    }
}