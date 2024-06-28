//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    bool isPalindrome(string str){
        int n=str.size();
        for(int i=0; i<n/2; i++){
            if(str[i]!=str[n-i-1]) return false;
        }
        return true;
    }

    string pattern(vector<vector<int>> &arr) {
        // Code Here
        int n=arr.size();
        
        // rows first
        for(int i=0; i<n; i++){
            string k;
            for(int j=0; j<n; j++){
                k+=to_string(arr[i][j]);
            }
            if(isPalindrome(k)){
                string ans;
                ans+=to_string(i);
                ans+=" R";
                return ans;
            }
        }
        
        // columns first
        for(int j=0; j<n; j++){
            string k;
            for(int i=0; i<n; i++){
                k+=to_string(arr[i][j]);
            }
            if(isPalindrome(k)){
                string ans;
                ans+=to_string(j);
                ans+=" C";
                return ans;
            }
        }
        
        return "-1";
    }
};


//{ Driver Code Starts.

int main() {

    int t, n, i, j, flag, k;
    cin >> t;

    while (t--) {
        cin >> n;
        vector<vector<int>> a(n, vector<int>(n));

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                cin >> a[i][j];
        }
        Solution ob;
        cout << ob.pattern(a) << endl;
    }
    return 0;
}
// } Driver Code Ends