class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> st = new ArrayDeque<>();
        st.push(new HashMap<>());
        
        int i = 0;
        int n = formula.length();
        
        while(i < n){
            if(formula.charAt(i) == '('){
                st.push(new HashMap<>());
                i++;
            } else if(formula.charAt(i) == ')'){
                i++;
                int start = i;
                
                while(i < n && Character.isDigit(formula.charAt(i))) i++;
                
                int value = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                Map<String, Integer> top = st.pop();
                for(String key : top.keySet()){
                    st.peek().put(key, st.peek().getOrDefault(key, 0) + top.get(key) * value);
                }
            } else {
                int start = i;
                i++;
                
                while(i < n && Character.isLowerCase(formula.charAt(i))) i++;
                
                String element = formula.substring(start, i);
                start = i;
                
                while(i < n && Character.isDigit(formula.charAt(i))) i++;
                
                int value = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                st.peek().put(element, st.peek().getOrDefault(element, 0) + value);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> finalCount = st.pop();
        
        List<String> elements = new ArrayList<>(finalCount.keySet());
        Collections.sort(elements);
        
        for(String element : elements){
            sb.append(element);
            int count = finalCount.get(element);
            if(count > 1) sb.append(count);
        }
        
        return sb.toString();
    }
}