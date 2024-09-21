class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while(res.size() < n){
            int current = res.getLast();
            if(current * 10 <= n){
                res.add(current * 10);
                continue;
            }
            while(current % 10 == 9 || current + 1 > n) current /= 10;
            res.add(current + 1);
        }
        return res;
    }
}