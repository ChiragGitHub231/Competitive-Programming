//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to check if two strings are rotations of each other or not.
    bool areRotations(string &s1, string &s2) {
        // Your code here
        string str = s2 + '$' + s1 + s1;
        int n = str.length(), i = 0, j = 1, m = s2.length();
        vector<int> lps(n, 0);
        
        while(j < n) {
            if(str[i] == str[j]) {
                lps[j++] = ++i;
                if(i == m) return true;
            } else if(i) i = lps[i - 1];
            else j++;
        }
        
        return false;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s1;
        string s2;
        cin >> s1 >> s2;
        Solution sol;
        int result = sol.areRotations(s1, s2);
        if (result) {
            cout << "true" << endl;

        } else {
            cout << "false" << endl;
        }
        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends