class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n= arr.length;
        int[][] train= new int[n][2];
        for(int i=0;i< n;i++){
            train[i][0]= arr[i];
            train[i][1]= dep[i];
        }
        // Arrays.sort(train, Comparator.comparingInt(o -> o[1]));
        // int count=1;
        // int last= train[0][1];
        // for(int i=1;i<n;i++){
        //     if(train[i][0] > last){
        //         count++;
        //         last= train[i][1];
        //     }
        // }
        // return count;
        Arrays.sort(train, Comparator.comparingInt(o -> o[0]));

        // Use a min-heap to track current trains on platforms (by departure time)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(train[0][1]); // first train's departure time
        int maxPlatforms = 1;

        for (int i = 1; i < n; i++) {
            int arrival = train[i][0];
            int departure = train[i][1];

            // Remove trains that have already departed before this train arrives
            while (!pq.isEmpty() && pq.peek() < arrival) {
                pq.poll();
            }

            // Add current train’s departure
            pq.add(departure);

            // Track max platforms needed at once
            maxPlatforms = Math.max(maxPlatforms, pq.size());
        }

        return maxPlatforms;
    }
}
