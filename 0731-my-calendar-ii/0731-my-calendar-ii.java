class MyCalendarTwo {

    TreeMap<Integer, Integer> bookings;
    
    public MyCalendarTwo() {
        bookings = new TreeMap<>();    
    }
    
    public boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);
        int total = 0;
        for(Integer val : bookings.values()){
            total += val;
            if(total > 2){
                bookings.put(start, bookings.get(start) - 1);
                bookings.put(end, bookings.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */