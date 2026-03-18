class Solution {
    public long sumAndMultiply(int n) {
        int j=n;
        StringBuilder o=new StringBuilder();
        long sum=0;
        while(n!=0){
            sum+=(n%10);
            if(n%10!=0){
              o.append((n%10)+"");
            }
            n=n/10;
        }
        long u=(o.toString().trim().equals("")?0:Long.parseLong(o.reverse().toString().trim()));
        long h=u*sum;
        return h;
    }
}