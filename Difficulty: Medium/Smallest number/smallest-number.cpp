//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    string smallestNumber(int s, int d) {
        // code here
        string ans="";
        int i=1;
        while(i<=d){
            int sum = s - (d - i) * 9 <= 0 ? 0 : s - (d - i) * 9;
            if(sum==0 and i==1) sum=1;
            if(sum>9) return "-1";
            ans+=(sum+'0');
            i++;
            s-=sum;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int s, d;
        cin >> s >> d;
        Solution ob;
        cout << ob.smallestNumber(s, d) << "\n";
    }

    return 0;
}
// } Driver Code Ends