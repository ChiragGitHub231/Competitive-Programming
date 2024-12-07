class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        left = 1
        right = 10 ** 9
        
        def good(target):
            counter = 0
            
            for x in nums:
                counter += ((x + target - 1) // target - 1)
            
            return counter <= maxOperations
        
        while left < right:
            middle = (left + right) // 2
            
            if good(middle):
                right = middle
            else:
                left = middle + 1
        
        return left