class Solution:
    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        N = len(nums)
        prefix = []
        
        mask = (1 << maximumBit) - 1
        for x in nums:
            prefix.append(mask ^ x)
            mask ^= x
        
        prefix.reverse()
        return prefix