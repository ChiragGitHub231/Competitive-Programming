class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        map<vector<int>, int> mp;
        int ans = 0;
        for(auto& row : matrix) {
            vector<int> v;
            if(row[0]) v = row;
            else for(auto& i : row) v.push_back(i ^ 1);
            ans = max(ans, ++mp[v]);
        }
        return ans;
    }
};