class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        N = len(code)
        new_code = [0] * N
        
        for index in range(N):
            if k > 0:
                total = 0
                for x in range(1, k+1):
                    total += code[(index + x) % N]
                new_code[index] = total
            elif k < 0:
                total = 0
                for x in range(1, -k+1):
                    total += code[(index - x) % N]
                new_code[index] = total
            else:
                new_code[index] = 0
        
        return new_code