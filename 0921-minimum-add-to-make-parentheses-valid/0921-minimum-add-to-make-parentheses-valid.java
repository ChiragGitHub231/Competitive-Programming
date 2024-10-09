class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(') st.push(ch);
            else if(st.size() > 0 && st.peek() == '(') st.pop();
            else st.push(ch);
        }
        return st.size();
    }
}