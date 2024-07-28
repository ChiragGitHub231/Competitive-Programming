class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i=0; i<=n; i++) graph[i] = new ArrayList<>();
        
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int[][] dist = new int[n+1][2];
        for(int i=1; i<=n; i++){
            dist[i][0] = Integer.MAX_VALUE;
            dist[i][1] = Integer.MAX_VALUE;
        }
        dist[1][0] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0], currentTime = current[1];
            int nextTime = currentTime + time;
            int cycle = currentTime / change;
            
            if(cycle % 2 == 1){
                int waitTime = change - (currentTime % change);
                nextTime += waitTime;
            }
            
            for(int neighbour : graph[node]){
                if(dist[neighbour][0] == Integer.MAX_VALUE){
                    dist[neighbour][0] = nextTime;
                    queue.offer(new int[]{neighbour, nextTime});
                }
                else if(dist[neighbour][0] < nextTime && nextTime < dist[neighbour][1]){
                    dist[neighbour][1] = nextTime;
                    queue.offer(new int[]{neighbour, nextTime});
                }
            }
        }
        
        return dist[n][1];
    }
}