class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        int n = intervals.size();
        int s[n], e[n];
        
        for(int i=0; i<n; i++) {
            s[i] = intervals[i][0];
            e[i] = intervals[i][1];
        }
        
        sort(s, s+n);
        sort(e, e+n);
        
        int interval = 1, ans = 1, j = 0, i = 1;
        while(i < n && j < n) {
            if(s[i] <= e[j]) {
                interval++;
                i++;
            } else {
                interval--;
                j++;
            }
            ans = max(ans, interval);
        }
        
        return ans;
    }
};