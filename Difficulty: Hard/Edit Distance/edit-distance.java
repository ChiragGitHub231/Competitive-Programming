//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int help(String str1, String str2, int m, int n, int[][] dp){
        if(m == 0) return n;
        if(n == 0) return m;
        
        if(dp[m][n] != -1) return dp[m][n];
        
        if(str1.charAt(m-1) == str2.charAt(n-1)) return dp[m][n]=help(str1, str2, m-1, n-1, dp);
        
        return dp[m][n]=Math.min(help(str1, str2, m, n-1, dp)+1, 
                        Math.min(help(str1, str2, m-1, n, dp)+1, 
                        help(str1, str2, m-1, n-1, dp)+1));
    }
    
    public int editDistance(String str1, String str2) {
        // Code here
        int m = str1.length(), n = str2.length();
        int dp[][] = new int[m+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return help(str1, str2, m, n, dp);
    }
}