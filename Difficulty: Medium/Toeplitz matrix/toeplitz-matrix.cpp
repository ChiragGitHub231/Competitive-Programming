//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

bool isToepliz(vector<vector<int>> &mat);

int main() {
    // your code goes here
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> a(n, vector<int>(m, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                cin >> a[i][j];
        }

        bool b = isToepliz(a);

        if (b == true)
            cout << "true";
        else
            cout << "false";

        cout << endl;
    }
    return 0;
}
// } Driver Code Ends



bool isToepliz(vector<vector<int>>& mat) {
    // code here
    bool flag=true;
    for(int i=0; i<mat.size()-1; i++){
        for(int j=0; j<mat[0].size()-1; j++){
            if(i!=j && i+1!=j+1 && mat[i][j]!=mat[i+1][j+1]) flag=false;
        }
    }
    return flag;
}