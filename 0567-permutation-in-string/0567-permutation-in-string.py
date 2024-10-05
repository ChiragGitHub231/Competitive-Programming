class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        N1 = len(s1)
        N2 = len(s2)
        
        f1 = collections.Counter(s1)
        fwindow = collections.Counter()
        
        left = 0
        for right in range(N2):
            fwindow[s2[right]] += 1
            
            left = right - N1
            if left >= 0:
                fwindow[s2[left]] -= 1
            
            if f1 == fwindow:
                return True
        
        return False