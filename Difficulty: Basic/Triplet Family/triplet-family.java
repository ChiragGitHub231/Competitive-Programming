//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    boolean search(int[] arr, int sum, int low, int high) {
        while(low <= high) {
            int middle = (low + high) / 2;
            if(arr[middle] == sum) return true;
            else if(arr[middle] < sum) low = middle + 1;
            else high = middle - 1;
        }
        return false;
    }
    
    public boolean findTriplet(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int sum = arr[i] + arr[j];
                if(search(arr, sum, j+1, n-1)) return true;
            }
        }
        
        return false;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            boolean res = obj.findTriplet(arr);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends