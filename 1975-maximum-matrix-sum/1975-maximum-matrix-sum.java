class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long result = 0;
        int smallestNum = Integer.MAX_VALUE, countNegatives = 0, n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result += Math.abs(matrix[i][j]);
                smallestNum = Math.min(Math.abs(matrix[i][j]), smallestNum);
                if(matrix[i][j] < 0) countNegatives++;
            }
        }
        
        return countNegatives % 2 == 1 ? result - 2 * smallestNum : result;
    }
}