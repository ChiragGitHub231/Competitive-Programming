class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        N = len(nums)
        nums.sort()
        
        left = 0
        right = nums[-1]
        
        def good(target):
            counter = 0
            right = 0
            
            for left in range(N):
                while right < N and nums[right] - nums[left] <= target:
                    right += 1
                counter += right - left - 1
            
            return counter >= k
        
        while left < right:
            mid = (left + right) // 2
            
            if good(mid):
                right = mid
            else:
                left = mid + 1
        
        return left