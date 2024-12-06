class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        b = set(banned)
        
        counter = 0
        total = 0
        
        for i in range(1, n + 1):
            if i in b:
                continue
            
            if total + i <= maxSum:
                counter += 1
                total += i
            else:
                break
        
        return counter