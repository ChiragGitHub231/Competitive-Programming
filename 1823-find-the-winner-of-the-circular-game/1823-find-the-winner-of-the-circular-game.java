class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList();
        for(int i=1; i<=n; i++) q.offer(i);
        while(q.size() > 1){
            int moves = k;
            while(moves-- > 1) q.offer(q.remove());
            q.remove();
        }
        return q.peek();
    }
}