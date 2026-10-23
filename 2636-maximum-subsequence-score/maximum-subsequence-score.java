class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int[][]pairs=new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=nums2[i];
            pairs[i][1]=nums1[i];
        } 
    Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    long currentSum=0,maxSum=0;
    for(int pair[]:pairs){
        int n1=pair[1];
        int n2=pair[0];
        pq.add(n1);
        currentSum+=n1;
        if(pq.size()>k){
            currentSum-=pq.poll();
        }
        if(pq.size()==k){
                maxSum=Math.max(maxSum,currentSum*n2);
        }
    }
    return maxSum;
    }
}