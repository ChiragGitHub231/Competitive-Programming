class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        vector<int> degrees(n,0);
        for(auto &road:roads){
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        
        sort(degrees.begin(), degrees.end());
        
        long long result=0;
        for(long long i=1; i<=n; i++) result+=degrees[i-1]*i;
        
        return result;
    }
};