class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;int size=0;
        int tails[]=new int[n];
        for(int i:nums){
            int left=0,right=size;
            while(left<right){
                int mid=left+(right-left)/2;
                if(tails[mid]<i)
                    left=mid+1;
                else
                    right=mid;
            }
            tails[left]=i;
            if(left==size)size++;
        }
        return size;
    }
}