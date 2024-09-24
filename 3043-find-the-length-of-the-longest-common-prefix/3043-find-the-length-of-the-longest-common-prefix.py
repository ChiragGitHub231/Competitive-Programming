class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        s = set()
        
        for x in arr1:
            c = str(x)
            for i in range(1, len(c) + 1):
                s.add(c[:i])
        
        best = 0
        for x in arr2:
            c = str(x)
            for i in range(1, len(c) + 1):
                if c[:i] in s:
                    best = max(best, i)
        
        return best