class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> nsl=new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        int i=arr.length-1;
        while(i>=0){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl.add(-1);
            }else{
                nsl.add(st.peek());
            }
            st.push(arr[i]);
            i--;
        }
        Collections.reverse(nsl);
        return nsl;
    }
}