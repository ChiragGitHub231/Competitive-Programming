class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])
        INF = 10 ** 20
        
        h = []
        heapq.heappush(h, (0, 0, 0))
        distance = [[INF] * C for _ in range(R)]
        
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        
        while len(h) > 0:
            d, x, y = heapq.heappop(h)
            
            if d > distance[x][y]:
                continue
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                
                if 0 <= nx < R and 0 <= ny < C:
                    nd = d
                    
                    if grid[nx][ny] == 1:
                        nd += 1
                    
                    if distance[nx][ny] > nd:
                        distance[nx][ny] = nd
                        heapq.heappush(h, (nd, nx, ny))
        
        return distance[R - 1][C - 1]