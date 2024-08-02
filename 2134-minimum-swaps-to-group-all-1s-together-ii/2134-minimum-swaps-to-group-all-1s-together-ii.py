class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        N = len(nums)
        total_ones = nums.count(1)
        l = windows_ones = max_windows_ones = 0
        
        for i in range(2 * N):
            if nums[i % N]:
                windows_ones += 1
            if i-l+1 > total_ones:
                windows_ones -= nums[l % N]
                l += 1
            max_windows_ones = max(max_windows_ones, windows_ones)
        
        return total_ones - max_windows_ones