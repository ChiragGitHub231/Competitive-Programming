//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // arr: input array
    // Function to find maximum circular subarray sum.
    int circularSubarraySum(vector<int> &arr) {
        // your code here
        int n = arr.size(), mini = INT_MAX, maxi = INT_MIN;
        int sum1 = 0, sum2 = 0, total = 0;
        
        for(int i=0; i<n; i++) {
            sum1 += arr[i];
            sum2 += arr[i];
            total += arr[i];
            
            if(sum2 > 0) sum2 = 0;
            else mini = min(mini, sum2);
            
            if(sum1 < 0) sum1 = 0;
            else maxi = max(maxi, sum1);
        }
        
        return max(maxi, total - mini);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;

        // Read first array
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int res = ob.circularSubarraySum(arr);

        cout << res << endl;
    }
    return 0;
}

// } Driver Code Ends