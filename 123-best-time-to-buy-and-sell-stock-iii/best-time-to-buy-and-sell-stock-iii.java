class Solution {
    public int maxProfit(int[] prices) {
       int neg= -1_000_000_000;
       int n=prices.length;
       if(n==0)
        return prices[0];
        int hold[][]=new int[n][3];
        int sold[][]=new int[n][3];
        hold[0][0]=-prices[0];
        sold[0][0]=0;
        hold[0][1]=neg;
        sold[0][1]=neg;
        hold[0][2]=neg;
        sold[0][2]=neg;
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                hold[i][j]=Math.max(hold[i-1][j],sold[i-1][j]-prices[i]);
                if(j==0)
                    sold[i][0]=sold[i-1][0];
                else{
                    sold[i][j]=Math.max(sold[i-1][j],hold[i-1][j-1]+prices[i]);
                }
            }
        }
        int res=Integer.MIN_VALUE;
        res=Math.max(sold[n-1][0],Math.max(sold[n-1][1],sold[n-1][2]));
        return res;
    }
}