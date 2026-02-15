class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> res= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        int i=0;
        int j =0;
        int n= arr.length;
        while(j<n){
            
            //adding negative nu,ber to the queue 
            if(arr[j]<0){
                q.offer(arr[j]);
            }
            
            //checking for window
            if(j-i+1 == k){
                if(q.isEmpty()) {
                    res.add(0);
                }else{
                    res.add(q.peek());
                }
                //removing and shrinking the window
                if(!q.isEmpty() && q.peek()== arr[i]){
                    q.poll();
                }
                i++;
            }
            j++;
        }
        return res;
    }
}