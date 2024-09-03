//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
		

	public:
	int minOperations(string str1, string str2) 
	{ 
	    // Your code goes here
	    int m = str1.length(), n = str2.length();
	    int dp[m+1][n+1];
	    for(int i=0; i<=m; i++) dp[i][0]=0;
	    for(int j=0; j<=n; j++) dp[0][j]=0;
	    for(int i=1; i<=m; i++){
	        for(int j=1; j<=n; j++){
	            dp[i][j] = str1[i-1]==str2[j-1] ? 1+dp[i-1][j-1] : max(dp[i-1][j], dp[i][j-1]);
	        }
	    }
	    return m+n-2*dp[m][n];
	} 
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        string s1, s2;
        cin >> s1 >> s2;

	    Solution ob;
	    cout << ob.minOperations(s1, s2) << "\n";
	     
    }
    return 0;
}


// } Driver Code Ends