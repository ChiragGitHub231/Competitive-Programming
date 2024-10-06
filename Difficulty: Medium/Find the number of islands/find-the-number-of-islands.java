//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int dir[][] = {{0,-1}, {0,1}, {1,0}, {-1,0}, {1,-1}, {1,1}, {-1,-1}, {-1,1}};
    
    void dfs(int i, int j, int m, int n, char grid[][]){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int d[] : dir) dfs(d[0] + i, d[1] + j, m, n, grid);
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int m = grid.length, n = grid[0].length, ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1') ans++;
                dfs(i, j, m, n, grid);
            }
        }
        return ans;
    }
}