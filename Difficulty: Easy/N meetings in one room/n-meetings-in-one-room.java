class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n= start.length;
        int[][] meetings= new int[n][3];
        
        for(int i=0;i<n;i++){
            meetings[i][0]= i;
            meetings[i][1]= start[i];
            meetings[i][2]= end[i];
        }
        
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[2]));
        
        int count=1;
        int last= meetings[0][2];
        for(int i=1;i<n;i++){
            if(meetings[i][1] > last){
                count++;
                last= meetings[i][2];
            }
        }
        return count;
    }
}
