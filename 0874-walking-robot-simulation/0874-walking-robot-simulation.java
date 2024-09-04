class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();
        for(int[] obstacle : obstacles){
            obstacleSet.add(obstacle[0] + obstacle[1] * 40000);
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int result = 0;
        int x = 0, y = 0;
        int dir = 0;
        
        for(int command : commands){
            if(command == -1) dir = (dir + 1) % 4;
            else if(command == -2) dir = (dir + 3) % 4;
            else {
                int dx = dirs[dir][0];
                int dy = dirs[dir][1];
                for(int unused=0; unused<command; unused++){
                    int newX = x + dx;
                    int newY = y + dy;
                    if(!obstacleSet.contains(newX + newY * 40000)){
                        x = newX;
                        y = newY;
                        result = Math.max(result, x*x + y*y);
                    } else {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}