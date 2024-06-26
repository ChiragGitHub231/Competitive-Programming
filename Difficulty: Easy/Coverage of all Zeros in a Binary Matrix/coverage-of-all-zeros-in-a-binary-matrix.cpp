//{ Driver Code Starts


#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    int findCoverage(vector<vector<int>>& matrix) {
        // Code here
        int counter=0, n=matrix.size(), m=matrix[0].size();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0){
                    // Left
                    if(j-1>=0 && matrix[i][j-1]) counter++;
                    
                    // Right
                    if(j+1<m && matrix[i][j+1]) counter++;
                    
                    // Up
                    if(i-1>=0 && matrix[i-1][j]) counter++;
                    
                    // Down
                    if(i+1<n && matrix[i+1][j]) counter++;
                }
            }
        }
        return counter;
    }
};


//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> matrix(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cin >> matrix[i][j];
        Solution obj;
        int ans = obj.findCoverage(matrix);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends