class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        N = len(piles)
        negInf = -float("inf")
        
        cache = [[0] * (N + 1) for _ in range(N + 1)]
        has_cache = [[False] * (N + 1) for _ in range(N + 1)]
        
        def get_max_delta(index, M):
            if index == N:
                return 0
            
            if has_cache[index][M]:
                return cache[index][M]
            
            best = negInf
            for i in range(1, 2 * M + 1):
                stones = sum(piles[index:index+i])
                score = stones - get_max_delta(min(index + i, N), min(max(M, i), N))
                best = max(best, score)
            
            has_cache[index][M] = True
            cache[index][M] = best
            return best
        
        total = sum(piles)
        max_delta = get_max_delta(0, 1)
        return (total + max_delta) // 2