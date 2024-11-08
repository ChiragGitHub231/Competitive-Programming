//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minRepeats(string& s1, string& s2) {
        // code here
        int m = s1.size(), n = s2.size();
        int repeats = (n + m - 1) / m;
  
        std::string repeated = s1;
        for(int i = 1; i < repeats; ++i) repeated += s1;

        if(repeated.find(s2) != std::string::npos) return repeats;

        repeated += s1;
        if(repeated.find(s2) != std::string::npos) return repeats + 1;
    
        return -1; 
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {
        string A, B;
        getline(cin, A);
        getline(cin, B);

        Solution ob;
        cout << ob.minRepeats(A, B) << endl;
    }
    return 0;
}
// } Driver Code Ends