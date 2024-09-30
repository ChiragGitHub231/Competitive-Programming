class CustomStack {
    
    List<Integer> list;
    int maxSize;
    
    public CustomStack(int maxSize) {
        list = new ArrayList<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(list.size() < maxSize) list.add(x);
    }
    
    public int pop() {
        return list.isEmpty() ? -1 : list.remove(list.size() - 1);
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<k && i<list.size(); i++) list.set(i, list.get(i) + val);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */