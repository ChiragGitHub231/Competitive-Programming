//{ Driver Code Starts
// Initial function template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    bool check(vector<int> &stalls, int k, int middle) {
        int counter = 0, previous = -1;
        for(int i=0; i<stalls.size(); i++) {
            if(previous == -1 || stalls[i] - previous >= middle) {
                counter++;
                previous = stalls[i];
            }
        }
        return counter >= k;
    }

    int aggressiveCows(vector<int> &stalls, int k) {
        // Write your code here
        sort(stalls.begin(), stalls.end());
        int n = stalls.size(), low = 0, high = stalls[n-1] - stalls[0], ans = -1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(check(stalls, k, middle)) {
                ans = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int test_case;
    cin >> test_case;
    cin.ignore();
    while (test_case--) {

        int k;
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        string in;
        getline(cin, in);
        stringstream sss(in);
        int num;
        while (sss >> num) {
            k = num;
        }
        Solution ob;
        int ans = ob.aggressiveCows(arr, k);
        cout << ans << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends