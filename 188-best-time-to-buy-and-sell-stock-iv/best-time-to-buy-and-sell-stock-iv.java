class Solution {
    public int maxProfit(int k, int[] prices) {
        int neg=-1000000;
        int n=prices.length;
        if(n==0)
            return 0;
        int hold[][]=new int[n][k+1];
        int sold[][]=new int[n][k+1];
        hold[0][0]=-prices[0];
        sold[0][0]=0;
        for(int i=1;i<=k;i++){
            hold[0][i]=neg;
            sold[0][i]=neg;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                hold[i][j]=Math.max(hold[i-1][j],sold[i-1][j]-prices[i]);
                if(j==0)
                    sold[i][j]=sold[i-1][0];
                else
                    sold[i][j]=Math.max(sold[i-1][j],hold[i-1][j-1]+prices[i]);
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<=k;i++){
            res=Math.max(res,sold[n-1][i]);
        }
        return res;
    }
}