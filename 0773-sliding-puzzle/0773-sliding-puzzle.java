class Solution {
    private void dfs(String state, int currentMoves, Map<Integer, int[]> moves, Map<String, Integer> visited) {
    if (state.equals("123450")) {
        visited.put(state, Math.min(visited.getOrDefault(state, Integer.MAX_VALUE), currentMoves));
        return;
    }

    if (visited.containsKey(state) && visited.get(state) <= currentMoves) return;

    visited.put(state, currentMoves);
    int zeroLocation = state.indexOf('0');
    
    // Validate zeroLocation
    if (!moves.containsKey(zeroLocation)) return;
    
    int[] possibleMoves = moves.get(zeroLocation);
    
    for (int newLocation : possibleMoves) {
        char[] stateArray = state.toCharArray();
        
        // Swap zero with the new location
        char temp = stateArray[newLocation];
        stateArray[newLocation] = stateArray[zeroLocation];
        stateArray[zeroLocation] = temp;
        
        String newState = new String(stateArray);
        dfs(newState, currentMoves + 1, moves, visited);
    }
}

public int slidingPuzzle(int[][] board) {
    StringBuilder state = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            state.append(board[i][j]);
        }
    }
    
    Map<Integer, int[]> moves = new HashMap<>();
    moves.put(0, new int[]{1, 3});
    moves.put(1, new int[]{0, 2, 4});
    moves.put(2, new int[]{1, 5});
    moves.put(3, new int[]{0, 4});
    moves.put(4, new int[]{1, 3, 5});
    moves.put(5, new int[]{2, 4});
    
    Map<String, Integer> visited = new HashMap<>();
    dfs(state.toString(), 0, moves, visited);
    return visited.getOrDefault("123450", -1);
}

}