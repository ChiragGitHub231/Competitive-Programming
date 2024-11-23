class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        rows = len(box)
        columns = len(box[0])
        
        box2 = [[""] * rows for _ in range(columns)]
        
        for x in range(rows):
            for y in range(columns):
                box2[y][rows - x - 1] = box[x][y]
        
        rows, columns = columns, rows
        for y in range(columns):
            bottom = rows - 1
            top = rows - 2
            
            while bottom >= 0:
                while top >= 0 and box2[top][y] == ".":
                    top -= 1
                
                if top >= bottom:
                    top = bottom - 1
                
                if box2[bottom][y] == ".":
                    if 0 <= top < bottom and box2[top][y] == "#":
                        box2[bottom][y] = "#"
                        box2[top][y] = "."
                        top -= 1
                
                bottom -= 1
                if box2[bottom][y] == "*" and top == bottom:
                    top -= 1
            
        return box2