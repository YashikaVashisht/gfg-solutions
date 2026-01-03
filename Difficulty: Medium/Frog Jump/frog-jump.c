#include <limits.h> 
#include <stdlib.h>  

int f(int arr[], int i,int dp[]){
    if(i==0) return 0;
    
    if(dp[i]!=-1) return dp[i];
    int left= f(arr,i-1, dp)+abs(arr[i]-arr[i-1]);
    int right= INT_MAX;
    if(i>1){
        right=f(arr,i-2, dp)+abs(arr[i]-arr[i-2]);
    }
    return dp[i]=left < right ? left : right;
}


int minCost(int height[], int n) {
    // code here
    
    int dp[n];
    for (int i = 0; i < n; i++) {
        dp[i] = -1;   
    }
    return f(height,n-1, dp);
}