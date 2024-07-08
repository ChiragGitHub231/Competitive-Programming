//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int low = 0, high = arr.length-1;
        while(low<=high){
            int middle = (low + high) / 2;
            if(arr[middle] == key) return middle;
            
            if(arr[low] == arr[middle]) low++;
            else if(arr[low] < arr[middle]){
                if(key >= arr[low] && key < arr[middle]) high = middle - 1;
                else low = middle + 1;
            } else {
                if(key > arr[middle] && key <= arr[high]) low = middle + 1;
                else high = middle - 1;
            }
        }
        return -1;
    }
}