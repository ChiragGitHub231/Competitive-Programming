class Solution {
public:
    void make_graph(vector<vector<int>>& graph, vector<vector<int>>& edges) {
        for(auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
    }
    
    int get_furthest_node(vector<vector<int>>& graph) {
        queue<int> q;
        q.push(0);
        vector<int> visited(graph.size(), 0);
        visited[0] = 1;
        int last = 0;
        while(q.size() > 0) {
            int p = q.front();
            q.pop();
            last = p;
            for(auto& neighbour : graph[p]) {
                if(visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    q.push(neighbour);
                }
            }
        }
        return last;
    }
    
    int get_distance(vector<vector<int>>& graph, int i) {
        queue<int> q;
        q.push(i);
        vector<int> visited(graph.size(), 0);
        visited[i] = 1;
        int current = -1;
        while(q.size() > 0) {
            current++;
            int s = q.size();
            while(s > 0) {
                s--;
                int p = q.front();
                q.pop();
                
                for(auto& neighbour : graph[p]) {
                    if(visited[neighbour] == 0) {
                        visited[neighbour] = 1;
                        q.push(neighbour);
                    }
                }
            }
        }
        return current;
    }
    
    int minimumDiameterAfterMerge(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        int m = edges1.size() + 1, n = edges2.size() + 1;
        vector<vector<int>> graph1(m), graph2(n);
        
        make_graph(graph1, edges1);
        make_graph(graph2, edges2);
        
        int node1 = get_furthest_node(graph1);
        int distance1 = get_distance(graph1, node1);
        
        int node2 = get_furthest_node(graph2);
        int distance2 = get_distance(graph2, node2);
        
        int radius1 = (distance1 + 1) / 2;
        int radius2 = (distance2 + 1) / 2;
        
        return max({radius1 + radius2 + 1, distance1, distance2});
    }
};