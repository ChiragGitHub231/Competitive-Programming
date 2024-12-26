class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        int totalSum = accumulate(nums.begin(), nums.end(), 0);
    
    // Check if the transformed subset sum problem is valid
    if ((totalSum + target) % 2 != 0 || totalSum < abs(target)) {
        return 0;
    }
    
    int subsetSum = (totalSum + target) / 2;

    // DP array initialization
    vector<int> dp(subsetSum + 1, 0);
    dp[0] = 1; // There's one way to achieve a sum of 0 (no elements).

    // Fill the DP table
    for (int num : nums) {
        for (int j = subsetSum; j >= num; --j) {
            dp[j] += dp[j - num];
        }
    }

    return dp[subsetSum];
    }
};