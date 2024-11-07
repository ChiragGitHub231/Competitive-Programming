class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int counter = 0;
            for(int j=0; j<candidates.size(); j++) {
                if(candidates[j] & (1 << i)) counter++;
            }
            ans = max(ans, counter);
        }
        return ans;
    }
};