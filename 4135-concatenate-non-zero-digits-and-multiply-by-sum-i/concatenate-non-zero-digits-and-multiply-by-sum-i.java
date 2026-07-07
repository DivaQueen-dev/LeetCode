class Solution {
    public long sumAndMultiply(int num) {
        long x =0 ;
        int place=1;
        int sum=0;
        while(num>0)
        {
            int ld=num%10;
            if(ld!=0)
            {
                sum+=ld;
                x=ld*place+x;
                place*=10;
            }

            num/=10;

        }
        return x*sum;
    }
}