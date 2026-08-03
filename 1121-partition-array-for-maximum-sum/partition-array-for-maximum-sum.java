class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int best=0,maxElement=0;
            for(int j=i;j<Math.min(n,i+k);j++){
                maxElement=Math.max(maxElement,arr[j]);
                int length=j-i+1;
                int candidate=maxElement*length+dp[j+1];
                best=Math.max(best,candidate);
            }
            dp[i]=best;
        }
        return dp[0];
    }
}