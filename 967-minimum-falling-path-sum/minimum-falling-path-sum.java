class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<n;i++){
            dp[m-1][i]=matrix[m-1][i];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int leftDown=Integer.MAX_VALUE;
                int rightDown=Integer.MAX_VALUE;
                if(j>0)
                    leftDown=dp[i+1][j-1];
                if(j<n-1)
                    rightDown=dp[i+1][j+1];
                dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],Math.min(leftDown,rightDown));
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            res=Math.min(res,dp[0][i]);
        return res;
    }
}