class Solution:
    def regionsBySlashes(self, grid: List[str]) -> int:
        R = len(grid)
        C = len(grid[0])
        
        ngrid = [[False] * (C * 3) for _ in range(R * 3)]
        
        for x in range(R):
            for y in range(C):
                if grid[x][y] == "\\":
                    ngrid[x*3][y*3] = ngrid[x*3+1][y*3+1] = ngrid[x*3+2][y*3+2] = True
                elif grid[x][y] == "/":
                    ngrid[x*3+2][y*3] = ngrid[x*3+1][y*3+1] = ngrid[x*3][y*3+2] = True
        
        directions = [ (1, 0), (0, 1), (-1, 0), (0, -1) ]
        def fill(sx, sy):
            q = collections.deque()
            q.append((sx, sy))
            ngrid[sx][sy] = True
            
            while len(q) > 0:
                x, y = q.popleft()
                
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < R * 3 and 0 <= ny < C * 3 and not ngrid[nx][ny]:
                        ngrid[nx][ny] = True
                        q.append((nx, ny))
        
        components = 0
        for x in range(R * 3):
            for y in range(C * 3):
                if not ngrid[x][y]:
                    components += 1
                    fill(x, y)
        
        return components