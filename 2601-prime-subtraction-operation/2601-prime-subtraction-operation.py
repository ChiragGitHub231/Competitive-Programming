class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        N = len(nums)
        
        primes = [True] * 1005
        primes[0] = primes[1] = False;
        
        for i in range(2, 1001):
            if primes[i]:
                j = i * i
                while j <= 1000:
                    primes[j] = False
                    j += i
        
        for i in range(N):
            if i == 0:
                for j in range(1, nums[i]):
                    if primes[nums[i] - j]:
                        nums[i] = j
                        break
            else:
                for j in range(nums[i-1] + 1, nums[i]):
                    if primes[nums[i] - j]:
                        nums[i] = j
                        break
        
        for i in range(N - 1):
            if nums[i] >= nums[i + 1]:
                return False
        
        return True