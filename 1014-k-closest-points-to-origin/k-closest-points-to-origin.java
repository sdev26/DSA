class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->dist(b)-dist(a));
        for(int []point:points){
            pq.add(point);
            if(pq.size()>k)
                pq.poll();
        }
      int res[][]=new int[k][2];
      for(int i=0;i<k;i++){
        res[i]=pq.poll();
      }
      return res;
    }
    public int dist(int[]point){
        return point[0]*point[0]+point[1]*point[1];
    }
}