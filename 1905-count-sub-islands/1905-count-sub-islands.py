class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        rows = len(grid1)
        cols = len(grid1[0])
        
        done = [[False] * cols for _ in range(rows)]
        good = False
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        def dfs(x, y):
            if grid2[x][y] == 1 and grid1[x][y] == 0:
                nonlocal good
                good = False
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
            
                if 0 <= nx < rows and 0 <= ny < cols:
                    if grid2[nx][ny] == 1 and not done[nx][ny]:
                        done[nx][ny] = True
                        dfs(nx, ny)
        
        counter = 0
        for x in range(rows):
            for y in range(cols):
                if not done[x][y] and grid2[x][y]:
                    good = True
                    done[x][y] = True
                    dfs(x, y)
                    if good:
                        counter += 1
                        
        return counter