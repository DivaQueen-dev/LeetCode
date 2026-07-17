class Solution {
    public int gcd(int a ,int b)
    {
        while(b!=0)
        {
            int t=a%b;
            a=b;
            b=t;
        }
        return a;

    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        int m=Integer.MIN_VALUE;
        for(int i=0 ;i<n;i++)
        {
           m=Math.max(nums[i],m);
           arr[i]=gcd(m,nums[i]);
        }
        Arrays.sort(arr);
    long ans=0;
    int left=0;
    int right=n-1;
    while(left<right)
    {
        ans+=gcd(arr[left++],arr[right--]);
    }
    return ans;
    }
}