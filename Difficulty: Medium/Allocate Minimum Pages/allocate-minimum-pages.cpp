//{ Driver Code Starts
// Initial function template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    bool check(vector<int>& arr, int k, int middle) {
        int number = 1, pages = 0;
        for(int i=0; i<arr.size(); i++) {
            if(arr[i] > middle) return false;
            if(pages + arr[i] > middle) {
                pages = arr[i];
                number++;
            } else {
                pages += arr[i];
            }
        }
        if(number <= k) return true;
        return false;
    }
  
    int findPages(vector<int> &arr, int k) {
        // code here
        if(arr.size() < k) return -1;
        int low = 0, high = 0;
        for(auto it : arr) high += it;
        int ans = -1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(check(arr, k, middle)) {
                ans = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
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

        int d;
        vector<int> arr, brr, crr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        getline(cin, input);
        ss.clear();
        ss.str(input);
        while (ss >> number) {
            crr.push_back(number);
        }
        d = crr[0];
        int n = arr.size();
        Solution ob;
        int ans = ob.findPages(arr, d);
        cout << ans << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends