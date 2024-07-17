//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    int nthFibonacci(int n){
        // code here
        if(n==1 || n==2) return 1;
        else {
            int mod=1e9+7;
            int n1=1, n2=1, ans=0;
            n-=2;
            while(n-->0){
                ans = (n1 + n2)%mod;
                n1 = n2;
                n2 = ans;
            }
            return ans%mod;
        }
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.nthFibonacci(n) << endl;
    }
    return 0;
}

// } Driver Code Ends