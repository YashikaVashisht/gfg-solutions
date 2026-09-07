class Solution {
    public void dfs( int i ,  boolean[] vis, ArrayList<ArrayList<Integer>> adj,Stack<Integer> s ){
        vis[i]= true;
        for(int neigh: adj.get(i)){
            if(vis[neigh]==false){
                dfs(neigh, vis, adj, s);
            }
        } 
        s.push(i);
    }
    public ArrayList<Integer> topoSort(int v, int[][] edges) {
        // code here
        boolean[] vis = new boolean[v];
        Stack<Integer> s= new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u= edge[0];
            int d= edge[1];
            
            adj.get(u).add(d);
        }
        
        for(int i=0;i<v;i++) {
            if(!vis[i]){
                dfs(i, vis , adj, s);
            }
        }
        ArrayList<Integer> l= new ArrayList<>();
        while(!s.isEmpty()){
            l.add(s.pop());
        }
        return l; 
        
        
    }
}