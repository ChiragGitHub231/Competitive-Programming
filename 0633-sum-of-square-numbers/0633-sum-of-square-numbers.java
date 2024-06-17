class Solution {
    public boolean judgeSquareSum(int c) {
        int root=(int)Math.sqrt(c);
        for(int i=0; i<=root; i++){
            double b=Math.sqrt(c-(i*i));
            if(b==(int)b) return true;
        }
        return false;
    }
}