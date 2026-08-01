class Solution {
    public int lengthOfLIS(int[] nums) {
        int tails[]=new int[nums.length+1];
         int size=0;
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