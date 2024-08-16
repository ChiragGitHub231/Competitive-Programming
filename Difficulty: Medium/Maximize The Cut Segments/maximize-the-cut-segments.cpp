//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;



// } Driver Code Ends
class Solution
{
    public:
    int solve(int n, int x, int y, int z, int sum, vector<int>& dp){
        if(sum == n) return 0;
        if(sum > n) return INT_MIN;
        if(dp[sum] != -1) return dp[sum];
        
        int sum_x = solve(n, x, y, z, sum+x, dp);
        int sum_y = solve(n, x, y, z, sum+y, dp);
        int sum_z = solve(n, x, y, z, sum+z, dp);
        
        return dp[sum] = 1 + max(sum_x, max(sum_y, sum_z));
    }
    
    //Function to find the maximum number of cuts.
    int maximizeTheCuts(int n, int x, int y, int z)
    {
        //Your code here
        vector<int> dp(n+1, -1);
        int ans = solve(n, x, y, z, 0, dp);
        if(ans < 0) return 0;
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    
    //taking testcases
    int t;
    cin >> t;
    while(t--)
    {
        //taking length of line segment
        int n;
        cin >> n;
        
        //taking types of segments
        int x,y,z;
        cin>>x>>y>>z;
        Solution obj;
        //calling function maximizeTheCuts()
        cout<<obj.maximizeTheCuts(n,x,y,z)<<endl;

    }

	return 0;
}
// } Driver Code Ends