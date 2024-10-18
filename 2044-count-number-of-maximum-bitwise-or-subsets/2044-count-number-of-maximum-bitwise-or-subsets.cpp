class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        int n = nums.size();
        int i, j, x = 0, tc = 0;
        
        for(i=0; i<n; i++) x |= nums[i];
        
        int p = pow(2, n);
        for(i=1; i<p; i++) {
            int cv = 0;
            for(j=0; j<n; j++) {
                int v = 1 << j;
                if(v & i) cv |= nums[j];
            }
            if(cv == x) tc++;
        }
        
        return tc;
    }
};