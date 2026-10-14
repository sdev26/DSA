class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[]=new int[nums.length];
        Arrays.fill(res,1);
        int leftProduct=1,rightProduct=1;
        for(int i=0;i<nums.length;i++){
            res[i]*=leftProduct;
            leftProduct*=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=rightProduct;
            rightProduct*=nums[i];
        }
        return res;
    }
}