//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int merge(int[] arr, int left, int middle, int right) {
        int j = middle + 1;
        int counter = 0;
        for(int i=left; i<=middle; i++) {
            while(j <= right && arr[i] > arr[j]) {
                j++;
            }
            counter += j - (middle + 1);
        }
        Arrays.sort(arr, left, right + 1);
        return counter;
    }
    
    static int mergeSort(int[] arr, int left, int right) {
        if(left >= right) return 0;
        
        int middle = (left + right) / 2;
        
        int leftInversion = mergeSort(arr, left, middle);
        int rightInversion = mergeSort(arr, middle + 1, right);
        
        int m = merge(arr, left, middle, right);
        
        return leftInversion + rightInversion + m;
    }
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSort(arr, 0, arr.length - 1);
    }
}