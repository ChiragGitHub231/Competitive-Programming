class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        i, j = 0, 0
        n, m = len(str1), len(str2)
    
        while i < n and j < m:
            # Current characters
            ch1 = str1[i]
            ch2 = str2[j]
        
            # Check if characters match directly or can match with a single increment
            if ch1 == ch2 or (chr((ord(ch1) - ord('a') + 1) % 26 + ord('a')) == ch2):
                j += 1  # Move pointer in str2
        
            i += 1  # Move pointer in str1
    
        # If we've matched all characters in str2, return True
        return j == m