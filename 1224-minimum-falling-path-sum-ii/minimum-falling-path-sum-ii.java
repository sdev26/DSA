class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=grid[i][0];
        }
        for(int j=0;j<n;j++){
            dp[0][j]=grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=0;k<n;k++){
                    if(k!=j)
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][k]);
                }
                dp[i][j]+=grid[i][j];
            }
        }
      int res=Integer.MAX_VALUE;
      for(int i=0;i<n;i++){
        res=Math.min(res,dp[m-1][i]);
      }
      return res;
    }
}