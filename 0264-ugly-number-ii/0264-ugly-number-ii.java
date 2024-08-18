class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int p1 = 0, p2 = 0, p3 = 0;
        
        while(list.size() < n){
            int v1 = list.get(p1) * 2;
            int v2 = list.get(p2) * 3;
            int v3 = list.get(p3) * 5;
            int mini = Math.min(v1, Math.min(v2, v3));
            list.add(mini);
            if(mini == v1) p1++;
            if(mini == v2) p2++;
            if(mini == v3) p3++;
        }
        return list.get(list.size()-1);
    }
}