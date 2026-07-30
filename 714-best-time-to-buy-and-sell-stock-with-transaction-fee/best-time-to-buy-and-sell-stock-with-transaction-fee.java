class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        if(n==0)
            return 0;
        int hold[]=new int[n];
        int sold[]=new int[n];
        hold[0]=-prices[0];
        sold[0]=0;
        for(int i=1;i<n;i++){
            hold[i]=Math.max(hold[i-1],sold[i-1]-prices[i]);
            sold[i]=Math.max(sold[i-1],hold[i-1]+prices[i]-fee);
        }
        return Math.max(sold[n-1],hold[n-1]);
    }
}