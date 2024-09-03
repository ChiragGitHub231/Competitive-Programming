class Solution {
    public int transform(int num){
        int result = 0;
        while(num != 0){
            result += num % 10;
            num /= 10;
        }
        return result;
    }
    
    public int convert(String s){
        int result = 0;
        for(char ch : s.toCharArray()){
            result += transform(ch - 'a' + 1);
        }
        return result;
    }
    
    public int getLucky(String s, int k) {
        int result = convert(s);
        for(int i=0; i<k-1; i++) result = transform(result);
        return result;
    }
}