class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        N = len(arr)
        for x in range(N):
            if x+2 < N and arr[x] % 2 == 1  and arr[x+1] % 2 == 1 and arr[x+2] % 2 == 1:
                return True
        return False