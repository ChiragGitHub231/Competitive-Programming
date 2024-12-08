//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<vector<int>> mergeOverlap(vector<vector<int>>& intervals) {
        // Code here
        sort(intervals.begin(), intervals.end());
        
        vector<vector<int>> ans;
        
        ans.push_back(intervals[0]);
        
        for(int i=1; i<intervals.size(); i++) {
            int n = ans.size();
            int initial_left = ans[n-1][0];
            int initial_right = ans[n-1][1];
            
            int new_left = intervals[i][0];
            int new_right = intervals[i][1];
            
            if(new_left >= initial_left && new_left <= initial_right) {
                ans.pop_back();
                ans.push_back({initial_left, max(initial_right, new_right)});
            } else {
                ans.push_back(intervals[i]);
            }
        }
        
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n;
        cin >> n;
        vector<vector<int>> arr(n);
        for (int i = 0; i < n; i++) {
            int x, y;
            cin >> x >> y;
            arr[i].push_back(x);
            arr[i].push_back(y);
        }
        Solution obj;
        vector<vector<int>> ans = obj.mergeOverlap(arr);
        for (auto i : ans) {
            for (auto j : i) {
                cout << j << " ";
            }
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends