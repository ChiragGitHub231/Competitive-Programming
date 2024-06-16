class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        right=0
        counter=0
        
        for x in nums:
            while n>right and x>right+1:
                right+=right+1
                counter+=1
            right+=x
        
        while n>right:
            right+=right+1
            counter+=1
        return counter