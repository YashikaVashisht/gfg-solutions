/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public void helper(Node root, HashMap<Node,Node> parent) {
        if(root == null) return;

        if(root.left != null) {
            parent.put(root.left, root);
            helper(root.left, parent);
        }

        if(root.right != null) {
            parent.put(root.right, root);
            helper(root.right, parent);
        }
    }
    
    public Node find(Node root, int target){
        if(root==null) return null;
        if(root.data==target) return root;
        Node left = find(root.left, target);
        if(left != null) return left;
        return find(root.right, target);
    }
    
    public int minTime(Node root, int target) {
        // code here
        
        HashMap<Node , Node> parent = new HashMap<>();
        parent.put(root, null);
        helper(root, parent);
        
        Queue<Node> q= new LinkedList<>();
        HashSet<Node> vis= new HashSet<>();
        Node start= find(root, target);
        
        q.offer(start);
        vis.add(start);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean burn=false;
            
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.left!= null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    q.offer(curr.left);
                    burn=true;
                }
                
                if(curr.right!= null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    q.offer(curr.right);
                    burn=true;
                }
                
                Node par=parent.get(curr);
                if(par!=null && !vis.contains(par)) {
                    vis.add(par);
                    q.offer(par);
                    burn=true;
                }
            }
            if(burn==true) time++;
            
        }
        return time;
        
    }
}