class Solution {
    public long maxPoints(int[][] points) {
        int cells = points[0].length;
        long[] current = new long[cells], previous = new long[cells];
        
        for(int[] row : points){
            long maxi = 0;
            for(int cols=0; cols<cells; cols++){
                maxi = Math.max(maxi-1, previous[cols]);
                current[cols] = maxi;
            }
            
            maxi = 0;
            for(int cols=cells - 1; cols>=0; cols--){
                maxi = Math.max(maxi-1, previous[cols]);
                current[cols] = Math.max(current[cols], maxi) + row[cols];
            }
            
            previous = current;
        }
        
        long maxPoints = 0;
        for(int col=0; col<cells; col++){
            maxPoints = Math.max(maxPoints, previous[col]);
        }
        
        return maxPoints;
    }
}