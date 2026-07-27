class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }

        int points[]=new int[max+1];
        for(int i:nums){
            points[i]+=i;
        }
        if(max==1)
            return points[1];        
        int prev2=points[1];
        int prev1=Math.max(points[1],points[2]);
        for(int i=3;i<points.length;i++){
            int curr=Math.max(prev1,points[i]+prev2);
            prev2=prev1;
            prev1=curr;
        }
        return Math.max(prev2,prev1);
    }
}