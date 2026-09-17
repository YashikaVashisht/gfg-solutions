class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node= node;
            this.wt= wt;
        }
    }
    public int spanningTree(int n, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> a.wt-b.wt);
        //MIN heap  
        boolean[] vis = new boolean[n];
        int sum=0;
        
        pq.offer(new Pair(0,0)); // node, wt;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.wt;
            
            if(vis[node]==true) continue; //if already, vis go ahead
            
            vis[node]=true;//else mark it vis
            sum+=dis; // add dist to sum 
            for(Pair neigh :  adj.get(node)){
                int v= neigh.node;
                int dist= neigh.wt;
                if(!vis[v]){
                    pq.offer(new Pair(v,dist));
                }
            }
        }
        return sum;
    }
}
