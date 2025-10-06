class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        int[][] activities= new int[n][3];
        
        for(int i=0;i<n;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=finish[i];
        }
        
        Arrays.sort(activities, Comparator.comparingDouble(o->o[2]));
        
        ArrayList<Integer> res= new ArrayList<>();
        
        res.add(activities[0][0]);
        int lastFinish= activities[0][2];
        for(int i=1;i<n;i++){
            if(activities[i][1]> lastFinish){
                res.add(activities[i][0]);
                lastFinish= activities[i][2];
            }
        }
        
        
        return res.size();
    }
}
