class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i*i<=n;i++){
            int square=i*i;
            for(int j=square;j<=n;j++){
                if(dp[j-square]!=Integer.MAX_VALUE)
                    dp[j]=Math.min(dp[j],1+dp[j-square]);
            }
        }
        return dp[n];
    }
}