class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])
        
        dp = [[False] * C for _ in range(R)]
        
        for i in range(R):
            dp[i][0] = True
        
        best = 0
        for j in range(1, C):
            for i in range(R):
                if dp[i][j-1] and grid[i][j-1] < grid[i][j]:
                    dp[i][j] = True
                if i-1 >= 0 and dp[i-1][j-1] and grid[i-1][j-1] < grid[i][j]:
                    dp[i][j] = True
                if i+1 < R and dp[i+1][j-1] and grid[i+1][j-1] < grid[i][j]:
                    dp[i][j] = True
                if dp[i][j]:
                    best = max(best, j)
        
        return best