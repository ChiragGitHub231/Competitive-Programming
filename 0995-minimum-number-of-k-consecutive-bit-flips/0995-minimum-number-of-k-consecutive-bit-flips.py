class Solution:
    def minKBitFlips(self, nums: List[int], k: int) -> int:
        N=len(nums)
        flips=0
        flip=[False]*N
        current=0
        
        for i,x in enumerate(nums):
            if flip[i]:
                current^=1
            
            if (x^current)==0:
                flips+=1
                current^=1
                
                if i+k>N:
                    return -1
                if i+k<N:
                    flip[i+k]=True
        
        return flips