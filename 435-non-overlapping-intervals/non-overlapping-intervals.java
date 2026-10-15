class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int count=0;
        int prevEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            if(currStart<prevEnd){
            count++;
            prevEnd=Math.min(currEnd,prevEnd);
            }
            else
                prevEnd=currEnd;
        
        }
        return count;
    }
}