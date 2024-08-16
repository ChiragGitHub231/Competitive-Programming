class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        ans = 0
        mini = 10000
        maxi = -10000
        
        for arr in arrays:
            ans = max(ans, arr[-1] - mini, maxi - arr[0])
            mini = min(mini, arr[0])
            maxi = max(maxi, arr[-1])
        
        return ans