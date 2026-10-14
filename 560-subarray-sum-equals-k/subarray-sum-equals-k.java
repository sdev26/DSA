class Solution {
    public int subarraySum(int[] nums, int k) {
        int start=0,count=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            if(hm.containsKey(sum-k)){
                count+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}