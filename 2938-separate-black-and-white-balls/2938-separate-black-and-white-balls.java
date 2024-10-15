class Solution {
    public long minimumSteps(String s) {
        int n = s.length() - 1;
        long result = 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '1') {
                result += n - i;
                n--;
            }
        }
        return result;
    }
}