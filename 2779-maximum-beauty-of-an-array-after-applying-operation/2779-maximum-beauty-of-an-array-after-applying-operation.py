class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        mx = max(nums)
        
        p = [0] * (mx + k + 2)
        for x in nums:
            p[max(x - k, 0)] += 1
            p[x + k + 1] -= 1
        
        for i in range(1, mx + k + 1):
            p[i] += p[i - 1]
        
        return max(p)