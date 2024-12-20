//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> spirallyTraverse(vector<vector<int> > &mat) {
        // code here
        vector<int> result;
    int n = mat.size();    // Number of rows
    int m = mat[0].size(); // Number of columns
    
    int top = 0, bottom = n - 1, left = 0, right = m - 1;

    while (top <= bottom && left <= right) {
        // Traverse from left to right on the top row
        for (int i = left; i <= right; i++) {
            result.push_back(mat[top][i]);
        }
        top++; // Move the top boundary down

        // Traverse from top to bottom on the rightmost column
        for (int i = top; i <= bottom; i++) {
            result.push_back(mat[i][right]);
        }
        right--; // Move the right boundary left

        // Traverse from right to left on the bottom row (if still within bounds)
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                result.push_back(mat[bottom][i]);
            }
            bottom--; // Move the bottom boundary up
        }

        // Traverse from bottom to top on the leftmost column (if still within bounds)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.push_back(mat[i][left]);
            }
            left++; // Move the left boundary right
        }
    }

    return result;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;

    while (t--) {
        int r, c;
        cin >> r >> c;
        vector<vector<int>> matrix(r);

        for (int i = 0; i < r; i++) {
            matrix[i].assign(c, 0);
            for (int j = 0; j < c; j++) {
                cin >> matrix[i][j];
            }
        }

        Solution ob;
        vector<int> result = ob.spirallyTraverse(matrix);
        for (int i = 0; i < result.size(); ++i)
            cout << result[i] << " ";
        cout << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends