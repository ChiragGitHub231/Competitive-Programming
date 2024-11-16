class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        N = len(nums)
        ans = []
        
        for start in range(N - k + 1):
            good = True
            for i in range(k - 1):
                if nums[start + i] + 1 != nums[start + i + 1]:
                    good = False
            
            if good:
                ans.append(nums[start + k - 1])
            else:
                ans.append(-1)
        
        return ans;