/*
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    class tuple{
        int parent;
        int level;
        Node root;
    }
    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        // your code here
        Queue<Node[]> q = new LinkedList<>();
        q.add(new Node[]{null, root});
        q.add(null);
        Node[] a1 = null;
        Node[] b1 = null;
        
        while(!q.isEmpty()){
            Node[] curr = q.remove();
            if(curr == null){
                
                
                if(a1!=null && b1!=null){
                    if(a1[0] != b1[0]) return true;
                    return false;
                }
                if(a1!= null || b1!=null) return false;
                    
                if(!q.isEmpty()){
                    q.add(null);
                }
                
                
            }
            else{
                if(curr[1].data == a){
                    a1 = curr;
                }
                if(curr[1].data == b){
                    b1 = curr;
                }
                if(curr[1].left != null){
                    q.add(new Node[]{curr[1], curr[1].left});
                }
                if(curr[1].right != null){
                    q.add(new Node[]{curr[1], curr[1].right});
                }
            }
        }
        return false;
        
        // This function should return true if x and y are cousins, else return false
    }
    
}