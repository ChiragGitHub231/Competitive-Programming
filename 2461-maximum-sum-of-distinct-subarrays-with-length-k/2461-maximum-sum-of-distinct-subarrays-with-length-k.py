class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        seen = collections.Counter()
        N = len(nums)
        best = 0
        current = 0
        
        for right in range(N):
            seen[nums[right]] += 1
            current += nums[right]
            
            if right - k >= 0:
                seen[nums[right - k]] -= 1
                if seen[nums[right - k]] == 0:
                    del seen[nums[right - k]]
                current -= nums[right - k]
            
            if right - k + 1 >= 0:
                if len(seen) == k:
                    best = max(best, current)
        
        return best