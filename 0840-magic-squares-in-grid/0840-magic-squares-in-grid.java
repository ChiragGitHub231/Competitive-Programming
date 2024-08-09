class Solution {
    public int findRowSum(int[][] grid, int r, int c){
        boolean visited[] = new boolean[10];
        int sum = 0;
        for(int i=0; i<3; i++){
            int rowSum = 0;
            for(int j=0; j<3; j++){
                int value = grid[r+i][c+j];
                if(value==0 || value>=10 || visited[value]) return -1;
                visited[value] = true;
                rowSum += value;
            }
            if(i == 0) sum = rowSum;
            else {
                if(sum != rowSum) return -1;
            }
        }
        return sum;
    }
    
    public int findColumnSum(int[][] grid, int r, int c){
        boolean visited[] = new boolean[10];
        int sum = 0;
        for(int j=0; j<3; j++){
            int columnSum = 0;
            for(int i=0; i<3; i++){
                int value = grid[r+i][c+j];
                columnSum += value;
            }
            if(j == 0) sum = columnSum;
            else {
                if(sum != columnSum) return -1;
            }
        }
        return sum;
    }
    
    public int findDiagonalSum(int[][] grid, int r, int c){
        int sum1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int sum2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        if(sum1 == sum2) return sum1;
        return -1;
    }
    
    public boolean isMagicSquare(int[][] grid, int r, int c){
        int rowSum = findRowSum(grid, r, c);
        if(rowSum == -1) return false;
        
        int columnSum = findColumnSum(grid, r, c);
        if(columnSum == -1) return false;
        
        int diagonalSum = findDiagonalSum(grid, r, c);
        if(diagonalSum == -1) return false;
        
        if(rowSum == columnSum && rowSum == diagonalSum) return true;
        return false;
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        int counter = 0;
        for(int i=0; i<grid.length-2; i++){
            for(int j=0; j<grid[0].length-2; j++){
                if(isMagicSquare(grid, i, j)) counter++;
            }
        }
        return counter;
    }
}