//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class DisjointSet {
    public:
    vector<int> parent, size;
    DisjointSet(int n){
        parent.resize(n+1);
        size.resize(n+1);
        for(int i=0; i<=n; i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    int findPar(int node){
        if(node==parent[node]) return node;
        return parent[node]=findPar(parent[node]);
    }
    
    void unionBySize(int u, int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);
        if(ulp_u==ulp_v) return;
        
        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        } else {
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }
};

class Solution {
  public:
    bool isValid(int newr, int newc, int n){
        return newr>=0 && newr<n && newc>=0 && newc<n;
    }
    
    int MaxConnection(vector<vector<int>>& grid) {
        // code here
        int n=grid.size();
        DisjointSet ds(n*n);
        
        for(int row=0; row<n; row++){
            for(int column=0; column<n; column++){
                if(grid[row][column]==0) continue;
                int dr[]={-1, 0, 1, 0};
                int dc[]={0, -1, 0, 1};
                for(int index=0; index<4; index++){
                    int newr=row+dr[index];
                    int newc=column+dc[index];
                    if(isValid(newr,newc,n) && grid[newr][newc]==1){
                        int nodeNo=row*n+column;
                        int adjNodeNo=newr*n+newc;
                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }
        
        int maxi=0;
        for(int row=0; row<n; row++){
            for(int column=0; column<n; column++){
                if(grid[row][column]==1) continue;
                int dr[]={-1, 0, 1, 0};
                int dc[]={0, -1, 0, 1};
                set<int> components;
                for(int index=0; index<4; index++){
                    int newr=row+dr[index];
                    int newc=column+dc[index];
                    if(isValid(newr,newc,n)){
                        if(grid[newr][newc]==1) components.insert(ds.findPar(newr*n+newc));
                    }
                }
                int sizeTotal=0;
                for(auto it:components) sizeTotal+=ds.size[it];
                maxi=max(maxi,sizeTotal+1);
            }
        }
        
        for(int i=0; i<n*n; i++) maxi=max(maxi,ds.size[ds.findPar(i)]);
        
        return maxi;
    }
};


//{ Driver Code Starts.
int main() {

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> grid(n, vector<int>(n));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> grid[i][j];
            }
        }

        Solution obj;
        cout << obj.MaxConnection(grid) << "\n";
    }
}

// } Driver Code Ends