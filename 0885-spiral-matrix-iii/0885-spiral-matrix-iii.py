class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        directions = [ (0, 1), (1, 0), (0, -1), (-1, 0) ]
        
        seen = set()
        x, y = rStart, cStart
        d = 0
        ans = [[x, y]]
        seen.add((x, y))
        
        while len(ans) < rows * cols:
            dx, dy = directions[d]
            nx, ny = x + dx, y + dy
            
            if 0 <= nx < rows and 0 <= ny < cols:
                ans.append((nx, ny))
                seen.add((nx, ny))
            x, y = nx, ny
            
            rd = (d + 1) % 4
            dx, dy = directions[rd]
            nx, ny = x + dx, y + dy
            
            if(nx, ny) not in seen:
                d = rd
        
        return ans