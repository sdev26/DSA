class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i=0;
        int stops=0;
        int fuel=startFuel;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        while(fuel<target){
            while(i<stations.length&&stations[i][0]<=fuel){
            pq.offer(stations[i][1]);
            i++;                
            }
            if(pq.isEmpty())return -1;
            fuel+=pq.poll();
            stops++;
        }
        return stops;
    }
}