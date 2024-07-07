class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total=0, current_full=numBottles, current_empty=0;
        while(current_full>0){
            total+=current_full;
            current_empty+=current_full;
            current_full=0;
            current_full=(current_empty/numExchange);
            current_empty%=numExchange;
        }
        return total;
    }
}