class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int targetArrival = times[targetFriend][0];
        
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        
        for(int i=0; i<n; i++) chairs.add(i);
        
        PriorityQueue<int[]> leaving = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0; i<n; i++){
            while(!leaving.isEmpty() && leaving.peek()[0] <= times[i][0]) chairs.add(leaving.remove()[1]);
            if(times[i][0] == targetArrival) break;
            leaving.add(new int[] {times[i][1], chairs.remove()});
        }
        
        return chairs.peek();
    }
}