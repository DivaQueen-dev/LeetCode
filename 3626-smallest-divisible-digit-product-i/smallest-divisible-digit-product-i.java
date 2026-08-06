class Solution {
    public static int digipro(int num){
        int product=1;
        while(num!=0){
          product*=num%10;
          num/=10;
        }
       return product;
    }
    public int smallestNumber(int n, int t) {
       while(true){
        if(digipro(n)%t==0){
            return n;
        }
        n++;
       }
       
    }
}