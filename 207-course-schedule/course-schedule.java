class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int d[]:prerequisites){
            int u=d[0];
            int v=d[1];
            adj.get(v).add(u);
        }
        Queue<Integer>q=new LinkedList<>();
        int indx[]=new int[numCourses];
        for(int i=0;i<indx.length;i++){
            for(int x:adj.get(i)){
                indx[x]++;
            }
        }
        for(int i=0;i<indx.length;i++){
            if(indx[i]==0)
                q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
            for(int v:adj.get(curr)){
                if(--indx[v]==0)
                    q.add(v);
            }
        }
        return count==numCourses?true:false;
    }
}