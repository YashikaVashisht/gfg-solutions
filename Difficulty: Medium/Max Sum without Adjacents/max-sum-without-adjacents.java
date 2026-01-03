// User function Template for Java

class Solution {
    public int helper(int arr[], int i, int[]dp){
        if(i<0) return 0;
        if(i==0) return arr[0];
        
        if(dp[i]!=-1) return dp[i];
        int pick= arr[i]+helper(arr,i-2, dp);
        int notpick= 0+ helper(arr,i-1, dp);
        return dp[i]=Math.max(pick, notpick);
         
    }
    int findMaxSum(int arr[]) {
        // code here
        if (arr.length == 0) return 0;
        int[] dp= new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr, arr.length-1, dp);
        
    }
}