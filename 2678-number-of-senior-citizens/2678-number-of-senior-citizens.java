class Solution {
    public int countSeniors(String[] details) {
        int counter = 0;
        for(int i=0; i<details.length; i++){
            if( ( (details[i].charAt(11)-'0') * 10) + (details[i].charAt(12)-'0') > 60) counter++;
        }
        return counter;
    }
}