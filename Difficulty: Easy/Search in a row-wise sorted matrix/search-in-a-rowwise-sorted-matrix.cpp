//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    bool search(vector<int> &arr, int x) {
        int low = 0, high = arr.size() - 1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(arr[middle] == x) return true;
            else if(arr[middle] < x) low = middle + 1;
            else high = middle - 1;
        }
        return false;
    }
  
    // Function to search a given number in row-column sorted matrix.
    bool searchRowMatrix(vector<vector<int>> &mat, int x) {
        // code here
        int m = mat.size(), n = mat[0].size();
        for(int i=0; i<m; i++) {
            if(mat[i][0] <= x && x <= mat[i][n-1]) {
                if(search(mat[i], x)) return true;
            }
        }
        return false;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {

        int n, m;
        cin >> n >> m;
        vector<vector<int> > matrix(n);

        for (int i = 0; i < n; i++) {
            matrix[i].assign(m, 0);
            for (int j = 0; j < m; j++) {
                cin >> matrix[i][j];
            }
        }

        int x;
        cin >> x;
        Solution obj;
        if (obj.searchRowMatrix(matrix, x))
            cout << "true\n";
        else
            cout << "false\n";

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends