class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=Integer.MIN_VALUE;
        for(int i:piles){
            maxPile=Math.max(maxPile,i);
        }
        int left=1,right=maxPile;int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canFinish(piles,mid,h)){
                ans=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return ans;
    }
    public boolean canFinish(int []piles,int mid,int h){
        long hours=0;
        for(int i:piles){
            hours+=(long)(i+mid-1)/mid;
        }
        return hours<=h;
    }
}