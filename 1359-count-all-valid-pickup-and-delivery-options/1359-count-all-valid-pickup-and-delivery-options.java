class Solution {
    public int countOrders(int n){
        long dp[]=new long[501];
        dp[1]=1;
        dp[2]=6;
        int modulo=(int)Math.pow(10,9)+7;
        for(int i=3;i<=n;i++){
            int num=2*i-1;
            int permutation=(num*(num+1))/2;
            dp[i]=(dp[i-1]*permutation)%modulo;
        }
        return (int) dp[n];
    }
}