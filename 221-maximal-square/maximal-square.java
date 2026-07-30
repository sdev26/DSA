class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m][n];
        if(matrix[0][0]=='1')
            dp[0][0]=1;
        int res=dp[0][0];
        for(int i=1;i<m;i++){
            if(matrix[i][0]=='1')
                dp[i][0]=1;
            res=Math.max(res,dp[i][0]);
        }
        for(int j=1;j<n;j++){
            if(matrix[0][j]=='1')
                dp[0][j]=1;
        res=Math.max(res,dp[0][j]);
        }
     
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int left=dp[i][j-1];
                int topLeft=dp[i-1][j-1];
                int top=dp[i-1][j];
                if(matrix[i][j]=='1')
                    dp[i][j]=Math.min(top,Math.min(topLeft,left))+1;
                res=Math.max(res,dp[i][j]);
            }
        }

      return res*res;
    }
}