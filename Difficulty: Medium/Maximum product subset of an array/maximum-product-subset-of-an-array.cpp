//{ Driver Code Starts
/* Driver program to test above function */

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    long long int findMaxProduct(vector<int>& arr) {
        // Write your code here
        int n=arr.size(), neg=0, zero=0, negative=-1e9, mod=1e9+7;
        long long int product=1;
        
        for(int i=0; i<n; i++){
            if(arr[i]==0) zero++;
            else if(arr[i]<0){
                neg++;
                negative=max(negative, arr[i]);
                product*=arr[i];
            } else product*=arr[i];
            product%=mod;
        }
        
        if(zero==n) return 0;
        if(neg==1 && zero==n-1) return 0;
        if(neg%2==0) return product;
        if(neg%2==1) product/=negative;
        
        return product;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        long long int ans = ob.findMaxProduct(arr);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends